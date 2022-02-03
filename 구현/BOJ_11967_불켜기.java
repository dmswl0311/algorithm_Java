import java.io.*;
import java.util.*;

/**
 * 299040 3640 -> 300188 1388
 * 
 * @author CHO
 * @see https://www.acmicpc.net/problem/11967
 * @category 구현, BFS 
 * @warning 불 껐던 곳들 누적으로 저장해야 함 -> 나중에라도 방문할 수 있는지 여부 확인위해
 * 1시간 5분
 */

public class BOJ_11967_불켜기 {
	static class Pos {
		int x;
		int y;
		int a;
		int b;

		public Pos(int x, int y, int a, int b) {
			this.x = x;
			this.y = y;
			this.a = a;
			this.b = b;
		}
	}

	static StringTokenizer st;
	static int N;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] light = new boolean[N + 1][N + 1]; // 불 켜져있는지 유무
		light[1][1] = true; // (1,1)은 켜져있으므로
		ArrayList<Pos> list = new ArrayList<>();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Pos(x, y, a, b));
		} // 입력 완료
		int result = 1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 1, 1 });
		boolean[][] hubo = new boolean[N + 1][N + 1]; // ** 불 껐던 곳들 마킹. 나중에라도 갈 수 있기 때문에 누적되어야 함
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			// 현재 방에서 켤 수 있는 light 켜기
			for (int i = 0; i < list.size(); i++) {
				Pos next = list.get(i);
				if (next.x == cur[0] && next.y == cur[1]) {
					if (!light[next.a][next.b]) {
						light[next.a][next.b] = true;
						list.remove(i--); // 불 켰으므로 다시 끌일 없음 -> 삭제
						hubo[next.a][next.b] = true; // 아까 불킨곳 마킹
						result++;
					}
				}
			}
			// 불 다 키고나서 이동할 수 있는 곳 고름
			// 이동 가능한지 판단하는 코드
			boolean flag = false;
			Queue<int[]> q2 = new LinkedList<int[]>();
			q2.add(new int[] { cur[0], cur[1] });
			boolean[][] vis = new boolean[N + 1][N + 1]; // 어느 방향에서 왔는지 방문표시
			vis[cur[0]][cur[1]] = true;
			while (!q2.isEmpty()) {
				int[] cur2 = q2.poll();
				if (hubo[cur2[0]][cur2[1]]) {
					hubo[cur2[0]][cur2[1]] = false;
					q.add(new int[] { cur2[0], cur2[1] });
				}
				for (int j = 0; j < 4; j++) {
					int nx = cur2[0] + dir[j][0];
					int ny = cur2[1] + dir[j][1];
					if (isOkay(nx, ny) && !vis[nx][ny] && light[nx][ny]) {
						vis[nx][ny] = true;
						q2.add(new int[] { nx, ny });
					}
				}
			}
		}
		// 종료 조건이 없음
		System.out.println(result);
	}

	private static boolean isOkay(int nx, int ny) {
		return nx > 0 && nx < N + 1 && ny > 0 && ny < N + 1;
	}
}

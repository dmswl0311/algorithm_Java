import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 24672	496
 * @author CHO
 * @see https://www.acmicpc.net/problem/1584
 * @category BFS (PQ 사용)
 */
public class BOJ_1584_게임 {
	static class Pos implements Comparable<Pos> {
		int x;
		int y;
		int life;

		public Pos(int x, int y, int life) {
			super();
			this.x = x;
			this.y = y;
			this.life = life;
		}

		@Override
		public int compareTo(Pos o) {
			return this.life - o.life;
		}
	}

	static StringTokenizer st;
	static int[][] dangerMap, deathMap;
	static int result;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dangerMap = new int[501][501];
		deathMap = new int[501][501];
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken()); // 위험구역
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken()); // 위험구역 반대
			for (int i = Math.min(X1, X2); i <= Math.max(X1, X2); i++) {
				for (int j = Math.min(Y1, Y2); j <= Math.max(Y1, Y2); j++) {
					dangerMap[i][j] = 1;
				}
			}
		}
		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken()); // 죽음구역
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken()); // 죽음구역 반대
			for (int i = Math.min(X1, X2); i <= Math.max(X1, X2); i++) {
				for (int j = Math.min(Y1, Y2); j <= Math.max(Y1, Y2); j++) {
					deathMap[i][j] = 1;
				}
			}
		}
		result = -1;
		bfs(0, 0);
		System.out.println(result);
	}

	private static void bfs(int i, int j) {
		boolean[][] vis = new boolean[501][501];
		vis[i][j] = true;
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(i, j, 0)); // 좌표와 life

		while (!pq.isEmpty()) {
			Pos cur = pq.poll();
			int x = cur.x;
			int y = cur.y;
			int life = cur.life;
			if (x == 500 && y == 500) {
				result = life;
				return;
			}
			for (int d = 0; d < dir.length; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (nx >= 0 && ny >= 0 && nx <= 500 && ny <= 500 && deathMap[nx][ny] == 0) {
					if (!vis[nx][ny]) {
						vis[nx][ny] = true;
						pq.add(new Pos(nx, ny, life + dangerMap[nx][ny]));
					}
				}
			}
		}
	}
}

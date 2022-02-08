import java.io.*;
import java.util.*;

/**
 * 118412	680
 * @author CHO
 * @see https://www.acmicpc.net/problem/14923
 * @category BFS
 */

public class BOJ_14923_미로탈출 {
	static class Pos {
		int x;
		int y;
		int f;

		public Pos(int x, int y, int f) {
			super();
			this.x = x;
			this.y = y;
			this.f = f;
		}
	}

	static StringTokenizer st;
	static int N, M, eX, eY;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		st = new StringTokenizer(br.readLine());
		int sX = Integer.parseInt(st.nextToken());
		int sY = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		eX = Integer.parseInt(st.nextToken());
		eY = Integer.parseInt(st.nextToken());
		for (int n = 1; n < N+1; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 1; m < M+1; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료
		System.out.println(bfs(sX, sY));

	}

	private static int bfs(int sX, int sY) {
		int cnt = 0;
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(sX, sY, 0));
		boolean[][][] vis = new boolean[N+1][M+1][2];
		vis[sX][sY][0] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Pos cur = q.poll();
				if (cur.x == eX && cur.y == eY) {
					return cnt;
				}
				for (int i = 0; i < dir.length; i++) {
					int nx=cur.x+dir[i][0];
					int ny=cur.y+dir[i][1];
					if(isOkay(nx,ny)) {
						if(map[nx][ny]==0 && !vis[nx][ny][cur.f]) {
							vis[nx][ny][cur.f]=true;
							q.add(new Pos(nx, ny, cur.f));
						}else if(map[nx][ny]==1 && cur.f==0 && !vis[nx][ny][cur.f+1]) {
							vis[nx][ny][cur.f+1]=true;
							q.add(new Pos(nx, ny, cur.f+1));
						}
					}
				}
			}
			cnt++;
		}
		return -1;
	}

	private static boolean isOkay(int nx, int ny) {
		return nx>0 && ny>0 && nx<N+1 && ny<M+1;
	}
}

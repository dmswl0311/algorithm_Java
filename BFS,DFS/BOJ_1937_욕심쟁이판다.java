import java.io.*;
import java.util.*;

/**
 * ?
 * @author CHO
 * @see https://www.acmicpc.net/problem/1937
 * @category 구현
 */
public class BOJ_1937_욕심쟁이판다 {
	static class Pos implements Comparable<Pos> {
		int x;
		int y;
		int w;

		public Pos(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pos o) {
			if(this.w==o.w) {
				if(this.x==o.x) {
					return this.y-o.y;
				}
				return this.x-o.x;
			}
			return this.w-o.w;
		}

	}

	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int[][] ori;
	static int[][] dp;
	static int max;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static Queue<Pos> q;
	static boolean[][] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ori = new int[N][N];
		dp = new int[N][N];
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				ori[i][j] = map[i][j];
				pq.add(new Pos(i, j, map[i][j]));
			}
		} // 입력 완료
		max = 0;
		while(!pq.isEmpty()) {
			Pos cur=pq.poll();
			q = new LinkedList<>();
			vis = new boolean[N][N];
			bfs(cur.x, cur.y);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (vis[i][j])
						map[i][j] = ori[i][j];
				}
			}
		}
		System.out.println(max);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

	}

	public static void bfs(int i, int j) {
		int cnt = 0;
		q.add(new Pos(i, j));
		vis[i][j] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Pos cur = q.poll();
				int pre = map[cur.x][cur.y];
				map[cur.x][cur.y] = 0;
				for (int k = 0; k < dir.length; k++) {
					int nx = cur.x + dir[k][0];
					int ny = cur.y + dir[k][1];
					if (is(nx, ny) && pre > map[nx][ny] && !vis[nx][ny]) {
//						if(dp[nx][ny]>0) {
//							max = max < cnt+dp[nx][ny] ? cnt+dp[nx][ny] : max;
//							continue;
//						}
						vis[nx][ny] = true;
						q.add(new Pos(nx, ny));
					}
				}
			}
			cnt++;
		}
		dp[i][j] = cnt;
		max = max < cnt ? cnt : max;
	}

	private static boolean is(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < N;
	}
}

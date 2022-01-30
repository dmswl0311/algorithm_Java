import java.io.*;
import java.util.*;

/**
 * 14220	140
 * @author CHO
 * @see https://www.acmicpc.net/problem/4963
 * @category BFS
 */
public class BOJ_4963_섬의개수 {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };
	static int w, h;
	static int[][] map;
	static boolean[][] vis;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 완료
			vis = new boolean[h][w];
			q = new LinkedList<>();
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!vis[i][j] && map[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);

	}

	private static void bfs(int i, int j) {
		q.add(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			for (int k = 0; k < dir.length; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				if (isOkay(nx, ny) && !vis[nx][ny] && map[nx][ny] == 1) {
					vis[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}

	private static boolean isOkay(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < h && ny < w;
	}
}

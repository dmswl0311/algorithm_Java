package algo;

import java.io.*;
import java.util.*;

/**
 * 13636	128
 * @author CHO
 * @see https://www.acmicpc.net/problem/1245
 * @category BFS
 */
public class BOJ_1245_농장관리 {

	static StringTokenizer st;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
	static int N, M, total, cnt;
	static int[][] map;
	static boolean[][] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		int result=0;
		vis = new boolean[N][M];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (!vis[n][m]) {
					mountain(n, m);
					if(total==cnt) result++;
				}
			}
		}
		System.out.println(result);
	}

	private static void mountain(int x, int y) {
		total = 0;
		cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		vis[x][y] = true;
		while (!q.isEmpty()) {
			int s = q.size();
			while (s-- > 0) {
				int[] cur = q.poll();
				x = cur[0];
				y = cur[1];
				for (int i = 0; i < dir.length; i++) {
					int nx = x + dir[i][0];
					int ny = y + dir[i][1];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
						if (!vis[nx][ny] && map[nx][ny] == map[x][y]) {
							vis[nx][ny] = true;
							q.add(new int[] { nx, ny });
						} 
						if(map[nx][ny]!=map[x][y]) total++; //감싸는 전체 블럭 개수
						if (map[nx][ny] < map[x][y]) cnt++; //값이 작은 블럭 개수
					}
				}
			}
		}

	}
}

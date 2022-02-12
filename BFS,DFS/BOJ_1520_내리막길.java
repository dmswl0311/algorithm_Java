import java.io.*;
import java.util.*;

/**
 * 39264	352
 * @author CHO
 * @see https://www.acmicpc.net/problem/1520
 * @category DFS, DP
 */

public class BOJ_1520_내리막길 {
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static int[][] dp;
	static int result;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp=new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[n], -1);
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료
		result=dfs(0, 0);
		System.out.println(result);
	}

	public static int dfs(int x, int y) {
		if (x == N - 1 && y == M - 1) return 1; //목적지에 도착했을 때 +1
		if(dp[x][y]!=-1) return dp[x][y]; //방문한 곳이 아닐 경우
		dp[x][y]=0;
		for (int d = 0; d < dir.length; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if (is(nx, ny) && map[x][y] > map[nx][ny]) {
				dp[x][y]+=dfs(nx, ny);
			}
		}
		return dp[x][y];
	}

	public static boolean is(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < M;
	}
}

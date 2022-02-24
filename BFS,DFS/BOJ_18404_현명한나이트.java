import java.io.*;
import java.util.*;

/**
 * 29172	268
 * @author CHO
 * @see https://www.acmicpc.net/problem/18404
 * @category BFS
 */
public class BOJ_18404_현명한나이트 {
	static class Pos{
		int x;
		int y;
		int cnt;
		public Pos(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt= cnt;
		}
	}

	static StringTokenizer st;
	static int[][] dir = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };
	static int N, x, y, cnt;
	static int[][] con;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken()); // 나이트의 위치
		con = new int[N + 1][N + 1]; // 상대편 말 위치와 순서(순서를 저장)
		result=new int[M+1]; // 정답 배열
		cnt=M;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			con[x][y] = i+1; //1,2,3...으로 저장
		}
		bfs(X, Y);
		for (int i = 1; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}

	}

	private static void bfs(int i, int j) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(i,j,0));
		boolean[][] vis = new boolean[N + 1][N + 1];
		vis[i][j] = true;
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			if (con[cur.x][cur.y]>0) {
				result[con[cur.x][cur.y]]=cur.cnt;
				con[cur.x][cur.y]=0;
				cnt--;
				if(cnt==0) return;
			}
			for (int d = 0; d < dir.length; d++) {
				int nx = cur.x + dir[d][0];
				int ny = cur.y + dir[d][1];
				if (nx > 0 && ny > 0 && nx <= N && ny <= N && !vis[nx][ny]) {
					vis[nx][ny] = true;
					q.add(new Pos (nx, ny, cur.cnt+1));
				}
			}
		}
		return;
	}
}

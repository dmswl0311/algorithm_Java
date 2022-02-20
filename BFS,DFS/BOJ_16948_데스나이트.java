import java.io.*;
import java.util.*;

/**
 * 12252	96
 * @author CHO
 * @see https://www.acmicpc.net/problem/16948
 * @category BFS
 *
 */
public class BOJ_16948_데스나이트 {
	
	static StringTokenizer st;
	static int N,r1,c1,r2,c2;
	static int[][] dir= {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		r1=Integer.parseInt(st.nextToken());
		c1=Integer.parseInt(st.nextToken());
		r2=Integer.parseInt(st.nextToken());
		c2=Integer.parseInt(st.nextToken());
		System.out.println(bfs(r1,c1));

	}

	private static int bfs(int r1, int c1) {
		int cnt=0;
		Queue<int[]> q=new LinkedList<int[]>();
		q.add(new int[] {r1,c1});
		boolean[][] vis=new boolean[N][N];
		vis[r1][c1]=true;
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
				int[] cur=q.poll();
				if(cur[0]==r2 && cur[1]==c2) {
					return cnt;
				}
				for (int d = 0; d < dir.length; d++) {
					int nx=cur[0]+dir[d][0];
					int ny=cur[1]+dir[d][1];
					if(nx>=0 && ny>=0 && nx<N && ny<N && !vis[nx][ny]) {
						vis[nx][ny]=true;
						q.add(new int[] {nx,ny});
					}
				}
			}
			cnt++;
		}
		return -1;
	}
}

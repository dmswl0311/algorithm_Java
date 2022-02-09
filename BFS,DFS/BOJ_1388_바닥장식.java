import java.io.*;
import java.util.*;
/**
 * 12040	88
 * @author CHO
 * @see https://www.acmicpc.net/problem/1388
 * @category BFS
 */
public class BOJ_1388_바닥장식 {
	
	static StringTokenizer st;
	static int N,M;
	static char[][] map;
	static boolean[][] vis;
	static int[][] dir= {{0,-1},{0,1},{1,0},{-1,0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		for (int n = 0; n < N; n++) {
			String str=br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m]=str.charAt(m);
			}
		}// 입력 완료
		int result=0;
		vis=new boolean[N][M];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if(!vis[n][m]) {
					bfs(n,m);
					result++;
				}
			}
		}
		System.out.println(result);
	}
	public static void bfs(int n,int m) {
		Queue<int[]> q=new LinkedList<int[]>();
		q.add(new int[] {n,m});
		vis[n][m]=true;
		boolean flag=false;
		if(map[n][m]=='-') flag=true;
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			int nx=0;
			int ny=0;
			if(flag) {
				for (int i = 0; i < 2; i++) {
					nx=cur[0]+dir[i][0];
					ny=cur[1]+dir[i][1];
					
					if(isOkay(nx,ny) && !vis[nx][ny] && map[nx][ny]==map[cur[0]][cur[1]]) {
						vis[nx][ny]=true;
						q.add(new int[] {nx,ny});
					}
				}
			}else {
				for (int i = 2; i < 4; i++) {
					nx=cur[0]+dir[i][0];
					ny=cur[1]+dir[i][1];
					
					if(isOkay(nx,ny) && !vis[nx][ny] && map[nx][ny]==map[cur[0]][cur[1]]) {
						vis[nx][ny]=true;
						q.add(new int[] {nx,ny});
					}
				}
			}
			
		}
	}
	private static boolean isOkay(int x,int y) {
		return x>=0 && y>=0 && x<N && y<M;
	}
}

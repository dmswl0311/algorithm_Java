import java.io.*;
import java.util.*;

/**
 * 34752	300
 * @author CHO
 * @see https://www.acmicpc.net/problem/21736
 * @category BFS
 */
public class BOJ_21736_헌내기는친구가필요해 {
	
	static StringTokenizer st;
	static int dir[][]= {{1,0},{0,1},{-1,0},{0,-1}};
	static int N,M;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map=new char[N][M];
		int x=0,y=0;
		for (int i = 0; i < N; i++) {
			String str=br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='I') {
					x=i;
					y=j;
				}
			}
		}
		int result=bfs(x,y);
		System.out.println(result==0?"TT":result);

	}

	private static int bfs(int i, int j) {
		int cnt=0;
		Queue<int[]> q=new LinkedList<int[]>();
		q.add(new int[] {i,j});
		boolean[][] vis=new boolean[N][M];
		vis[i][j]=true;
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
				int[] cur=q.poll();
				if(map[cur[0]][cur[1]]=='P') {
					cnt++;
				}
				for (int d = 0; d < dir.length; d++) {
					int nx=cur[0]+dir[d][0];
					int ny=cur[1]+dir[d][1];
					if(nx>=0 && ny>=0 && nx<N && ny<M && !vis[nx][ny] && map[nx][ny]!='X') {
						vis[nx][ny]=true;
						q.add(new int[] {nx,ny});
					}
				}
			}
		}
		return cnt;
	}
}

package algo;

import java.io.*;
import java.util.*;

/**
 * 13708	92
 * @author CHO
 * @see https://www.acmicpc.net/problem/1303
 * @category BFS
 */
public class BOJ_1303_전투 {
	
	static StringTokenizer st;
	static int N,M;
	static boolean[][] vis;
	static Queue<int[]> q;
	static int[][] dir= {{0,1},{1,0},{-1,0},{0,-1}};
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map=new char[M][N];
		for (int i = 0; i < M; i++) {
			String str=br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j]=str.charAt(j);
			}
		}// 입력 완료
		// 우리팀은 W, 상대방은 B
		int w=0;
		int b=0;
		vis=new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!vis[i][j]) {
					int cnt=bfs(i,j);
					if(map[i][j]=='W') {
						w+=(cnt*cnt);
					}else {
						b+=(cnt*cnt);
					}
				}
			}
		}
		System.out.println(w+" "+b);
	}
	public static int bfs(int i,int j) {
		int n=1;
		vis[i][j]=true;
		q=new LinkedList<int[]>();
		q.add(new int[] {i,j});
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
				int[] cur=q.poll();
				for (int d = 0; d < dir.length; d++) {
					int nx=cur[0]+dir[d][0];
					int ny=cur[1]+dir[d][1];
					if(is(nx,ny) && !vis[nx][ny]) {
						 if(map[cur[0]][cur[1]]==map[nx][ny]) {
							vis[nx][ny]=true;
							n++;
							q.add(new int[] {nx,ny});
						}
					}
				}
			}
		}
		return n;
	}
	public static boolean is(int i, int j) {
		return i>=0 && j>=0 && i<M && j<N;
	}
}

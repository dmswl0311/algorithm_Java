import java.io.*;
import java.util.*;

/**
 * 13640	136
 * @author CHO
 * @see https://www.acmicpc.net/user/whdmswlek
 * @category BFS
 */
public class BOJ_1743_음식물피하기 {
	
	static StringTokenizer st;
	static int N,M,K,max;
	static int[][] map;
	static int[][] dir= {{0,1},{1,0},{-1,0},{0,-1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for (int j = 0; j < K; j++) {
			st=new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x-1][y-1]=1;
		}
		max=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) {
					int cnt=bfs(i,j);
					max=max<cnt?cnt:max;
				}
			}
		}
		System.out.println(max);
		
	}

	private static int bfs(int i, int j) {
		int cnt=0;
		Queue<int[]> q= new LinkedList<int[]>();
		q.add(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] cur= q.poll();
			int x=cur[0];
			int y=cur[1];
			for (int k = 0; k < dir.length; k++) {
				int nx=x+dir[k][0];
				int ny=y+dir[k][1];
				if(is(nx,ny) && map[nx][ny]==1) {
					map[nx][ny]=0;
					cnt++;
					q.add(new int[] {nx,ny});
				}
			}
		}
		return cnt;
	}
	public static boolean is(int i, int j) {
		return i>=0 && j>=0 && i<N && j<M;
	}
}

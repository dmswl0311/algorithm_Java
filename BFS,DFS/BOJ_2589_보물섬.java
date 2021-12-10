import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 292688	492
 * @author CHO
 * @see https://www.acmicpc.net/problem/2589
 * @category BFS
 */

public class BOJ_2589_보물섬 {
	
	static class xy{
		int x;
		int y;
		
		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static StringTokenizer st;
	static int L,W;
	static char[][] map;
	static int max;
	static boolean[][] visited;
	static Queue<xy> q;
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map=new char[L][W];
		for (int i = 0; i < L; i++) {
			String str=br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		max=Integer.MIN_VALUE;
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				visited=new boolean[L][W];
				q=new LinkedList<xy>();
				if(map[i][j]=='L') {
					int cal=bfs(i,j);
					max=max<cal?cal:max;
				}
			}
		}
		System.out.println(max-1);

	}

	private static int bfs(int x, int y) {
		int time=0;
		visited[x][y]=true;
		q.add(new xy(x, y));
		
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
				xy current=q.poll();
				int cx=current.x;
				int cy=current.y;
				for (int i = 0; i < 4; i++) {
					int nx=cx+dir[i][0];
					int ny=cy+dir[i][1];
					if(isOkay(nx,ny)) {
						if(map[nx][ny]=='L' && !visited[nx][ny]) {
							// 방문 가능
							visited[nx][ny]=true;
							q.add(new xy(nx, ny));
						}
					}
				}
			}
			time++;
		}
		return time;
	}

	private static boolean isOkay(int nx, int ny) {
		return nx>=0 && nx<L && ny>=0 && ny<W;
	}
}

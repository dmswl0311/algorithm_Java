import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 
 * @author CHO
 * @see https://www.acmicpc.net/problem/2636
 * @category BFS
 */
public class BOJ_2636_치즈 {
	static StringTokenizer st;
	static int R,C;
	static int[][] map; 
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st=new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// map 입력받기
		map=new int[R][C];
		for (int r = 0; r < R; r++) {
			st=new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 녹을 부분 고르기
		// 0,0은 무조건 외부 공기
		bfs(0,0);
	}
	private static void bfs(int r, int c) {
		Queue<int[]> q=new LinkedList<int[]>();
		Queue<int[]> cheese=new LinkedList<int[]>();
		boolean [][] visited=new boolean[R][C];
		
		q.add(new int[] {r,c});
		visited[r][c]=true;
		
		int hour=0;
		int prev=0;
		
		while(true) {
			while(!q.isEmpty()) {
				int[] list=q.poll();
				int x=list[0];
				int y=list[1];
				for (int i = 0; i < 4; i++) {
					int nx=x+dir[i][0];
					int ny=y+dir[i][1];
					if(isOkay(nx,ny)&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						if(map[nx][ny]==0) {
							q.add(new int[] {nx,ny});
						}else {
							cheese.add(new int[] {nx,ny});
							map[nx][ny]=0;
							// 굳이 안해줘도 됨~ cheese에 있는거
						}
					}
				}
			}
			// 더이상 녹일 치즈가 없다면 
			if(cheese.size()==0) {
				System.out.println(hour);
				System.out.println(prev);
				return;
			}
			// 더 녹일 수 있다면
			hour++;
			prev=cheese.size();
			q.addAll(cheese);
			cheese.clear();
		}
		
	}
	private static boolean isOkay(int nx, int ny) {
		return nx>=0 && ny>=0 && nx<R && ny<C;
	}

}

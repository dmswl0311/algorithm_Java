import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 51744	512
 * @author CHO
 * @see https://www.acmicpc.net/problem/2573
 * @category 구현, DFS
 * 주의! 초기 map에서도 빙산 덩어리 구하기
 */
public class BOJ_2573_빙산 {
	static class Ice{
		int x;
		int y;
		int cnt;
		
		public Ice(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	static StringTokenizer st;
	static int N,M;
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				
			}
		}// 입력 완료
		
		int c=0; // 빙산 덩어리 개수
		
		// 주의! 초기 맵에서 빙산 덩어리 구하기, 만약 2개 이상이라면 그대로 끝남
		boolean[][] visited=new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j]&&map[i][j]!=0) {
					if(dfs(visited,i,j)) c++;
				}
			}
		}
		if(c>=2) System.out.println(0);
		else {
			c=0;
			int time=0;
			
			while(true) {
				if(c>=2) {
					System.out.println(time);
					break;
				}
				// 주의! c 초기화
				c=0;
				int zero=0;
				
				// 녹일 빙산 리스트 만들기
				ArrayList<Ice> melt=new ArrayList<>(); // 녹일 빙산들 
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if(map[i][j]!=0) {
							int cnt=0;
							int x=i;
							int y=j;
							for (int d = 0; d < 4; d++) {
								int nx=x+dir[d][0];
								int ny=y+dir[d][1];
								if(isIn(nx,ny)&&map[nx][ny]==0) cnt++;
							}
							if(cnt>0) melt.add(new Ice(x, y, cnt));
						}else zero++;
						
					}
				}
				
				// 모든 빙산이 다 녹았는데 끝나지 않았다면
				if(zero==N*M) {
					System.out.println(0);
					break;
				}
				
				// 빙산 녹이기
				for (int i = 0; i < melt.size(); i++) {
					Ice ice=melt.get(i);
					if(map[ice.x][ice.y]-ice.cnt<=0) map[ice.x][ice.y]=0;
					else map[ice.x][ice.y]-=ice.cnt;
				}
				
				// 빙산 덩어리 구하기
				visited=new boolean[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if(!visited[i][j]&&map[i][j]!=0) {
							if(dfs(visited,i,j)) c++;
						}
					}
				}
				time++;
	//			System.out.println(time+"년 일때, 덩어리 수 : "+c);
				
				
			}
		}
		
	}
	private static boolean dfs(boolean[][] visited,int x, int y) {
		if(map[x][y]!=0) {
			visited[x][y]=true;
			for (int i = 0; i < 4; i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if(isIn(nx, ny)&&!visited[nx][ny]&&map[nx][ny]!=0) {
					dfs(visited, nx, ny);
				}
			}
			
			return true;
		}
		return false;
	}
	private static boolean isIn(int nx, int ny) {
		return nx>=0 && ny>=0 && nx<N && ny<M;
	}

}

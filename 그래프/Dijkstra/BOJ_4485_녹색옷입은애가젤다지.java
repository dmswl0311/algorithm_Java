import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 23108	1232
 * @author CHO
 * @see https://www.acmicpc.net/problem/4485
 * @category Dijkstra
 * 루피를 가중치로 두고 그래프 탐색 -> 다익스트라
 * DFS로 풀면 시간초과->왜? -> 가중치가 있는 그래프이기 때문에 x
 */
public class BOJ_4485_녹색옷입은애가젤다지 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=0;
		while(true) {
			N=Integer.parseInt(br.readLine());
			if(N==0) break;
			map=new int[N][N];
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}// 입력 완료
			
			visited=new boolean[N][N];
			int[][] distance=new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			distance[0][0]=map[0][0];
			for (int n = 0; n < N*N; n++) {
				int minX=-1;
				int minY=-1;
				int min=Integer.MAX_VALUE;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(!visited[i][j] && min>distance[i][j]) {
							minX=i;
							minY=j;
							min=distance[i][j];
						}
					}
				}
				visited[minX][minY]=true;
				if(minX==N-1 && minY==N-1) break;
				
				// 연결된 것들의 distance값 갱신
				for (int i = 0; i < 4; i++) {
					int nx=minX+dir[i][0];
					int ny=minY+dir[i][1];
					if(isOkay(nx,ny)&&!visited[nx][ny]&&distance[nx][ny]>min+map[nx][ny]) {
						distance[nx][ny]=min+map[nx][ny];
					}
					
				}
			}
			
			t++;
			sb.append("Problem ").append(t).append(": ").append(distance[N-1][N-1]).append("\n");
			
		}
		System.out.println(sb);

	}
	
	private static boolean isOkay(int nx, int ny) {
		return nx>=0 && ny>=0 && nx<N && ny<N;
	}
}
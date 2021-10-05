import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 31,216 kb 129 ms
 * @author CHO
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq
 * @category BFS
 * 주의! BFS+내가 가는 방향에 있는 파이프가 나와 연결될 수 있는지 확인
 */
public class SWEA_1953_탈주범검거 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	static int[][][] dir= {
			{},
			{{0,1},{0,-1},{1,0},{-1,0}},
			{{1,0},{-1,0}},
			{{0,-1},{0,1}},
			{{-1,0},{0,1}},
			{{1,0},{0,1}},
			{{0,-1},{1,0}},
			{{0,-1},{-1,0}}
	};
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			int R=Integer.parseInt(st.nextToken());
			int C=Integer.parseInt(st.nextToken());
			int L=Integer.parseInt(st.nextToken());
			
			map=new int[N][M];
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			} //입력 완료
			
			visited=new boolean[N][M];
			bfs(R,C,L);

			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);

	}
	private static void bfs(int r, int c, int L) {
		int time=1; // 소요시간
		cnt=1; // 맨홀 개수
		Queue<int[]> q=new LinkedList<int[]>();
		q.add(new int[] {r,c});
		visited[r][c]=true;
		
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
				int[] curr=q.poll();
				int x=curr[0];
				int y=curr[1];
//				System.out.println("현재 방문한 곳 x:"+x+" y:"+y);
				if(L==time) return;
				// map에 적혀있는 방향대로 탐색
				for (int i = 0; i < dir[map[x][y]].length; i++) {
					int nx=x+dir[map[x][y]][i][0];
					int ny=y+dir[map[x][y]][i][1];
					if(isIn(nx,ny)&&!visited[nx][ny]&&map[nx][ny]!=0) {
						// 주의! + 앞에꺼 확인
						boolean flag=false;
						for (int j = 0; j < dir[map[nx][ny]].length; j++) {
							int fx=nx+dir[map[nx][ny]][j][0];
							int fy=ny+dir[map[nx][ny]][j][1];
							if(fx==x && fy==y) {
								flag=true;
								break;
							}
						}
						if(flag) {
//							System.out.println("갈수 있는 곳 nx:"+nx+" ny:"+ny);
							cnt++;
							q.add(new int[] {nx,ny});
							visited[nx][ny]=true;
						}
					}
				}
			}
			time++;
		}
		
	}
	private static boolean isIn(int nx, int ny) {
		return nx>=0 && ny>=0 && nx<N && ny<M;
	}

}

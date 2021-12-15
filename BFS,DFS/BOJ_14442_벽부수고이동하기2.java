import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 371520	1112
 * @author CHO
 * @see https://www.acmicpc.net/problem/14442
 * @category BFS, visited 3차원 
 * 2206의 연장선 문제
 *
 */
public class BOJ_14442_벽부수고이동하기2 {
	 static StringTokenizer st;
	 static int N,M,K;
	 static int[][] map;
	 static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for (int i = 0; i < N; i++) {
			String str=br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}// 입력 완료
		// 출발지는 (0,0) 도착지는 (N-1,M-1)
		bfs(0,0);
		System.out.println(-1);
	}

	private static void bfs(int startx, int starty) {
		boolean[][][] visited=new boolean[N][M][K+1];
		visited[startx][starty][0]=true;
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {startx,starty,1,0}); //x,y좌표,거리,돌파한 벽 개수
		
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			int x=curr[0];
			int y=curr[1];
			int c=curr[2];
			int count=curr[3];
			if(x==N-1 && y==M-1) {
				System.out.println(c);
				System.exit(0);
			}
			for (int i = 0; i < 4; i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if(isOkay(nx,ny) && !visited[nx][ny][count]) {
					if(map[nx][ny]==1) {
						if(count<K) {
							visited[nx][ny][count]=true;
							q.add(new int[] {nx,ny,c+1,count+1});
						}
					}else {
						visited[nx][ny][count]=true;
						q.add(new int[] {nx,ny,c+1,count});
					}
				}
			}
		}
	}

	private static boolean isOkay(int nx, int ny) {
		return nx>=0 && ny>=0 && nx<N && ny<M;
	}
}

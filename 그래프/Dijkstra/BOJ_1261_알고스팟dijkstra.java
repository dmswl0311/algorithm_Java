import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 13200	108	
 * @author CHO
 * @see https://www.acmicpc.net/problem/1261
 * @category Dijkstra pq이용
 * DFS -> 시간초과
 */
public class BOJ_1261_알고스팟dijkstra {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int w;
		public Node(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
	}
	static StringTokenizer st;
	static int N,M;
	static int[][] map;
	static int min;
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean visited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for (int i = 0; i < N; i++) {
			String str=br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}// 입력 완료
		
		min=Integer.MAX_VALUE;
		// 출발지는 (0,0) 도착지는(N-1,M-1)
		visited=new boolean[N][M];
		int[][] distance=new int[N][M];
		//Arrays.fill(distance, Integer.MAX_VALUE);  Arrays.fill은 1차원 배열에서만 사용 가능
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				distance[i][j]=Integer.MAX_VALUE;
			}
		}
		distance[0][0]=0;
		
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(0, 0 ,0));
		while(!pq.isEmpty()) {
			Node curr=pq.poll();
			int x=curr.x;
			int y=curr.y;
			int w=curr.w;
			if(x==N-1 && y==M-1) break;
			if(visited[x][y]) continue;
			visited[x][y]=true;
			for (int i = 0; i < 4; i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if(isOkay(nx,ny) && !visited[nx][ny]) {
					if(distance[nx][ny]>w+map[nx][ny]) {
						distance[nx][ny]=w+map[nx][ny];
						pq.add(new Node(nx, ny, distance[nx][ny]));
					}
				}
			}
		}// 최단거리 구하기 
		System.out.println(distance[N-1][M-1]);
	}

	private static boolean isOkay(int nx, int ny) {
		return nx>=0 && ny>=0 && nx<N && ny<M;
	}
}

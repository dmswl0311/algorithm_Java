import java.io.*;
import java.util.*;

/**
 * 22936	176
 * @author CHO
 * @see https://www.acmicpc.net/problem/19238
 * @category 구현, BFS-3차원 배열, * 출발지는 다르지만 목적지는 같을 수 있다!
 */
public class BOJ_19238_스타트택시 {
	static class Position implements Comparable<Position>{
		int x;
		int y;
		int distance;

		public Position(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Position o) {
			if(this.distance == o.distance) {
				if(this.x==o.x) {
					return this.y-o.y;
				}
				return this.x-o.x;
			}
			return this.distance-o.distance;
		}
	}

	static StringTokenizer st;
	static int N, M, F;
	static int[][] map;
	static int[][][] list;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Position cur;
	static int person;

	public static void main(String[] args) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		map=new int[N+1][N+1];
		list=new int[N+1][N+1][M+1];
		for (int i = 1; i < N+1; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				int num=Integer.parseInt(st.nextToken());
				map[i][j]=num;
			}
		}
		st=new StringTokenizer(br.readLine());
		int startX=Integer.parseInt(st.nextToken());
		int startY=Integer.parseInt(st.nextToken());
		for (int i = 1; i < M+1; i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			list[x][y][0]=i; 
			list[x2][y2][i]=i; 
		}
		
		bfs(startX,startY);
		
		boolean flag=confirm();
		if(flag) System.out.println(F);
		else System.out.println(-1);
	}

	private static boolean confirm() {
		boolean flag=true;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				for (int k = 0; k < M+1; k++) {
					if(list[i][j][k]!=0) {
						flag=false;
					}
				}
			}
		}
		return flag;
	}

	private static void bfs(int startX, int startY) {
		int cnt = 0;
		PriorityQueue<Position> q = new PriorityQueue<>();
		q.add(new Position(startX, startY, 0));
		boolean[][] visited = new boolean[N + 1][N + 1];
		visited[startX][startY] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Position cur = q.poll();
				int x = cur.x;
				int y = cur.y;
				
				if(list[x][y][0]>0) {
					person=list[x][y][0];
					list[x][y][0]=0;
					destination(x,y);
					return;
				}
				for (int i = 0; i < 4; i++) {
					int nx = x + dir[i][0];
					int ny = y + dir[i][1];
					if (isOkay(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
						visited[nx][ny] = true;
						q.add(new Position(nx, ny, cnt));
					}
				}
			}
			cnt++;
			F--; 
			if(F<0) {
				System.out.println(-1);
				System.exit(0);
			}
		}

	}

	private static void destination(int startX, int startY) {
		int cnt = 0;
		PriorityQueue<Position> q = new PriorityQueue<>();
		q.add(new Position(startX, startY, 0));
		boolean[][] visited = new boolean[N + 1][N + 1];
		visited[startX][startY] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Position cur = q.poll();
				int x = cur.x;
				int y = cur.y;
				if(list[x][y][person]>0) {
					list[x][y][person]=0;
					F=F+2*(cnt);
					if(confirm()) return;
					bfs(x,y);
					return;
				}
				for (int i = 0; i < 4; i++) {
					int nx = x + dir[i][0];
					int ny = y + dir[i][1];
					if (isOkay(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
						visited[nx][ny] = true;
						q.add(new Position(nx, ny, cnt));
					}
				}
			}
			cnt++;
			F--; 
			if(F<0) {
				System.out.println(-1);
				System.exit(0);
			}
		}

	}
	private static boolean isOkay(int nx, int ny) {
		return nx > 0 && ny > 0 && nx < N + 1 && ny < N + 1;
	}
}

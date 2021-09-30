import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 11896	84
 * @author CHO
 * @see https://www.acmicpc.net/problem/3055
 * @category 구현, BFS
 * 물의 이동과 고슴도치의 이동시간 비교 -> BFS를 따로 사용
 * 주의! 물의 이동이 0일때 고슴도치 이동 O, 물의 이동 시간 vs 고슴도치의 이동시간+1
 * BOJ 4179 불!과 유사한 문제
 */
public class BOJ_3055_탈출 {
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
	static int R,C;
	static char[][] map;
	static int[][] map_water;
	static boolean[][] visited;
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map=new char[R][C];
		map_water=new int[R][C];
		
		Queue<xy> q=new LinkedList<>();
		visited=new boolean[R][C];
		int sx=0;
		int sy=0;
		for (int i = 0; i < R; i++) {
			String str=br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j]=str.charAt(j);
				// 물의 위치 -> bfs 돌려줄거라서 바로 queue에 넣음
				if(map[i][j]=='*') {
					q.add(new xy(i, j));
					visited[i][j]=true;
					map_water[i][j]=1;
				}
				else if(map[i][j]=='S') {
					// 고슴도치 시작위치
					sx=i;
					sy=j;
				}
			}
		}// 입력완료
		
		// 물이 채워질 수 있는 시간 구함
		bfs_water(q);
		
		// 고슴도치가 이동할 수 있는 시간 구함
		int t=bfs(sx,sy,q);
		if (t==-1) System.out.println("KAKTUS");
		else System.out.println(t);
		
	}
	private static int bfs(int sx,int sy,Queue<xy> q) {
		q=new LinkedList<>();
		visited=new boolean[R][C];
		q.add(new xy(sx, sy));
		visited[sx][sy]=true;
		int time=1;
		
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
				xy curr=q.poll();
				int x=curr.x;
				int y=curr.y;
				if(map[x][y]=='D') return time-1;
				for (int i = 0; i < 4; i++) {
					int nx=x+dir[i][0];
					int ny=y+dir[i][1];
					if(isIn(nx,ny)&&!visited[nx][ny]) {
						if(map[nx][ny]=='X') continue;
						// 주의! 여기서 time+1 시간과 비교해야함 -> 현재칸 비교가 아니라 내가 다음에 가야할 칸이기 때문
						// 물의 시간이 0일때도 통과 가능 -> 물이 여기까지 퍼지지 않았다는거니까
						else if(time+1<map_water[nx][ny] || map_water[nx][ny]==0) {
							visited[nx][ny]=true;
							q.add(new xy(nx, ny));
						}
					}
				}
			}
			time++;
		}
		return -1;
	}
	private static void bfs_water(Queue<xy> q) {
		while(!q.isEmpty()) {
			xy curr=q.poll();
			int x=curr.x;
			int y=curr.y;
			// 물 비어있는 칸으로 확장
			for (int i = 0; i < 4; i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if(isIn(nx,ny)&&!visited[nx][ny]) {
					if(map[nx][ny]=='D') continue;
					else if(map[nx][ny]=='X') continue;
					else{
						visited[nx][ny]=true;
						map_water[nx][ny]=map_water[x][y]+1;
						q.add(new xy(nx, ny));
					}
				}
			}
		}
		
	}
	private static boolean isIn(int nx, int ny) {
		return nx>=0 && ny>=0 && nx<R && ny<C;
	}

}

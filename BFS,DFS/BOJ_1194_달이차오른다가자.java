import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 13864	108
 * @author CHO
 * @see https://www.acmicpc.net/problem/1194
 * @category BFS, 비트마스킹
 * 비트마스킹으로 키와 대문 처리
 * 키의 유무로 방문 처리 -> BFS visited 3차원
 * 주의! 키가 바뀌지 않은 상황에서 방문처리 
 * BOJ 1600 말이되고픈원숭이와 유사
 */
public class BOJ_1194_달이차오른다가자 {
	static class Minsik{
		int x;
		int y;
		int key;
		
		public Minsik(int x, int y, int key) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
		}
		
		// 비트마스킹
		// 키 비교 &
		public boolean isInKey(char door) {
			int isK=1<<(door-65);
			return (key&isK)>0;
		}
		
		// 키 추가 |
		public void addKey(char input) {
			key=(key|1<<(input-97));
		}
		
		
	}
	static StringTokenizer st;
	static int N,M;
	static char[][] map;
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}}; // 민식이 이동 방향
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map=new char[N][M];
		Minsik m=null;
		for (int i = 0; i < N; i++) {
			String str=br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='0') {
					// 민식이 위치 저장
					m=new Minsik(i, j, 0);
				}
			}
		}// 입력 완료
		
		System.out.println(bfs(m));
	}

	
	private static int bfs(Minsik m) {
		Queue<Minsik> q=new LinkedList<>();
		boolean[][][] visited=new boolean[N][M][1<<6];
		visited[m.x][m.y][m.key]=true;
		q.add(m);
		int depth=0;
		
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
				Minsik curr=q.poll();
//				System.out.println("현재 방문 x:"+curr.x+" y:"+curr.y+" key:"+curr.key);
				if(map[curr.x][curr.y]=='1') {
					// 출구 만남
					return depth;
				}
				for (int i = 0; i < 4; i++) {
					// 민식이 사방 이동
					int nx=curr.x+dir[i][0];
					int ny=curr.y+dir[i][1];
					if(isOkay(nx, ny)&&!visited[nx][ny][curr.key]) {
						if(map[nx][ny]=='#') continue;
						// 대문 발견
						// 가지고 있는 key와 대문 비교 
						// 만약 없다면, continue
						if('A'<=map[nx][ny] && map[nx][ny]<='F'){
//							System.out.println("대문 비교:"+curr.isInKey(map[nx][ny]));
							if(!curr.isInKey(map[nx][ny])) continue;
						}
						
						// 주의!! 이동 (키를 가지고 있지 않은 상태에서 키 있는 곳 방문)
						visited[nx][ny][curr.key]=true;
						Minsik next=new Minsik(nx, ny, curr.key);
						
						if('a'<=map[nx][ny] && map[nx][ny]<='f') {
							// 이동한 친구에 키 추가
							next.addKey(map[nx][ny]);
						}
						q.add(next);					
						
					}
				}
			}
			depth++;
		}
		return -1;
	}


	private static boolean isOkay(int nx, int ny) {
		return nx>=0 && ny>=0 && nx<N && ny<M;
	}

}

package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * @see https://www.acmicpc.net/problem/17135
 * bfs를 통해서 탐색, 구현
 */
public class BOJ_17135_캐슬디펜스 {
	static StringTokenizer st;
	static int N,M,D;
	static ArrayList<int[]> person;
	static int [] pick;
	static int[][] map;
	static int[][] move;
	static int[][] dir= {{0,-1},{-1,0},{0,1}}; //왼쪽부터 탐색, 아래는 x
	static int R=3; //궁수의 수
	static int result;
	static int enemy; 
	static int[][] ori;
	static int[][] checked;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		map=new int[N+1][M];
		person=new ArrayList<int[]>();
		ori=new int[N+1][M];
		// map
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				ori[i][j]=map[i][j];
			}
		}
		// 궁수 자리 후보 
		for (int j = 0; j < M; j++) {
			person.add(new int[] {N,j});
		}
		result=0;
		pick=new int[3];
		combination(0, 0);

		System.out.println(result);
	}
	private static void combination(int cnt, int start) {
		if (cnt==R) {
			attack(pick);
			// 최대 적의 개수 구하기
			result=result<enemy?enemy:result;
			// 맵 초기화!!!
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j]=ori[i][j];
				}
			}
			return;
		}
		for(int i=start; i<M; i++) {
			pick[cnt]=i;
			combination(cnt+1, i+1);
		}
		
	}
	private static void attack(int[] pick) {
		enemy=0;
		int is=0;
		while(true) {
			checked=new int [N+1][M];
			for (int index:pick) {
				int x=person.get(index)[0];
				int y=person.get(index)[1];
				bfs(x,y);
			} // 한턴 공격 끝
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(checked[i][j]==1) {
						map[i][j]=0;
						enemy+=1;
					}
				}
			}
			// 적 움직임, 마지막행부터 옮기기
			for (int i = N-1; i >=0; i--) {
				for (int j = 0; j < M; j++) {
					if (map[i][j]==1) {
						// 적들은 한칸 밑으로
						if(i+1<N) {
							// 성에 도착하지 않았을 경우에만 옮김
							map[i+1][j]=1;
							is++;
						}map[i][j]=0;
					}
				}
			}
			// 남은 적이 하나도 없을 경우 종료
			if(is==0) break;
			is=0;
		}
	}
	private static void bfs(int x, int y) {
		move=new int[N+1][M];
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {x,y});
		outer:while(!queue.isEmpty()) {
			int[] list=queue.poll();
			int r=list[0];
			int c=list[1];
			for (int i=0; i<3; i++) {
				// 탐색 어떻게..? bfs?? 
				int nx=r+dir[i][0];
				int ny=c+dir[i][1];
				if(isOkay(nx,ny) && move[nx][ny]==0) {
					move[nx][ny]=move[r][c]+1;
					if (move[nx][ny]>D) {
						// 공격 거리 안에 있는 적이 없음
						break outer;
					}
					//범위에 있고, 공격거리 안에 있는 적이라면 공격!
					queue.add(new int[] {nx,ny});
					if(map[nx][ny]==1 && move[nx][ny]<=D) {
//						map[nx][ny]=0;// 같은 곳을 공격할 수 있기 때문에 여기서 0으로 만들면 안됨!!! 
						checked[nx][ny]=1;
						break outer; // 한번에 한적만 죽임
					}
				}
			}
		}
		
	}
	private static boolean isOkay(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
	
}

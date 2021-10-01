import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 79040	992
 * @author CHO
 * @see https://www.acmicpc.net/problem/17143
 * @category 구현, 우선순위 큐
 * 범위 넘어가면 어떻게 처리할건지, v가 클 때 어떻게 처리할 것인지
 * 주의! 연산자 우선순위 -> 괄호 반드시!
 */
public class BOJ_17143_낚시왕 {
	
	// 우선순위 큐를 이용, 2마리 이상의 상어가 있을 때 처리하기 쉽게 만들어줌
	static class Shark implements Comparable<Shark>{
		int x;
		int y;
		int v;
		int dir;
		int size;
		
		
		public Shark(int x, int y,  int v, int dir, int size) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
			this.dir = dir;
			this.size = size;
		}

		@Override
		public int compareTo(Shark o) {
			if(this.x==o.x) {
				if(this.y==o.y) {
					return o.size-this.size;
				}
				return this.y-o.y;
			}
			return this.x-o.x;
		}
		
	}
	static StringTokenizer st;
	static int[][] dir= {{},{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// shark 객체를 저장할 맵
		Shark[][] map=new Shark[R+1][C+1];
		// 이동한 상어의 개수
		int[][] sharkMove=new int[R+1][C+1];
		
		PriorityQueue<Shark> moveShark;
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c]=new Shark(r, c, s, d, z);
		}// 입력완료
		
		int result=0; // 낚시꾼이 먹은 상어의 크기

		for (int time = 1; time < C+1; time++) {
			//1. 낚시꾼과 같은 열에 있는 가까운 상어 찾고, remove
			for (int r = 1; r < R+1; r++) {
				if(map[r][time]!=null) {
					//상어가 있으면 상어의 크기만큼 result+
					Shark shark=map[r][time];
					result+=shark.size;
					// 상어 삭제
					map[r][time]=null;
					break;
				}
			}
			
			// 이동한 상어 저장할 q
			moveShark=new PriorityQueue<>();
			
			//2. 상어 이동
			for (int r = 1; r < R+1; r++) {
				for (int c = 1; c < C+1; c++) {
					if(map[r][c]!=null) {
						// 상어가 있다면, 상어 이동
						Shark curr=map[r][c];
						int nx=curr.x;
						int ny=curr.y;
						int d=curr.dir;
						int v=curr.v;
						
						if(d==1 || d==2) {
							if(v>=(R-1)*2){
								// v값이 클 경우를 대비해서
								// v%((R-1)*2)해주면 v를 줄일 수 있음
								// 주의! 괄호 꼭 사용해야함 -> 연산자 우선순위 
								v=v%((R-1)*2);
							}
							for (int i = 0; i < v; i++) {
								nx=nx+dir[d][0];
								if(nx<1 || nx>R) {
									// 값 넘어가면, 방향 전환 
									if(d==1) {
										d=2;
										nx=nx+2;
									}
									else if(d==2) {
										d=1;
										nx=nx-2;
									}
								}
							}
						}else {
							if(v>=(C-1)*2){
								v=v%((C-1)*2);
							}
							for (int i = 0; i < v; i++) {
								ny=ny+dir[d][1];
								if(ny<1 || ny>C) {
									// 값 넘어가면, 방향 전환 
									if(d==3) {
										d=4;
										ny=ny-2;
									}
									else if(d==4) {
										d=3;
										ny=ny+2;
									}
								}
							}
						}

						map[r][c]=null;
						sharkMove[nx][ny]+=1;
						
						// 이동한 상어 큐에 저장
						moveShark.add(new Shark(nx, ny, curr.v, d, curr.size));
					}
				}
			}
			map=new Shark[R+1][C+1];
			//3. 상어가 2마리 이상 있는 칸 처리
			for (int r = 1; r < R+1; r++) {
				for (int c = 1; c < C+1; c++) {
					if(sharkMove[r][c]>=2) {
						Shark first=moveShark.poll();
						// 상어의 마리수-1만큼 상어 poll
						// 어차피 처음 꺼낸 상어가 제일 size 큼-> 우선순위큐라서
						for (int i = 0; i < sharkMove[r][c]-1; i++) {
							if(!moveShark.isEmpty()) moveShark.poll();
						}
						// first가 제일 큰 상어
						map[r][c]=first;
					}else if(sharkMove[r][c]==1) {
						Shark curr=moveShark.poll();
						map[r][c]=curr;
					}
				}
			}
			sharkMove=new int[R+1][C+1];
		}
		System.out.println(result);
		
		
		
	}

}

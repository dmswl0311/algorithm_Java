import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 20220	252
 * @author CHO
 * @see https://www.acmicpc.net/problem/21608
 * @catergory 2021 상반기 삼성 SW역테 기출, 사방탐색, 우선순위 큐
 */
public class BOJ_21608_상어초등학교 {
	
	static class Stu implements Comparable<Stu>{
		
		int x,y,like;

		public Stu(int x, int y, int like) {
			super();
			this.x = x;
			this.y = y;
			this.like = like;
		}

		@Override
		public int compareTo(Stu o) {
			// TODO Auto-generated method stub
			return o.like-this.like;
		}

		@Override
		public String toString() {
			return "Stu [x=" + x + ", y=" + y + ", like=" + like + "]";
		}
		
	}
	static class Stu3 implements Comparable<Stu3>{
		
		int x,y,like;

		public Stu3(int x, int y, int like) {
			super();
			this.x = x;
			this.y = y;
			this.like = like;
		}

		@Override
		public int compareTo(Stu3 o) {
			if(this.x==o.x) {
				return this.y-o.y;
			}
			return this.x-o.x;
		}

		@Override
		public String toString() {
			return "Stu3 [x=" + x + ", y=" + y + ", like=" + like + "]";
		}
		
	}
	static StringTokenizer st;
	static int N;
	static int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
	static PriorityQueue<Stu> likeq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int[][] student=new int[N*N+1][4];
		int[][] map=new int[N+1][N+1];
		Queue<Integer> order=new LinkedList<Integer>();
		// 입력 받기
		for (int i = 1; i < N*N+1; i++) {
			st=new StringTokenizer(br.readLine());
			int index=Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				student[index][j]=Integer.parseInt(st.nextToken());	
				
			}
			order.add(index);
		}
		// 최종 값 초기화
		int result=0;
		
		likeq=new PriorityQueue<>();
		
		// 1번 조건부터 
		// 큐에 담겨진 학생 순대로 배치
		while(!order.isEmpty()) {
			// 배치할 학생번호
			int currS=order.poll();
			
			// 비어있는 칸들 중, 4방탐색 -> 좋아하는 학생이 가장 많은 칸 선택
			int max_like=Integer.MIN_VALUE;
			
			for (int r = 1; r < N+1; r++) {
				for (int c = 1; c < N+1; c++) {
					int like=0;
					if(map[r][c]==0) {
						int x=r;
						int y=c;
						for (int i = 0; i < dir.length; i++) {
							int nx=x+dir[i][0];
							int ny=y+dir[i][1];
							if(isOkay(nx,ny)) {
								// 인접한 칸에 내가 좋아하는 학생이 있다면 like++
								for (int s = 0; s < 4; s++) {
									if(map[nx][ny]==student[currS][s]) {
										like++;
										break;
									}
								}
							}
						}
						//만약, like수가 현재 like수보다 많거나 같다면, 저장
						if(max_like<=like) {
							max_like=like;
							likeq.add(new Stu(r, c, like));
						}
					}
				}
			}
			// 1번 조건 탐색 끝
			// 우선순위 큐이기 때문에 like수가 가장 많은 위치가 나옴 
			Stu max=likeq.poll();
			Queue<Stu> second=new LinkedList<>();
			second.add(max);
			
			while(!likeq.isEmpty()) {
				Stu curr=likeq.poll();
				if (max.like==curr.like) {
					second.add(curr);
					continue;
				}else {
					break;
				}
			}
			likeq.clear();
			
			// 만약, 여러자리가 있다면 두번째 조건으로 
			if (second.size()>1) {
				// 두번째 조건
				int max_empty=0;
				while(!second.isEmpty()) {
					Stu s=second.poll();
					int x=s.x;
					int y=s.y;
					int empty=0;
					for (int i = 0; i < dir.length; i++) {
						int nx=x+dir[i][0];
						int ny=y+dir[i][1];
						if(isOkay(nx,ny)) {
							// 인접한 칸의 빈칸 개수
							if(map[nx][ny]==0) {
								empty++;
							}
							
						}
					}
					if(max_empty<=empty) {
						max_empty=empty;
						likeq.add(new Stu(x, y, empty));
					}
				}
				// 2번 조건 탐색 끝
				// 우선순위 큐이기 때문에 empty수가 가장 많은 위치가 나옴 
				PriorityQueue<Stu3> third=new PriorityQueue<>();
				Stu max2=likeq.poll();
				third.add(new Stu3(max2.x, max2.y, max2.like));
				
				while(!likeq.isEmpty()) {
					Stu curr=likeq.poll();
					if (max2.like==curr.like) {
						third.add(new Stu3(curr.x, curr.y, curr.like));
						continue;
					}else {
						break;
					}
				}
				likeq.clear();
				
				Stu3 s=third.poll();
				map[s.x][s.y]=currS;

			}else if (second.size()==1){
				Stu s=second.poll();
				map[s.x][s.y]=currS;
			}
		}
		// 학생 배치 완료 
		for (int r = 1; r < N+1; r++) {
			for (int c = 1; c < N+1; c++) {
				int cnt=0;
				int currS=map[r][c];
				for (int i = 0; i < dir.length; i++) {
					int nx=r+dir[i][0];
					int ny=c+dir[i][1];
					if(isOkay(nx,ny)) {
						for (int s = 0; s < 4; s++) {
							if(map[nx][ny]==student[currS][s]) {
								cnt++;
								break;
							}
						}
					}
				}
				if(cnt==1) result+=1;
				else if(cnt==2) result+=10;
				else if(cnt==3) result+=100;
				else if(cnt==4) result+=1000;
						
			}
		}
		System.out.println(result);
	}

	private static boolean isOkay(int nx, int ny) {
		// TODO Auto-generated method stub
		return nx>=1 && ny>=1 && nx<N+1 && ny<N+1;
	}

}

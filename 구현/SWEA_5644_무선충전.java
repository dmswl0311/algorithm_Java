import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo&categoryId=AWXRDL1aeugDFAUo&categoryType=CODE&problemTitle=5644&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * 충전소가 겹쳤을 때, 조건 어려움
 */
public class SWEA_5644_무선충전 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	static int M,A;
	static int[] a,b;
	static int[][] BC;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			result=0;
			st=new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			A=Integer.parseInt(st.nextToken());
			a=new int[M]; // 사람1 정보
			b=new int[M]; // 사람2 정보
			BC=new int[A][]; // 충전기 정보
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				a[i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				b[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<A; i++) {
				// BC의 정보
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				int p=Integer.parseInt(st.nextToken());
				BC[i]= new int[]{x,y,c,p};
			}
			move();
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	// 사람 이동
	private static void move() {
		int x1=1,y1=1;
		int x2=10,y2=10;
		
		charge(x1,y1,x2,y2);
		
		for(int i=0; i<M; i++) {
		// 사람1 이동
			if(a[i]==1) { // 상
				y1--;
			}else if(a[i]==2) { //우
				x1++;
			}else if(a[i]==3) { //하
				y1++;
			}else if(a[i]==4) { //좌
				x1--;
			}
		// 사람2 이동
			if(b[i]==1) { // 상
				y2--;
			}else if(b[i]==2) { //우
				x2++;
			}else if(b[i]==3) { //하
				y2++;
			}else if(b[i]==4) { //좌
				x2--;
			}
		// 이동 후
			charge(x1,y1,x2,y2);
		}
	}
	private static void charge(int x1,int y1,int x2,int y2) {
		// 사람이 이동할 수있는 충전기 표시
		boolean[] person1=new boolean[A];
		boolean[] person2=new boolean[A];
		int cnt=0;
		int max=0;
		ArrayList<Integer> vi=new ArrayList<>();
		for(int i=0; i<A; i++) {
			if(Math.abs(x1-BC[i][0])+Math.abs(y1-BC[i][1])<=BC[i][2]) {
				// 사람1의 위치가 충전위치 안에 있다면
				person1[i]=true;
			}
			if(Math.abs(x2-BC[i][0])+Math.abs(y2-BC[i][1])<=BC[i][2]) {
				// 사람2의 위치가 충전위치 안에 있다면
				person2[i]=true;
			}
			if (person1[i]==true && person2[i]==true) {
				// 같은 곳을 방문했다면
				vi.add(i);
				cnt++;
				
			}
		}
		if (cnt==0) {
			// 같은 곳 방문x, 자신이 갈 수 있는 공간 중 큰 충전
			for(int i=0; i<A; i++) {
				if(person1[i]) {
					max=max<BC[i][3]?BC[i][3]:max;
				}
			}
			result+=max;
			max=0;
			for(int i=0; i<A; i++) {
				if(person2[i]) {
					max=max<BC[i][3]?BC[i][3]:max;
				}
			}
			result+=max;
		}
		else{ // 같은 곳 방문시
			int flag=0;
			for(int i=0; i<A; i++) {
				if(person1[i]==person2[i]) continue;
				else {
					flag=1;
					break;
				}
			}
			// 방문한 곳이 완전 같다면 방문한 곳들 중 충전값이 max인 곳 더하기
			if (flag==0) {
				for(int i=0; i<vi.size(); i++) {
					max=max<BC[vi.get(i)][3]?BC[vi.get(i)][3]:max;
				}
				if (cnt==1) {
					// 만약, 겹쳐서 방문한 곳이 한 곳이라면 그대로 max 
					result+=max;
				}else {
					// 만약, 겹쳐서 방문한 곳이 여러곳이라면 max+그다음max값
					int maxx=0;
					for(int i=0; i<vi.size(); i++) {
						if(BC[vi.get(i)][3]!=max) maxx=maxx<BC[vi.get(i)][3]?BC[vi.get(i)][3]:maxx;
					}
					result+=max+maxx;
				}
			}else {
				// 방문한 곳이 같지 않다면
				
				// 같이 방문한 곳 중 max 구함
				for(int i=0; i<vi.size(); i++) {
					max=max<BC[vi.get(i)][3]?BC[vi.get(i)][3]:max;
				}
				
				int max1=0;
				int max2=0;
				
				// 사람1이 방문한 곳 중 max 값 
				for (int i=0; i<A; i++) {
					if(person1[i]==true) {
						max1=max1<BC[i][3]?BC[i][3]:max1;
					}	
				}
				// 사람2가 방문한 곳 중 max 값 
				for (int i=0; i<A; i++) {
					if(person2[i]==true) {
						max2=max2<BC[i][3]?BC[i][3]:max2;
					}	
				}
				if(max1!=max2) {
					// 만약, max값이 다르다면 
					result+=max1+max2;
				}else {
					// max값이 다르다면, 두번째로 큰 max값 구해야함
					if(max1!=max && max2!=max) {
						result+=max1+max2;
					}else {
						int max3=0;
						int max4=0;
						// 두번째 큰거 고름
						for (int i=0; i<A; i++) {
							if(person1[i]==true&&BC[i][3]!=max1) {
								max3=max3<BC[i][3]?BC[i][3]:max3;
							}	
						}
						for (int i=0; i<A; i++) {
							if(person2[i]==true&&BC[i][3]!=max2) {
								max4=max4<BC[i][3]?BC[i][3]:max4;
							}	
						}
						if (max3>=max4) {
							result+=max+max3;
						}else if(max3<max4){
							result+=max+max4;
						}
					}
				}
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4_2 {
	static int N,M,K;
	static int[][] map;
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static boolean[] visited;
	static int[] index;
	static int [][] rotation;
	static int result=0;
	static int min;
	static int[][] ori;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); //배열 크기
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken()); //몇번 회전
		map=new int[N][M];
		ori=new int[N][M];
		for(int n=0; n<N; n++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int m=0; m<M; m++) {
				map[n][m]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				ori[i][j]=map[i][j];
			}
		}
		rotation=new int[K][];
		for (int k=0; k<K; k++) {
			st=new StringTokenizer(br.readLine()," ");
			int r=Integer.parseInt(st.nextToken()); 
			int c=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken()); 
			rotation[k]=new int[] {r,c,s};
		}
		
		// 계산
		index=new int[K];
		visited=new boolean[K];
		min=10000;
		permutation(0);

		// 계산끝
		System.out.println(min);
	}
	private static void permutation(int cnt) {
		if (cnt==K) {
			for (int i:index) {
				cal(rotation[i][0],rotation[i][1],rotation[i][2]);
			}
			
			for(int n=0; n<N; n++) {
				result=0;
				for(int m=0; m<M; m++) {
					result+=map[n][m];
				}
				if (min>result) min=result;
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					map[i][j]=ori[i][j];
				}
			}
			
			return;
		}
		for (int i=0; i<K; i++) {
			if(visited[i]) continue;
			index[cnt]=i;
			visited[i]=true;
			permutation(cnt+1);
			visited[i]=false;
			
		}
	}
	private static void cal(int r,int c,int s) {
		
		int sR=r-s;
		int sC=c-s;
		int eR=r+s;
		int eC=c+s;
		int rcnt=eR-sR;
		int ccnt=eC-sC;
		
		for (int d=0; d<Math.min(rcnt, ccnt)/2; d++) {
			int keep=map[sR-1+d][eC-1-d];
			//1.맨윗줄
			for(int C=eC-1-d-1; C>=sC-1+d; C--) {
				map[sR-1+d][C+1]=map[sR-1+d][C];
			}
			//2.왼쪽 줄 위로, c고정
			for(int R=sR-1+1+d; R<=eR-1-d; R++) {
				map[R-1][sC-1+d]=map[R][sC-1+d];
			}
			// 여기부터 수정
			//3.밑 줄 왼쪽으로 r고정
			for(int C=sC-1+1+d; C<=eC-1-d; C++) {
				map[eR-1-d][C-1]=map[eR-1-d][C];
			}
			//4.오른쪽 줄 밑으로, c고정
			for(int R=eR-1-1-d; R>=sR-1+d; R--) {
				map[R+1][eC-1-d]=map[R][eC-1-d];
			}
			map[sR-1+d+1][eC-1-d]=keep;
		}
	}
}
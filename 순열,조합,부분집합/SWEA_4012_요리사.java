import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
 * 조합 2번 사용
 */
public class SWEA_4012_요리사 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	static int min;
	static int[][] list;
	static int N;
	static int[] pickA,pickB;
	static int[] A,B;
	static int len;
	static int a,b=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			min=Integer.MAX_VALUE;
			N=Integer.parseInt(br.readLine());
			list=new int[N+1][N+1];
			for(int i=1; i<N+1; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 1; j < N+1; j++) {
					list[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			len=N/2;
			pickA=new int[len];
			pickB=new int[len];
			A=new int[2];
			B=new int[2];
			combination(0,1,len);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	private static void combination(int cnt, int start,int R) {
		if(cnt==R) {
			// pickA에 안뽑힌 애들 pickB에 넣기
			int x=0;
			for (int n=1; n<N+1; n++) {
				if(Arrays.binarySearch(pickA, n)<0) {
					pickB[x]=n;
					x++;
				}
			}
			combination2(0,0);
			min=min>=Math.abs(a-b)?Math.abs(a-b):min;
			a=0;
			b=0;
			return;
		}
		for(int i=start; i<=N; i++) {
			pickA[cnt]=i;
			combination(cnt+1, i+1, R);
		}
	}
	private static void combination2(int cnt,int start) {
		if(cnt==2) {
			a+=list[A[0]][A[1]]+list[A[1]][A[0]];
			b+=list[B[0]][B[1]]+list[B[1]][B[0]];
			return;
		}
		for(int i=start; i<pickA.length; i++) {
			A[cnt]=pickA[i];
			B[cnt]=pickB[i];
			combination2(cnt+1, i+1);
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @see "https://www.acmicpc.net/problem/2961"
 * 조합 문제, SWEA_5215 햄버거 다이어트와 비슷
 */


public class BOJ_2961_도영이가만든맛있는음식 {
	static StringTokenizer st;
	static int N;
	static int min;
	static int[] pick;
	static int cnts,cntb;
	static int[][] input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		input=new int[N][2];
		for (int n=0; n<N; n++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			input[n]= new int[]{s,b};
		}
		min=1000000000;
		for (int R=1; R<N+1; R++) {
			// 몇 번 뽑을지 모르니까
			pick=new int[R];
			cnts=1;
			cntb=0;
			combination(0,0,R);
		}
		System.out.println(min);
		
	}
	private static void combination(int cnt, int start, int R) {
		if(cnt==R) {
			for(int i=0; i<pick.length; i++) {
				int index=pick[i];
				cnts*=input[index][0];
				cntb+=input[index][1];
			}
			if (min>Math.abs(cnts-cntb)) min=Math.abs(cnts-cntb);
			cnts=1;
			cntb=0;
			return;
		}
		for(int i=start; i<N; i++) {
			pick[cnt]=i;
			combination(cnt+1,i+1,R);
		}
	}

}

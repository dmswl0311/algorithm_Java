import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * @see "https://www.acmicpc.net/problem/1182"
 * 조합 사용
 */

public class BOJ_1182_부분수열의합 {
	static StringTokenizer st;
	static int N,S;
	static int[] pick;
	static int[] input;
	static int result;
	static int plus;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		input=new int[N];
		st=new StringTokenizer(br.readLine());
		for (int n=0; n<N; n++) {
			input[n]=Integer.parseInt(st.nextToken());
		}
		result=0;
		plus=0;
		for (int R=1; R<N+1; R++) {
			// 몇 번 뽑을지 모르니까
			pick=new int[R];
			combination(0,0,R);
		}
		System.out.println(result);
		
	}
	private static void combination(int cnt, int start, int R) {
		if(cnt==R) {
			for(int x:pick) plus+=x;
			if (plus==S) result++;
			plus=0;
			return;
		}
		for (int i=start; i<N; i++) {
			pick[cnt]=input[i];
			combination(cnt+1,i+1,R);
		}
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 20312	128
 * @author CHO
 * @see https://www.acmicpc.net/problem/12852
 * @category DP + 역추적
 */
public class BOJ_12852_1로만들기2 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp=new int[N+1];
		int[] parents=new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1]=0;
		for (int n = 2; n < N+1; n++) {
			if(n%3==0) {
				if(dp[n]>dp[n/3]+1) {
					dp[n]=dp[n/3]+1;
					parents[n]=n/3;
				}
			}
			if(n%2==0) {
				if(dp[n]>dp[n/2]+1) {
					dp[n]=dp[n/2]+1;
					parents[n]=n/2;
				}
			}
			if(dp[n]>dp[n-1]+1) {
				dp[n]=dp[n-1]+1;
				parents[n]=n-1;
			}
		}// dp 구함
		sb.append(dp[N]+"\n");
		int num=N;
		while(num>0) {
			sb.append(num+" ");
			num=parents[num];
		}
	
		System.out.println(sb);
	}
}
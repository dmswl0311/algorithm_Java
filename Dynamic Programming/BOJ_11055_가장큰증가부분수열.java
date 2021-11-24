import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 12108	108
 * @author CHO
 * @see https://www.acmicpc.net/problem/11055
 * @category LIS(dp)
 * LIS 응용문제, 자신보다 작은 숫자가 있을 때 list[i](작은 숫자)을 더해가며 최대값 구함
 */
public class BOJ_11055_가장큰증가부분수열 {
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int list[]=new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i]= Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		int dp[]=new int[N];
		for (int i = 0; i < N; i++) {
			dp[i]=list[i];
			for (int j = 0; j < i; j++) {
				if(list[j]<list[i] && dp[j]+list[i]>dp[i]) {
					dp[i]=dp[j]+list[i];
				}
			}
		}
//		System.out.println(Arrays.toString(dp));
		int max=0;
		for (int i = 0; i < N; i++) {
			max=Math.max(max,dp[i]);
		}
		System.out.println(max);
	}
}

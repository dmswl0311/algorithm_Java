package algo;

import java.io.*;
import java.util.*;

/**
 * 11728	84
 * @author CHO
 * @see https://www.acmicpc.net/problem/9084
 * @category DP
 */
public class BOJ_9084_동전 {
	
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] list=new int[N];
			st=new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				list[n]=Integer.parseInt(st.nextToken());
			}
			int m = Integer.parseInt(br.readLine());
			int[] dp=new int[m+1];// 입력 완료
			
			dp[0]=1;
			for (int i = 0; i < N; i++) {
				int n=list[i];
				for (int j = n; j < m+1; j++) {
					dp[j]=dp[j-n]+dp[j];
				}
			}
			System.out.println(dp[m]);
		}
	}
}

package algo;

import java.io.*;
import java.util.*;

/**
 * 11728	96
 * @author CHO
 * @see https://www.acmicpc.net/problem/2293
 * @category DP
 */
public class BOJ_2293_동전1 {

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] list=new int[N];
		int[] dp=new int[K+1];
		for (int n = 0; n < N; n++) {
			list[n]=Integer.parseInt(br.readLine());
		}// 입력 완료
		dp[0]=1;
		for (int i = 0; i < N; i++) {
			int n=list[i];
			for (int j = n; j < K+1; j++) {
				dp[j]=dp[j-n]+dp[j];
			}
		}
		System.out.println(dp[K]);
	}
}

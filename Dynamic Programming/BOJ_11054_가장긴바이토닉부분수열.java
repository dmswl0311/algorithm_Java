import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 12764	124
 * @author CHO
 * @see https://www.acmicpc.net/problem/11054
 * @category LIS(dp), 앞에서부터 LIS + 뒤에서부터 LIS - 1
 */
public class BOJ_11054_가장긴바이토닉부분수열 {
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] list=new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}
		
		// 증가하는 수열
		int[] dp1=new int[N];
		for (int i = 0; i < N; i++) {
			dp1[i]=1;
			for (int j = 0; j < i; j++) {
				if(list[j]<list[i] && dp1[j]+1>dp1[i]) {
					dp1[i]=dp1[j]+1;
				}
			}
		}
		// 감소하는 수열 (뒤에서부터 비교)
		int[] dp2=new int[N];
		for (int i = N-1; i >= 0; i--) {
			dp2[i]=1;
			for (int j = N-1; j > i; j--) {
				if(list[j]<list[i] && dp2[j]+1>dp2[i]) {
					dp2[i]=dp2[j]+1;
				}
				
			}
		}
		int max=0;
		for (int i = 0; i < N; i++) {
			max=Math.max(max, dp1[i]+dp2[i]);
		}
//		System.out.println(Arrays.toString(dp1));
//		System.out.println(Arrays.toString(dp2));
		
		System.out.println(max-1);

	}

}

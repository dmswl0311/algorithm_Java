import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11892	96
 * @author CHO
 * @see https://www.acmicpc.net/problem/1010
 * @category DP, 파스칼의 삼각형
 * 파스칼의 삼각형을 이용해 풀이, 2차원 배열->1차원으로 줄임
 */
public class BOJ_6591_이항쇼다운 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			if(N==0 && M==0) {
				System.out.println(sb);
				break;
			}
			
			// mCn 만들기
			long[] dp=new long[M+1];
			dp[0]=1;
			dp[1]=1;
			
			for (int i = 2; i < M+1; i++) {
				dp[i]=1;
				for (int j = i-1; j >=1; j--) {
					dp[j]=dp[j-1]+dp[j];
					if(i==M && j==N) break;
				}
			}

			sb.append(dp[N]).append("\n");
		}
	}

}

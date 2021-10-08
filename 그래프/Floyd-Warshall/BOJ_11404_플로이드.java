import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 	45560	576
 * @author CHO
 * @see https://www.acmicpc.net/problem/11404
 * @category 플로이드-워셜
 * 주의! 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다. 
 */
public class BOJ_11404_플로이드 {
	static StringTokenizer st;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		int dp[][]=new int[N+1][N+1];
		// 큰 값으로 초기화
		int INF=100000*N;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(i==j) dp[i][j]=0;
				else dp[i][j]=INF;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			// 중복 값이 들어오므로, 더 작은 값으로 넣어줌
			if(dp[r][c]>cost) dp[r][c]=cost;
		}
		
		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k][j]);
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(dp[i][j]==INF) System.out.print("0 ");
				else System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}

}

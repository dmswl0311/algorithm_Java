import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 	11804	80
 * @author CHO
 * @see https://www.acmicpc.net/problem/2225
 * @category DP
 */
public class BOJ_2225_합분해 {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long arr[][] = new long[201][201];

        // N을 1개(K==1)로 나눴을 때
        for (int i = 1; i < N+1; i++) {
            arr[1][i] = 1;
        }

        // 첫번째는 무조건 i (N==1일 때)
        for (int i = 1; i < K+1; i++) {
            arr[i][1] = i;
        }
        
        for (int i = 2; i < K+1; i++) {
            for (int j = 2; j < N+1; j++) {
                arr[i][j] = ((arr[i][j-1]%1000000000)+(arr[i-1][j]%1000000000))%1000000000;
            }
        }

        System.out.println(arr[K][N]);

    }

}


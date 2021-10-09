import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author CHO
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr&categoryId=AWBOKg-a6l0DFAWr&categoryType=CODE&problemTitle=3307
 * @category LIS,DP
 * LIS 기본코드
 */
public class SWEA_3307_최장증가부분수열 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			int result=0;
			int N=Integer.parseInt(br.readLine());
			int[] list=new int[N];
			int[] LIS=new int[N];
			
			st=new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list[i]=Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				// 최소값 지정
				LIS[i]=1;
				for (int j = 0; j < i; j++) {
					// j의 값이 현재 값보다 작으면 붙일 수 있는 후보
					if(list[j]<list[i] && LIS[j]+1>LIS[i]) {
						LIS[i]=LIS[j]+1;
					}
				}
				result=result<LIS[i]?LIS[i]:result;
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

}

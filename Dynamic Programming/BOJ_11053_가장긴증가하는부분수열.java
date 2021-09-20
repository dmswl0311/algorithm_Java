import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 12188	104
 * @author CHO
 * @see https://www.acmicpc.net/problem/11053
 * @category LIS, O(N^2)
 */
public class BOJ_11053_가장긴증가하는부분수열 {
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int list[]=new int[N];
		int LIS[]=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}
		
		int max=0;
		for (int i = 0; i < N; i++) {
			LIS[i]=1;
			for (int j = 0; j < i; j++) {
				if(list[j]<list[i] && LIS[j]+1>LIS[i]) {
					LIS[i]=LIS[j]+1;
				}
			}
			max=max<LIS[i]?LIS[i]:max;
		}
		System.out.println(max);
	}

}

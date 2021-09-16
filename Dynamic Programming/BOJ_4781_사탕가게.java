import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 620304	1684
 * @author CHO
 * @see https://www.acmicpc.net/problem/4781
 * @category DP, knapsack과 유사하지만 사탕은 여러개 담을 수 있음
 * float와 double은 0.5 더해주어야 함-> 근삿값이라서
 */
public class BOJ_4781_사탕가게3 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=(int)(Float.parseFloat(st.nextToken())*100+0.5);
			
			if(n==0 && m==0) break;
			
			int[][] candy=new int[n+1][2];
			
			for (int i = 1; i < n+1; i++) {
				st=new StringTokenizer(br.readLine());
				candy[i][0]=Integer.parseInt(st.nextToken());
				candy[i][1]=(int)(Float.parseFloat(st.nextToken())*100+0.5);
			}
			
			int[][] table=new int[n+1][m+1];
			
			for (int i = 1; i < n+1; i++) {
				int c=candy[i][0]; //칼로리
				int p=candy[i][1]; //가격
				// 가격 돌면서 
				for (int j = 1; j < m+1; j++) {
					if(j>=p) {
						// 사탕은 여러개 담을 수 있으므로 table[i][j-p]+c (같은 사탕안에서 비교해야)
						table[i][j]=Math.max(table[i-1][j], table[i][j-p]+c);
					}else {
						// 현재 사탕 사지못함
						table[i][j]=table[i-1][j];
					}
				}
			}
			sb.append(table[n][m]).append("\n");
		}
		System.out.println(sb);

	}

}

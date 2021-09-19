import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author CHO 	12116	112
 * @see https://www.acmicpc.net/problem/12865
 * @category DP, 1차원 배열
 */
public class BOJ_12865_평범한배낭_1차원arr {
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int[][] list=new int[N+1][2];
		
		for (int i = 1; i < N+1; i++) {
			st=new StringTokenizer(br.readLine());
			int w=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			list[i]= new int[]{w,v};
		}
		int[]map=new int[K+1];
		
		for (int i = 1; i < N+1; i++) {
			int w=list[i][0];
			int v=list[i][1];
			// 나의 무게까지만 구하므로 if문 필요없음
			for (int j = K; j >= w; j--) {
				map[j]=Math.max(map[j-w]+v, map[j]);
			}
		}
		System.out.println(map[K]);

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author CHO 	51272	152
 * @see https://www.acmicpc.net/problem/12865
 * @category DP, 2차원 배열
 */
public class BOJ_12865_평범한배낭 {
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
		int[][] map=new int[N+1][K+1];
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 0; j < K+1; j++) {
				int w=list[i][0];
				int v=list[i][1];
				if(w>j) {
					// 담을 수 없는
					map[i][j]=map[i-1][j];
				}else {
					map[i][j]=Math.max(map[i-1][j], map[i-1][j-w]+v);
				}
			}
		}
		System.out.println(map[N][K]);

	}

}

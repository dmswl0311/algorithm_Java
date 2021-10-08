import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 19264	340
 * @author CHO
 * @see https://www.acmicpc.net/problem/11403
 * @category 플로이드-워셜
 */
public class BOJ_11403_경로찾기 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int map[][]=new int[N+1][N+1];
		int INF=N*N;
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				int num=Integer.parseInt(st.nextToken());
				if(num==0) map[i][j]=INF;
				else map[i][j]=num;
			}
		}
		
		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(map[i][j]==INF) System.out.print("0 ");
				else System.out.print("1 ");
			}
			System.out.println();
		}
		

	}

}

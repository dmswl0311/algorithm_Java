import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 39516	596
 * @author CHO
 * @see https://www.acmicpc.net/problem/2458
 * @category 플로이드 워셜
 */

public class BOJ_2458_키순서 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int result=0;
		map=new int[N+1][N+1];
		int max=N*(N-1);
		
		// 초기화
		for (int i = 1; i <N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(i==j) map[i][j]=0;
				else map[i][j]=max;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			map[a][b]=1;
		}
        // 입력 완료
		
		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		int r=0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(map[i][j]!=max && map[i][j]!=0) r+=1;
				else if(map[j][i]!=max && map[j][i]!=0) r+=1;
			}
			if (r==N-1) result++;
			r=0;
		}
		
		System.out.println(result);
	}

}
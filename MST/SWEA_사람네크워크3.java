import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_사람네크워크3 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			int result=Integer.MAX_VALUE;
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int[][] list=new int[N+1][N+1];
			int[]distance = new int[N+1];
			
			
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					list[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			boolean[] visited;
			int[] resultList=new int[N+1];
			
			for (int n = 1; n < N+1; n++) {
				Arrays.fill(distance, Integer.MAX_VALUE);
				distance[n]=0;
				visited=new boolean[N+1];
				
				for (int i = 0; i < N; i++) {
					int vertex=0;
					int min=Integer.MAX_VALUE;
					
					for (int j = 1; j < N+1; j++) {
						if(!visited[j] && min>distance[j]) {
							min=distance[j];
							vertex=j;
						}
					}
					
					visited[vertex]=true;
					resultList[n]+=distance[vertex];
					
					for (int j = 1; j < N+1; j++) {
						int currW=list[vertex][j];
						if(!visited[j] && list[vertex][j]!=0 && distance[j]>min+currW) {
							distance[j]=min+currW;
						}
					}
				}
				// 한 정점의 min이 끝나면
				result=result>resultList[n]?resultList[n]:result;
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

}

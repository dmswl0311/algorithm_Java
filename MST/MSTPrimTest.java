package MST;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * Prim 알고리즘
 * @author CHO
 */
public class MSTPrimTest {
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] adjMatrix=new int[N][N];
		boolean[] visited=new boolean[N]; // 정점 방문여부
		int[] minEdge=new int[N]; // 최소 정점 연결비용
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j]=Integer.parseInt(st.nextToken());
			}
			minEdge[i]=Integer.MAX_VALUE;
		}
		int result=0; // 최소신장트리 비용
		minEdge[0]=0; // 시작 정점
		
		for (int i = 0; i < N; i++) {
			// 1. 연결하지 않은 정점 중, 최소 간선비용의 정점 찾기
			int min=Integer.MAX_VALUE;
			int minVertex=-1; // 최소간선비용의 정점 번호
			for (int j = 0; j < N; j++) {
				// 모든 정점 방문
				if(!visited[j]) {
					if(min>minEdge[j]) {
						min=minEdge[j];
						minVertex=j;
					}
				}
			}
			visited[minVertex]=true; // 신장트리에 포함
			result+=min; // 간선비용 저장
			
			// 2. 선택된 정점 기준으로 신장트리에 연결되지 않은 간선 비용 최소로 업데이트 
			for (int j = 0; j < N; j++) {
				if(!visited[j] && adjMatrix[minVertex][j]!=0 && minEdge[j]>adjMatrix[minVertex][j]) {
					minEdge[j]=adjMatrix[minVertex][j];
				}
			}
		}
		System.out.println(result);
	}
}
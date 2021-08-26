import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * Dijkstra
 * @author CHO
 * @see https://www.acmicpc.net/problem/1753
 * 인접리스트 (ArrayList) 이용
 */
public class BOJ_1753_최단경로 {
	static String str="5 6\r\n" + 
			"1\r\n" + 
			"5 1 1\r\n" + 
			"1 2 2\r\n" + 
			"1 3 3\r\n" + 
			"2 3 4\r\n" + 
			"2 4 5\r\n" + 
			"3 4 6";
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static int V,E,K;
	static ArrayList<ArrayList<int[]>> graph;
	static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new StringReader(str));
		st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken()); // 정점의 개수
		E=Integer.parseInt(st.nextToken()); // 간선의 개수
		K = Integer.parseInt(br.readLine()); // 시작점
		
		graph=new ArrayList<ArrayList<int[]>>();
		for (int i = 0; i < V+1; i++) {
			graph.add(i,new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken()); 
			int w=Integer.parseInt(st.nextToken()); 
			graph.get(u).add(new int[]{v,w});
		}
		// 1번 노드와 연결된 노드들 중 0번째에 있는 v좌표
//		System.out.println(graph.get(1).get(0)[0]);
		distance=new int[V+1];
		dijkstra(K);
		for (int x = 1; x < V+1; x++) {
			if (distance[x]==Integer.MAX_VALUE) {
				sb.append("INF").append("\n"); 
				continue;
			}
			sb.append(distance[x]).append("\n");
		}
		System.out.println(sb);

	}
	private static void dijkstra(int start) {
		boolean[] visited=new boolean[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start]=0;
		
		for (int v = 1; v< V+1; v++) {
			int minV=0;
			int minCost=Integer.MAX_VALUE;
			for (int i = 1; i < V+1; i++) {
				if(!visited[i] && distance[i]<minCost) {
					minCost=distance[i];
					minV=i;
				}
			}
			visited[minV]=true;
			// 정점과 연결되어 있는 다른 정점들 탐방
			ArrayList<int[]> current=graph.get(minV);
			for (int j = 0; j < current.size(); j++) {
				int next=current.get(j)[0];
				if(!visited[next] && distance[next]>distance[minV]+current.get(j)[1]) {
					distance[next]=distance[minV]+current.get(j)[1];
				}
			}
		}
		
	}

}

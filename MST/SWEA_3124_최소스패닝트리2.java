import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3124_최소스패닝트리2 {
	
	// 하나의 정점에서 연결된 간선들 중 하나씩 선택하면서 MST 만들어감
	// 정점 중심 -> 인접 행렬, 인접 리스트
	// 인접 리스트, 우선 순위 큐 사용
	
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}
	
	static ArrayList<Node>[] list;
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테케 개수
		for (int t = 1; t < T+1; t++) {
			
			st=new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //정점의 개수
			int E = Integer.parseInt(st.nextToken()); //간선의 개수
			

			list=new ArrayList[N+1];
			boolean[] visited=new boolean[N+1];
			
			for (int i = 1; i < N+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int weight=Integer.parseInt(st.nextToken());
				// 인접리스트
				list[a].add(new Node(b, weight));
				list[b].add(new Node(a, weight));
			}

			long result=0; // 최소신장트리 비용
			
			PriorityQueue<Node> pq=new PriorityQueue<>();
			pq.add(new Node(1, 0));
			
			while(!pq.isEmpty()) {
				Node n=pq.poll();
				if(visited[n.vertex]) continue;
				visited[n.vertex]=true;
				result+=n.weight;
				for (int i=0; i<list[n.vertex].size(); i++) {
					if(!visited[list[n.vertex].get(i).vertex]) {
						pq.add(list[n.vertex].get(i));
					}
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}

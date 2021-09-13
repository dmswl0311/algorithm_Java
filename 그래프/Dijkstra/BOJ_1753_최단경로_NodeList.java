import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로_NodeList {
	static class Node{
		int vertex;
		Node link;
		int weight;
		
		public Node() {}

		public Node(int vertex, Node link, int weight) {
			super();
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + ", weight=" + weight + "]";
		};

	}
	static Node[] NodeList;
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		NodeList=new Node[V+1];
		
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			NodeList[u]=new Node(v, NodeList[u], w);
		}
		
		boolean[] visited=new boolean[V+1];
		int[] distance=new int[V+1];
	
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K]=0;
		
		for (int v = 1; v < V+1; v++) {
			int min=Integer.MAX_VALUE;
			int curV=0;
			for (int i = 1; i < V+1; i++) {
				if(!visited[i] && min>distance[i]) {
					min=distance[i];
					curV=i;
				}
			}
			
			visited[curV]=true;
			
			for (Node n=NodeList[curV]; n!=null; n=n.link ) {
				if(!visited[n.vertex]&&distance[n.vertex]>min+n.weight) {
					distance[n.vertex]=min+n.weight;
				}
			}
		}
		
		for (int i=1; i<V+1; i++) {
			if (distance[i]==Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(distance[i]).append("\n");
		}
		System.out.println(sb);

	}

}

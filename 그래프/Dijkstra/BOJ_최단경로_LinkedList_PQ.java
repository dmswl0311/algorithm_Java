import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 우선순위큐 사용
 * @author CHO
 * 다익스트라 최단경로
 */

public class BOJ_최단경로_LinkedList_PQ {
	static class LinkNode implements Comparable<LinkNode>{
		int no;
		int weight;
		LinkNode pre;
		int totalCost; // 각 정점에 도달하는 비용
		
		public LinkNode(int no, int weight, LinkNode pre) {
			super();
			this.no = no;
			this.weight = weight;
			this.pre = pre;
		}
		
		// PQ에서 사용하기 위한 생성자
		public LinkNode(int no, int totalCost) {
			this.no=no;
			this.totalCost=totalCost;
		}

		@Override
		public int compareTo(LinkNode o) {
			return Integer.compare(this.totalCost, o.totalCost);
		}
		
	}
	static StringTokenizer st;
	static int V,E;
	static StringBuilder sb=new StringBuilder();
	static LinkNode[] graph;
	static int[] dist;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new StringReader(str));
		st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken()); // 정점의 개수
		E=Integer.parseInt(st.nextToken()); // 간선의 개수
		int K = Integer.parseInt(br.readLine()); // 시작점
		graph=new LinkNode[V+1];

		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken()); 
			int w=Integer.parseInt(st.nextToken()); 
			graph[u]=new LinkNode(v, w, graph[u]);
		}

		dijkstra(K);
		for (int i = 1; i < V+1; i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				sb.append("INF");
				sb.append("\n");
				continue;
			}
			sb.append(dist[i]);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	private static void dijkstra(int start) {
		dist=new int[V+1];
		boolean[] visited=new boolean[V+1];
		PriorityQueue<LinkNode> pq=new PriorityQueue<>();
		
		// 자원 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		// pq에 가장 작은 점 넣어주기
		pq.add(new LinkNode(start, 0));
		
		while(!pq.isEmpty()) {
			LinkNode minDistNode=pq.poll();
			if (visited[minDistNode.no]) continue;
			
			visited[minDistNode.no]=true;
			
			LinkNode next=graph[minDistNode.no];
			
			while (next!=null) {
				if(!visited[next.no] && dist[next.no]>dist[minDistNode.no]+next.weight) {
					dist[next.no]=dist[minDistNode.no]+next.weight;
					pq.add(new LinkNode(next.no, dist[next.no]));
				}
				next=next.pre;
			}
		}
	}
	private static String str="5 6\r\n" + 
			"1\r\n" + 
			"5 1 1\r\n" + 
			"1 2 2\r\n" + 
			"1 3 3\r\n" + 
			"2 3 4\r\n" + 
			"2 4 5\r\n" + 
			"3 4 6";
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see https://www.acmicpc.net/problem/10282
 * @category 다익스트라
 * a->b가 아니라 b->a로 해주어야 함
 * 주의! 다익스트라 우선순위 큐 코드
 */
public class BOJ_10282_해킹 {
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		Node link;
		
		public Node(int vertex, int weight, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	static int MAX=10_000_000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
				
			Node[] graph=new Node[n+1];
			
			for (int i = 0; i < d; i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int s=Integer.parseInt(st.nextToken());
				graph[b]=new Node(a, s, graph[b]); // 단방향
			}
			// 입력 완료
			
			
			boolean[] visited=new boolean[n+1];
			
			int[] distance=new int[n+1];
			Arrays.fill(distance, MAX);
			distance[c]=0;
			
			PriorityQueue<Node> pq=new PriorityQueue<>();
			pq.add(new Node(c,0));
			
			int cnt=0;
			int max=0;
			
			// 다익스트라
			// 해킹당한 컴퓨터~노드의 최단거리 구해줌
			while(!pq.isEmpty()) {
				Node curr=pq.poll();
				int v=curr.vertex;
				// 방문했다면 넘어감
				if(visited[v]) continue;
				
				visited[v]=true;
				
				for (Node next=graph[v]; next!=null; next=next.link) {
					int nextv=next.vertex;
					int nextw=next.weight;
					if(!visited[nextv] && distance[nextv]>distance[v]+nextw) {
						distance[nextv]=distance[v]+nextw;
						pq.add(new Node(nextv, distance[nextv]));
					}
				}
			}
//			System.out.println(Arrays.toString(distance));
			
			for (int i = 1; i < n+1; i++) {
				if(distance[i]!=MAX) {
					cnt++;
					max=Math.max(max, distance[i]);
				}
			}

			sb.append(cnt).append(" ").append(max).append("\n");
		}
		System.out.println(sb);

	}

}
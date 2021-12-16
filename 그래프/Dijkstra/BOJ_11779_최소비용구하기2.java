import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 44868	344
 * @author CHO
 * @see https://www.acmicpc.net/problem/11779
 * @category Dijkstra + 최단경로 구하기
 *
 */
public class BOJ_11779_최소비용구하기2 {
	static class Node implements Comparable<Node>{
		int vertex;
		Node link;
		int weight;
		
		public Node(int vertex, Node link, int weight) {
			super();
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
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
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Node[] list=new Node[N+1];
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a]=new Node(b, list[a], w);
		}
		
		st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken()); //입력 완료
		
		int distance[]=new int[N+1];
		boolean visited[]=new boolean[N+1];
		int parents[]=new int[N+1]; // 부모노드
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start]=0;
		ArrayList<Integer> node=new ArrayList<>();
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(start, 0));
		int before=start;
		while(!pq.isEmpty()) {
			Node curr=pq.poll();
			if(visited[curr.vertex]) continue;
			visited[curr.vertex]=true;
			node.add(curr.vertex);
			for (Node next=list[curr.vertex]; next!=null; next=next.link) {
				if(!visited[next.vertex] && distance[next.vertex]>curr.weight+next.weight) {
					distance[next.vertex]=curr.weight+next.weight;
					pq.add(new Node(next.vertex, distance[next.vertex]));
					parents[next.vertex]=curr.vertex; // 최단 경로 구하기
				}
			}
		}
		Stack<Integer> stack=new Stack<>();
		int curr=end;
		for (int i = 1; i < N+1; i++) {
			if(curr==start) break;
			stack.push(curr);
			curr=parents[curr];
		}
		stack.push(curr); // 최단 경로 구하기
		System.out.println(distance[end]);
		System.out.println(stack.size());
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
	}
}

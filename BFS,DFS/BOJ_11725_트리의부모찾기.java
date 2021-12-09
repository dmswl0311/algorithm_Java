import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 51412	464
 * @author CHO
 * @see https://www.acmicpc.net/problem/11725
 * @category 그래프,트리,BFS
 * 
 */
public class BOJ_11725_트리의부모찾기 {
	static int current;
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}
	static StringTokenizer st;
	static Node[] list;
	static int[] parents;
	static int N;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list=new Node[N+1];
		for (int i = 0; i < N-1; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a]=new Node(b,list[a]);
			list[b]=new Node(a,list[b]);
		}// 입력 완료
		
		
		parents=new int[N+1];
		
		bfs(1);
		for (int i = 2; i < N+1; i++) {
			sb.append(parents[i]).append("\n");
		}
		System.out.println(sb);
	}
	private static void bfs(int start) {
		boolean[] visited=new boolean[N+1];
		visited[start]=true;
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(start);
		while(!q.isEmpty()) {
			int now=q.poll();
			for (Node next=list[now]; next!=null; next=next.link) {
				if(!visited[next.vertex]) {
					visited[next.vertex]=true;
					parents[next.vertex]=now;
					q.add(next.vertex);
				}
			}
		}
		
	}
}

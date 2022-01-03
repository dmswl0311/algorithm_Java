import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5972_택배배송 {
	static class Node{
		int vertex;
		Node link;
		int weight;
		public Node(int vertex, Node link, int weight) {
			super();
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}
		
	}
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Node[] list=new Node[N+1];
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a]=new Node(b, list[a], w); 
			list[b]=new Node(a, list[b], w); // 양방향
		}// 입력 완료
		
		boolean[] visited=new boolean[N+1];
		int[] distance=new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1]=0;
		
		for (int i = 0; i < N; i++) {
			int v=0;
			int min=Integer.MAX_VALUE;
			for (int j = 1; j < N+1; j++) {
				if(!visited[j] && min>distance[j]) {
					v=j;
					min=distance[j];
				}
			}
			visited[v]=true;
			for (Node next=list[v]; next!=null; next=next.link) {
				if(!visited[next.vertex] && distance[next.vertex]>min+next.weight) {
					distance[next.vertex]=min+next.weight;
				}
			}
		}// distance 구함
		
		System.out.println(distance[N]);
	}
}

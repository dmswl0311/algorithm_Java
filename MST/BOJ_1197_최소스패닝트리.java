import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 46912	632
 * @author CHO
 * @see https://www.acmicpc.net/problem/1197
 * @category MST-PRIM
 * prim 기본 코드
 */
public class BOJ_1197_최소스패닝트리 {
	static class Node{
		int vertex;
		int weight;
		Node link;
		
		public Node(int vertex, int weight, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
		
	}
	static String str="3 3\r\n" + 
			"1 2 1\r\n" + 
			"2 3 2\r\n" + 
			"1 3 3";
	static StringTokenizer st;
	public static void main(String[] args) throws IOException,NumberFormatException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		
		Node[] nodeList=new Node[V+1];
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			nodeList[a]=new Node(b, c, nodeList[a]);
			nodeList[b]=new Node(a, c, nodeList[b]);
		}// 입력 완료
		
		int result=0;
		
		// PRIM 
		int[] distance=new int[V+1];
		boolean[] visited=new boolean[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1]=0;
		
		for (int i = 0; i < V; i++) {
			int vertex=0;
			int min=Integer.MAX_VALUE;
			for (int j = 1; j < V+1; j++) {
				if(!visited[j] && min>distance[j]) {
					vertex=j;
					min=distance[j];
				}
			}
			visited[vertex]=true;
			result+=min;
			
			for (Node next=nodeList[vertex]; next!=null; next=next.link) {
				if(!visited[next.vertex] && distance[next.vertex]>next.weight) {
					distance[next.vertex]=next.weight;
				}
			}
		}
		
		System.out.println(result);

	}

}

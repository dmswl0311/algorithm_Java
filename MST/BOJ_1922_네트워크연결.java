import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 45488	348
 * @author CHO
 * @see https://www.acmicpc.net/problem/1922
 * @category 최소 스패닝 트리, MST, PRIM
 * 인접리스트를 이용한 PRIM
 */
public class BOJ_1922_네트워크연결 {
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
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", link=" + link + "]";
		}
				
	}
	static StringTokenizer st;
	static Node[] nodeList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		nodeList=new Node[N+1];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			if(x==y) {
				nodeList[x]=new Node(y, w, nodeList[x]); 
				continue;
			}
			nodeList[x]=new Node(y, w, nodeList[x]);
			nodeList[y]=new Node(x, w, nodeList[y]);
		}
		
//		System.out.println(Arrays.toString(nodeList));
		int result=0;
		boolean[] visited=new boolean[N+1];
		int[] distance=new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1]=0;
		
		for (int n = 0; n < N; n++) {
			int min=Integer.MAX_VALUE;
			int vertex=0;
			for (int i = 1; i < N+1; i++) {
				if(!visited[i] && min>distance[i]) {
					vertex=i;
					min=distance[i];
				}
			}
			visited[vertex]=true;
			result+=min;
			
			for (Node next=nodeList[vertex]; next!=null; next=next.link) {
				int curr=next.vertex;
				if(!visited[curr] && distance[curr]>next.weight) {
					distance[curr]=next.weight;
				}
			}
		}
		
		System.out.println(result);
	}

}

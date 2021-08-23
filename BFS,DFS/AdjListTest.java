import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 인접리스트로 BFS,DFS
 * @author CHO
 * 연결리스트 생성 **
 * for문 조건 **
 */
public class AdjListTest {
	static class Node{
		int vertex; // 인접 정점 인덱스
		Node link;
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
				
	}
	static int N;
	static Node[] adjList; // 인접리스트 시작이 되는 노드만 가지고 있으면 됨 
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(in.readLine());
		adjList=new Node[N];
		int C=Integer.parseInt(in.readLine());
		for (int i = 0; i < C; i++) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			// 앞으로 추가 
			adjList[from]=new Node(to, adjList[from]);
			adjList[to]=new Node(from,adjList[to]);
		}
		System.out.println("===============bfs");
		bfs();
		System.out.println("===============dfs");
		boolean[] visited=new boolean[N];
		dfs(0, visited);

	}

	private static void bfs() {
		Queue<Integer> queue=new LinkedList<Integer>();
		boolean[] visited=new boolean[N];
		queue.add(0);
		visited[0]=true;
		while(!queue.isEmpty()) {
			int current=queue.poll();
			System.out.println((char)(current+65));
			// ** for문 조건 
			for(Node temp=adjList[current]; temp!=null; temp=temp.link) {
				if (!visited[temp.vertex]) {
					visited[temp.vertex]=true;
					queue.add(temp.vertex);
				}
			}
		}

	}
	private static void dfs(int current, boolean[] visited) {
		visited[current]=true;
		System.out.println((char)(current+65));
		
		for(Node temp=adjList[current]; temp!=null; temp=temp.link) {
			if (!visited[temp.vertex]) {
				dfs(temp.vertex,visited);
			}
		}
		
	}

}

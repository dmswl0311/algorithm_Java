import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author CHO
 * @see https://www.acmicpc.net/problem/1260
 * 인접리스트, ArrayList 이용
 * 양방향 간선 주의!, ArrayList 정렬 주의! 
 */

public class BOJ_1260_DFS와BFS {
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> graph;
	static int N;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		graph=new ArrayList<>();
		
		for (int i=0; i<N+1; i++) {
			graph.add(i, new ArrayList<Integer>());
		}
		
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int vertex = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph.get(vertex).add(value);
			graph.get(value).add(vertex);
		}
		// ArrayList 정렬
		for (int i=0; i<N+1; i++) {
			Collections.sort(graph.get(i));
		}
		boolean[] visited=new boolean[N+1];
		dfs(V,visited);
		sb.append("\n");
		bfs(V);
		System.out.println(sb);

	}

	// dfs
	private static void dfs(int start, boolean[] visited) {
		visited[start]=true;
		sb.append(start).append(" ");
		for(int i=0; i<graph.get(start).size(); i++) {
			if (!visited[graph.get(start).get(i)]) {
				dfs(graph.get(start).get(i),visited);
			}
		}	
	}

	// bfs
	private static void bfs(int start) {
		Queue<Integer> queue=new LinkedList<Integer>();
		boolean visited[]=new boolean[N+1];
		queue.add(start);
		visited[start]=true;
		while(!queue.isEmpty()) {
			int pop=queue.poll();
			sb.append(pop).append(" ");
			for(int i=0; i<graph.get(pop).size(); i++) {
				if (!visited[graph.get(pop).get(i)]) {
					queue.add(graph.get(pop).get(i));
					visited[graph.get(pop).get(i)]=true;
				}
			}
		}
		
	}

}

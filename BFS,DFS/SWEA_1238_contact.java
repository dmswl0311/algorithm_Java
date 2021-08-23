import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author CHO
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE&problemTitle=1238
 * 가장 깊이 들어간 정점 중 큰 정점 
 * 인접리스트
 */

public class SWEA_1238_contact {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int[] depth;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int t = 1; t < T + 1; t++) {
			st=new StringTokenizer(br.readLine());
			int L=Integer.parseInt(st.nextToken());
			int start=Integer.parseInt(st.nextToken());
			graph=new ArrayList<ArrayList<Integer>>();;

			st=new StringTokenizer(br.readLine());
			for (int i = 0; i < 101; i++) {
				graph.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < L/2; i++) {
				int index=Integer.parseInt(st.nextToken());
				int value=Integer.parseInt(st.nextToken());
				if (graph.get(index).contains(value)) {
					continue;
				}
				graph.get(index).add(value);
			}
			
			visited=new boolean[101];
			depth=new int[101];
			int max=Integer.MIN_VALUE;
			int result=0;
			bfs(start);
			
			for (int i = 0; i < 101; i++) {
				if(max<=depth[i]) {
					max=depth[i];
					if (result<i) result=i;
				}
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}
	private static void bfs(int s) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(s);
		visited[s]=true;
		while(!queue.isEmpty()) {
			int p=queue.poll();

			for (int i=0; i<graph.get(p).size(); i++) {
				if (!visited[graph.get(p).get(i)]) {
					visited[graph.get(p).get(i)]=true;
					queue.add(graph.get(p).get(i));
					depth[graph.get(p).get(i)]=depth[p]+1;
				}
			}
		}
	}

}

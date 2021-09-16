import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSplitPaneUI;
/**
 * 17124	756
 * @author CHO
 * @see https://www.acmicpc.net/problem/1238
 * @category Dijkstra(다익스트라), 인접리스트
 */
public class BOJ_1238_파티 {
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
	static Node[] nodeList;
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	static int N,M,X;
	static int[] result,distance;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		
		nodeList=new Node[N+1];
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			//단방향
			nodeList[n]=new Node(m, w, nodeList[n]);
		}
		
		result=new int[N+1];
		distance = new int[N+1];

		// 집 -> X 거리구하기 
		// 집 돌아가면서 다익스트라로 거리 구함
		for (int h = 1; h < N+1; h++) {
			visited=new boolean[N+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[h]=0;
			dijkstra(h);
			
			// 집마다 집->X 구하면 
			result[h]+=distance[X];
		}
		
		// X->집
		visited=new boolean[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[X]=0;
		dijkstra(X);
		
		int max=0;
		
		for (int i = 1; i < N+1; i++) {
			result[i]+=distance[i];
			max=max<result[i]?result[i]:max;
		}
		
		System.out.println(max);

	}
	private static void dijkstra(int h) {
		for (int i = 0; i < N; i++) {
			int vertex=0;
			int min=Integer.MAX_VALUE;
			
			for (int j = 1; j < N+1; j++) {
				if(!visited[j] && min>distance[j]) {
					min=distance[j];
					vertex=j;
				}
			}
			
			visited[vertex]=true;

			for (Node next=nodeList[vertex]; next!=null; next=next.link) {
				if(!visited[next.vertex] && distance[next.vertex]>min+next.weight) {
					distance[next.vertex]=min+next.weight;
				}
			}
		}
		
	}
}

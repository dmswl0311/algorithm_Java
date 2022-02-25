package algo;

import java.io.*;
import java.util.*;

/**
 * 42576	316
 * @author CHO
 * @see https://www.acmicpc.net/problem/14284
 * @category dijkstra
 */
public class BOJ_14284_간선이어가기2 {
	static class Node{
		int vertex;
		int weight;
		Node link;
		
		public Node(int vertex, int weight, Node link) {
			this.vertex=vertex;
			this.weight=weight;
			this.link=link;
		}
	}
	
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Node[] list=new Node[n+1];
		for (int i = 0; i < m; i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a]=new Node(b, w, list[a]);
			list[b]=new Node(a, w, list[b]); //무방향
		}
		st=new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());// 입력 완료
		
		int[] distance=new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[s]=0;
		boolean[] vis=new boolean[n+1];
		
		for (int i = 1; i < n+1; i++) {
			int v=0;
			int min=Integer.MAX_VALUE;
			for (int j = 1; j < n+1; j++) {
				if(!vis[j] && min>distance[j]) {
					min=distance[j];
					v=j;
				}
			}
			vis[v]=true;
			if(v==t) {
				break;
			}
			for (Node next=list[v]; next!=null; next=next.link) {
				if(!vis[next.vertex] && distance[next.vertex]>min+next.weight) {
					distance[next.vertex]=min+next.weight;
				}
			}
		}
//		System.out.println(Arrays.toString(distance));
		System.out.println(distance[t]);

	}
}

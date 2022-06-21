package BFS_DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 시간초과 주의!!
 * @author CHO
 * @see https://www.acmicpc.net/problem/1325
 * @category DFS,BFS
 * @warning 뒤에서부터 탐색, 탐색되는 노드를 바로 +1
 */
public class BOJ_1325_효율적인해킹 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static List<Integer>[] list;
	static int[] result;
	static boolean[] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			list[i]=new ArrayList<>();
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
		}
		System.out.println(Arrays.toString(list));
		result = new int[N + 1];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < N + 1; i++) {
			vis = new boolean[N + 1];
			System.out.print(i+"일때 ");
			dfs(i);
			System.out.println();
		}
		for (int i = 1; i < N + 1; i++) {
			max=Math.max(max, result[i]);
		}
		for (int i = 1; i < N + 1; i++) {
			if (result[i] == max)
				bw.write(i+" ");
		}
		bw.flush();
		bw.close();
	}

	private static void dfs(int cur) {
		vis[cur] = true;
		for(int node:list[cur]) {
			if (!vis[node]) {
				System.out.print(node+" ");
				result[node]+=1;
				dfs(node);
			}
		}
	}

}

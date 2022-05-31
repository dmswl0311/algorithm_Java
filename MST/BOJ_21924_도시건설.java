package algo;

import java.io.*;
import java.util.*;

/**
 * 191948	1192
 * @author CHO
 * @see https://www.acmicpc.net/problem/21924
 * @tip 우선순위 큐 사용, long 사용!
 */
public class BOJ_21924_도시건설 {
	static class Node implements Comparable<Node> {
		int vertex;
		int weight;
		Node link;

		public Node(int vertex, int weight, Node link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Node[] list = new Node[N + 1];
		long total = 0;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[x] = new Node(y, w, list[x]);
			list[y] = new Node(x, w, list[y]);
			total += w;
		} // 입력완료

		PriorityQueue<Node> pq;
		boolean[] vis;
		long result = Long.MAX_VALUE;

		pq = new PriorityQueue<>();
		pq.add(new Node(1, 0, list[1]));
		vis = new boolean[N + 1];
		boolean flag = true;

		while (!pq.isEmpty()) {
			Node n = pq.poll();
			if (vis[n.vertex])
				continue;
			vis[n.vertex] = true;
			result += n.weight;
			for (Node next = list[n.vertex]; next != null; next = next.link) {
				if (!vis[next.vertex])
					pq.add(next);
			}
		}
		for (int i = 1; i < N + 1; i++) {
			if (!vis[i]) {
				flag = false;
				break;
			}
		}
		if (!flag || result == Long.MAX_VALUE)
			System.out.println(-1);
		else {
			System.out.println(total - result);
		}

	}
}

package algo;

import java.io.*;
import java.util.*;

/**
 * 11688	80
 * @author CHO
 * @see https://www.acmicpc.net/problem/2644
 * @category BFS, ±×·¡ÇÁ Å½»ö
 */
public class BOJ_2644_ÃÌ¼ö°è»ê {
	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}

	static StringTokenizer st;
	static int N, start, end, M;
	static Node[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());

		list = new Node[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x] = new Node(y, list[x]);
			list[y] = new Node(x, list[y]);
		}

		bfs(start);

	}

	private static void bfs(int s) {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		boolean vis[] = new boolean[N + 1];
		vis[s] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				if (cur == end) {
					System.out.println(cnt);
					return;
				}
				for(Node next=list[cur]; next!=null; next=next.link) {
					if(!vis[next.vertex]) {
						vis[next.vertex]=true;
						q.add(next.vertex);
					}
				}
			}
			cnt++;
		}
		System.out.println(-1);
	}
}

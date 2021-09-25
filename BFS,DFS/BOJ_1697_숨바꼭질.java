import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 	20420	144
 * @author CHO
 * @see https://www.acmicpc.net/problem/1697
 * @category DFS
 */
public class BOJ_1697_숨바꼭질 {
	static StringTokenizer st;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		cnt=0;
		bfs(N,K);
		System.out.println(cnt);
	}
	private static void bfs(int n, int k) {
		boolean visited[]=new boolean[200001];
		Queue<Integer> q=new LinkedList<>();
		visited[n]=true;
		q.add(n);
		while(!q.isEmpty()) {
			int s=q.size();
			while(s-->0) {
				int x=q.poll();
				if(x==k) {
					return;
				}
				
				if(x-1>=0&&!visited[x-1]) {
					q.add(x-1);
					visited[x-1]=true;
				}
				if(!visited[x+1]) {
					q.add(x+1);
					visited[x+1]=true;
				}
				if(2*x<=100001&&!visited[2*x]) {
					q.add(2*x);
					visited[2*x]=true;
				}
			}
			cnt++;
		}
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see https://www.acmicpc.net/problem/10974
 * @author CHO
 * @category 순열
 */
public class BOJ_10974_모든순열 {
	static StringTokenizer st;
	static int N;
	static int[] pick;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		boolean[] visited=new boolean[N+1];
		pick=new int[N];
		
		permutation(0,visited);
	}

	private static void permutation(int cnt, boolean[] visited) {
		if(cnt==N) {
			for(int i : pick) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i < N+1; i++) {
			if(visited[i]) continue;
			pick[cnt]=i;
			visited[i]=true;
			permutation(cnt+1, visited);
			visited[i]=false;
		}
		
	}
}

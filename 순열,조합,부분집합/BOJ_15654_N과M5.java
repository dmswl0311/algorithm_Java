import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 78260	2520
 * @author CHO
 * @see https://www.acmicpc.net/problem/15654
 * @category 순열
 */

public class BOJ_15654_N과M5 {
	static StringTokenizer st;
	static int N,M;
	static ArrayList<Integer> list;
	static int[] pick;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list=new ArrayList<>();
		st=new StringTokenizer(br.readLine());
		int max=0;
		for (int i = 0; i < N; i++) {
			int num=Integer.parseInt(st.nextToken());
			list.add(num);
			max=max<num?num:max;
		}// 입력 완료
		Collections.sort(list);
		boolean visited[]=new boolean[N];
		pick=new int[M];
		permutation(0,M,visited);

	}

	private static void permutation(int cnt, int R, boolean[] visited) {
		if(cnt==R) {
			for(int x:pick) {
				System.out.print(x+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			pick[cnt]=list.get(i);
			visited[i]=true;
			permutation(cnt+1, R, visited);
			visited[i]=false;
		}
		
	}

}

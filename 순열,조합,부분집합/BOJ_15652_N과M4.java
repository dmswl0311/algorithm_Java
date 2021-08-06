package collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 중복 조합
 * isVisted 사용 x 
 */

public class BOJ_15652_N과M4 {
	static int N,R;
	static StringTokenizer st;
	static int nums[];
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		nums=new int[R];
		collections(0,1);
		System.out.println(sb);
	}
	private static void collections(int cnt, int start) {
		if (cnt==R) {
			for(int i:nums) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=start; i<N+1; i++) {
			nums[cnt]=i;
			collections(cnt+1, i);
		}
	}

}

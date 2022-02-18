import java.io.*;
import java.util.*;

/**
 * 11856	84
 * @author CHO
 * @see https://www.acmicpc.net/problem/16953
 * @category DFS
 */
public class BOJ_16953_AB {

	static StringTokenizer st;
	static long A, B, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		min = Integer.MAX_VALUE;
		dfs(B, 0);
		System.out.println(min + 1);
	}

	private static void dfs(long cur, int cnt) {
		if (cur == A) {
			min = min > cnt ? cnt : min;
			return;
		} else if (cur < A) {
			System.out.println(-1);
			System.exit(0);
		}
		if (cur % 2 == 0) {
			dfs(cur / 2, cnt + 1);
		}
		String str = String.valueOf(cur);
		if (str.charAt(str.length() - 1) == '1') {
			dfs(Long.parseLong(str.substring(0, str.length() - 1)), cnt + 1);
		}
		if (str.charAt(str.length() - 1) != '1' && cur % 2 != 0) {
			System.out.println(-1);
			System.exit(0);
		}
	}
}

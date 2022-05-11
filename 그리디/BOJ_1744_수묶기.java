package algo;

import java.io.*;
import java.util.*;

/**
 * 11540	76
 * @author CHO
 * @see https://www.acmicpc.net/problem/1744
 * @category 그리디
 */
public class BOJ_1744_수묶기 {

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder()); // 양수 내림차순
		PriorityQueue<Integer> minus = new PriorityQueue<>(); // 음수 내림차순
		boolean zero = false;
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 0)
				plus.add(num);
			else if (num < 0)
				minus.add(num);
			else
				zero = true;
		}
		int result = 0;
		while (!plus.isEmpty()) {
			int x = plus.poll();
			if(plus.isEmpty()) {
				// 만약 마지막이라면
				result+=x;
			}else {
				int y = plus.poll();
				if (x + y > (x * y)) {
					result += (x + y);
				}else result += (x * y);
			}
		}
		while (!minus.isEmpty()) {
			int x = minus.poll();
			if(minus.isEmpty()) {
				if(!zero) result+=x; //0이 있으면 -를 더하는 것보다 0을 곱해서 더하는것이 더 큰 숫자를 만들 수 있기 때문에
			}else {
				int y = minus.poll();
				if (x + y > (x * y)) {
					result += (x + y);
				}else result += (x * y);
			}
		}
		System.out.println(result);
	}
}

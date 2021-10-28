package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 101184	764
 * @author CHO
 * @see https://www.acmicpc.net/problem/5430
 * @category 문자열처리,덱
 * StringTokenizer로 문자열 분리, 덱 사용 
 */
public class BOJ_5430_AC2 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Deque<Integer> deque; // 양방향 입출력 가능
		for (int t = 0; t < T; t++) {
			deque=new ArrayDeque<>();
			char[] p=(br.readLine()).toCharArray();
			int n=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine(),",[]");
			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}//입력 완료
			//System.out.println(Arrays.toString(list));
			boolean reverse=false;
			boolean flag=true;
			for (int i = 0; i < p.length; i++) {
				if(p[i]=='R') {
					if(reverse) reverse=false;
					else reverse=true;
				}else if(p[i]=='D') {
					if(deque.isEmpty()) {
						flag=false;
						break;
					}
					if(reverse) deque.pollLast();
					else deque.pollFirst();
				}
			}
			if(flag) {
				sb.append("[");
				if(!deque.isEmpty()) {
					int size=deque.size();
					if(reverse) {
						for (int i = 0; i < size; i++) {
							sb.append(deque.pollLast());
							if(i==size-1) break;
							sb.append(",");
						}
					}else {
						for (int i = 0; i < size; i++) {
							sb.append(deque.poll());
							if(i==size-1) break;
							sb.append(",");
						}
					}
					
				}
				sb.append("]").append("\n");
			}else {
				sb.append("error").append("\n");
			}
		}
		System.out.println(sb);
	}
}

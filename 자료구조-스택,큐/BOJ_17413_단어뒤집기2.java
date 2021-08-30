import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * 스택,큐
 * @author CHO
 * @see https://www.acmicpc.net/problem/17413
 */
public class BOJ_17413_단어뒤집기2 {
//	static String S="<int><max>2147483647<long long><max>9223372036854775807";
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new StringReader(S));
		String str=br.readLine();
		char[] list=str.toCharArray();
		boolean flag=false;
		Queue<Character> queue=new LinkedList<Character>();
		Stack<Character> stack=new Stack<>();
		
		for (int i = 0; i < list.length; i++) {
			if(i==list.length-1) {
				if(flag) {
					while(!queue.isEmpty()) sb.append(queue.poll());
					sb.append(list[i]);
				}else {
					sb.append(list[i]);
					while(!stack.isEmpty()) sb.append(stack.pop());
				}
				break;
			}
			if(list[i]=='<') {
				while(!stack.isEmpty()) sb.append(stack.pop());
				flag=true;
			}else if(list[i]=='>') {
				while(!queue.isEmpty()) sb.append(queue.poll());
				sb.append(list[i]);
				flag=false;
				continue;
			}else if(list[i]==' ' && !flag) {
				while(!stack.isEmpty()) sb.append(stack.pop());
				sb.append(list[i]);
				continue;
			}
			if(flag) queue.add(list[i]);
			else stack.add(list[i]);
		}
		
		System.out.println(sb);
	}
}

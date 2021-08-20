import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1223_계산기2 {
    static StringBuilder sb=new StringBuilder();
    static StringTokenizer st;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T= 10;
        for (int t=1; t<T+1; t++) {
            N=Integer.parseInt(br.readLine());
            String str=br.readLine();
            Queue<Character> queue=new LinkedList<Character>();
            for (int i=0; i<N; i++) {
            	queue.add(str.charAt(i));
            }
            Stack<Integer> stack=new Stack<>();
            
            while(!queue.isEmpty()) {
            	if (queue.peek()=='*') {
            		queue.poll(); // * 빼내기
            		int cal_num=queue.poll()-'0'; //* 다음수 빼내기
            		int top=stack.pop();
            		int cal=cal_num*top; 
            		stack.push(cal); // 계산한 결과 다시 stack에 넣기
            	}else if(queue.peek()=='+') queue.poll();
            	else {
            		int num=queue.poll()-'0';
            		stack.push(num);
            	}
            }
            int sum=0;
            for(int n=0; n<stack.size(); n++) {
            	sum+=stack.pop();
            	n--;
            }
          	sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
	}

}

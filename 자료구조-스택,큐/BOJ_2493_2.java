package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_2 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array=new int[N+1];
		Stack<int[]> stack=new Stack<>();
		st=new StringTokenizer(br.readLine());
		for (int i=1; i<N+1; i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<N+1; i++) {
			while(!stack.isEmpty()){
				if(stack.peek()[1]>array[i]) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) {
				sb.append(0).append(" ");
			}
			stack.push(new int[] {i,array[i]});
				
		}	
		
		System.out.println(sb);
	}

}

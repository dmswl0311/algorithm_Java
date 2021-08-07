package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_5432_쇠막대기자르기 {
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t=1; t<T+1; t++) {
			int result=0;
			String str=br.readLine();
			char[] data=str.toCharArray();
			Stack<Character> stack=new Stack<>();
			char front='(';
			for (int i=0; i<data.length; i++) {
				if(data[i]=='(') {
					stack.push(data[i]);
				}else if(data[i]==')') {
					stack.pop();
					if(front=='(') {
						// 레이저의 조건
						result+=stack.size();
					}
					else {
						// 막대의 조건
						result+=1;
					}
				}
				front=data[i];
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
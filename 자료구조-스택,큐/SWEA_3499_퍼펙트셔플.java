package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWEA_3499_퍼펙트셔플 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			Stack<String> s1= new Stack<>();
			Stack<String> s2= new Stack<>();
			int N = Integer.parseInt(br.readLine());
			String[] list=new String[N];
			int mid=(N%2==0)?N/2-1:N/2;
			st=new StringTokenizer(br.readLine()," ");
			sb.append("#").append(t).append(" ");
			for(int i=0; i<N; i++) {
				list[i]=st.nextToken();
			}
			for(int i=mid; i>-1; i--) {
				s1.add(list[i]);
			}
			for(int i=N-1; i>mid; i--) {
				s2.add(list[i]);
			}
			while(true) {
				if(s1.isEmpty() && s2.isEmpty()) break;
				if(!s1.isEmpty()) sb.append(s1.pop()).append(" ");
				if(!s2.isEmpty()) sb.append(s2.pop()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}

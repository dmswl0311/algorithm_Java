package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=10;
		for (int t=1; t<T+1; t++) {
			int k=Integer.parseInt(br.readLine()); // 테스트케이스 번호
			int plus=0;
			Queue<Integer> q=new LinkedList<>();
			st=new StringTokenizer(br.readLine()," ");
			for (int i=0; i<8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			int flag=0;
			while(flag==0) {
				for (int i=1; i<=5; i++) {
					int first=q.poll();
					if (first-i<=0) {
						plus=0;
						q.add(plus);
						flag=1;
						break;
					}else {
						plus=first-i;
						q.add(plus);
					}
				}
			}
			sb.append("#").append(t).append(" ");
			for (int i=0; i<8; i++) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

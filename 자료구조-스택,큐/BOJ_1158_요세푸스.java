package com.ssafy.ws;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158_요세푸스 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		Queue<Integer> data=new LinkedList<>();
		for (int i=1; i<n+1; i++) {
			data.add(i);
		}
		sb.append("<");
		while(data.size()!=1) {
			for (int i=0; i<m-1; i++) {
				data.add(data.poll());
			}
			sb.append(data.poll()).append(", ");
		}
		sb.append(data.poll()).append(">");
		System.out.println(sb);
	}

}

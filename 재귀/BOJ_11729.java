package com.ssafy.ws;

import java.util.Scanner;

public class BOJ_11729 {
	public static int result;
	public static StringBuilder st=new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		result=0;
		hanoi(N,1,2,3);
		System.out.println(result);
		System.out.println(st);
		
		

	}
	private static void hanoi(int n,int start,int temp,int end) {
		if(n==0) {
			return;
		}
		// 내 위에 원판들 옮기기
		hanoi(n-1,start,end,temp);
		st.append(start).append(" ").append(end).append("\n");
		result++;
		//옮긴 원판들 자신 위에 놓기
		hanoi(n-1,temp,start,end);
	}

}

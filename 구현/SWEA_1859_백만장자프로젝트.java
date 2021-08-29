package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author CHO
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc&categoryId=AV5LrsUaDxcDFAXc&categoryType=CODE&problemTitle=1859
 * 구현
 * 뒤에서부터 큰 수 나올 때 까지 사재기 
 * int x -> long으로 구현해야함 ﻿
 */

public class SWEA_1859_백만장자프로젝트 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			long result=0;
			int N=Integer.parseInt(br.readLine());
			long[] list=new long[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N+1; i++) {
				int price = Integer.parseInt(st.nextToken());
				list[i]=price;
			}
			long cnt=0;
			long buy=0;
			for (int j = N; j > 1; j--) {
				long current=list[j];
				for (int i = j-1; i >0; i--) {
					if(i==1) {
						if(current>list[i]) {
							cnt++;
							buy+=list[i];
						}else {
							j=i+1;
							break;
						}
						result+=(cnt*current)-buy;
						j=i+1;
					}else {
						if(current>list[i]) {
							cnt++;
							buy+=list[i];
						}else {
							result+=(cnt*current)-buy;
							cnt=0;
							buy=0;
							j=i+1;
							break;
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		

	}

}

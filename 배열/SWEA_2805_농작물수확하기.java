package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805_농작물수확하기 {
	private static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine()); // 테케 수
		for(int t=1; t<T+1; t++) {
			// 테케 수만큼 반복
			int N=Integer.parseInt(br.readLine());
			int[][] map=new int[N][N];
			
			for (int i=0; i<N; i++) {
				String str=br.readLine();
				for (int j=0; j<N; j++) {
					int num=str.charAt(j)-'0';
					map[i][j]=num;
				}
			}
			
			int mid=N/2;
			int sum=0;
			int cnt=0;
			
			for (int r=0; r<=mid; r++) {
				for (int c=mid-r; c<=mid+cnt; c++) {
					sum+=map[r][c];
				}
				cnt++;
			}
			cnt=1;
			for (int r=mid; r<N; r++) {
				for (int c=r-mid; c<=N-cnt; c++) {
					sum+=map[r][c];
				}
				cnt++;
			}
			for (int j=0; j<N; j++) {
				sum-=map[mid][j];
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

}

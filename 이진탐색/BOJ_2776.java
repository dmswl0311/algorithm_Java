package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2776 {
	private static StringBuilder sb=new StringBuilder();
	private static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			int N=Integer.parseInt(br.readLine());
			int[] nlist=new int[N];
			st=new StringTokenizer(br.readLine()," ");
			for (int n=0; n<N; n++) {
				nlist[n]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nlist);
			int M=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine()," ");
			for (int m=0; m<M; m++) {
				int num=Integer.parseInt(st.nextToken());
				if (Arrays.binarySearch(nlist, num)>=0) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}

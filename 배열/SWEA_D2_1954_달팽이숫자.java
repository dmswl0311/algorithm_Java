package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_D2_1954_달팽이숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t=1; t<T+1; t++) {
			int N=Integer.parseInt(br.readLine());
			int[][] array=new int[N][N];
			int flag=1;
			int cnt=1;
			int r=0;
			int c=-1;
			int n=N;
			System.out.println("#"+t);
			while(n>0) {
				for (int i=0; i<n; i++) {
					c+=flag;
					array[r][c]=cnt;
					cnt++;
				}
				n--;
				for (int i=0; i<n; i++) {
					r+=flag;
					array[r][c]=cnt;
					cnt++;
				}
				flag*=-1;
			}
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					System.out.print(array[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

}

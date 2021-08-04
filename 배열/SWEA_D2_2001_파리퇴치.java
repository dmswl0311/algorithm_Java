package com.ssafy.ws;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D2_2001_파리퇴치 {
	private static StringBuilder sb=new StringBuilder();
	private static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine()); // 테케 개수
		int[][] dir= {{0,1},{1,0},{1,1}}; //오른쪽옆, 아래, 오른쪽대각선아래
		for (int t=0; t<T; t++) {
			// 테캐 개수만큼 반복
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken()); 
			int M=Integer.parseInt(st.nextToken());
			
			int[][] map=new int[N][N];
			for (int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for (int j=0; j<N; j++) {
					int num=Integer.parseInt(st.nextToken());
					map[i][j]=num;
				}
			}
//			System.out.println(Arrays.deepToString(map));
			int max=0;
			int sum=0;
			
			int startC=0;
			while(startC<N-M+1) {
				//첫시작위치 + M
				//시작위치 변함=i
				int startR=0;
				while(startR<N-M+1) {
					for(int r=startR; r<startR+M; r++) {
						for (int c=startC; c<startC+M; c++) {
							sum+=map[r][c];
						}
					}
					if (max<sum) {
						max=sum;
					}
					sum=0;
					startR++;
				}
				startC++;
			}

			sb.append("#").append(t+1).append(" ").append(max).append("\n");	
		}
		System.out.println(sb);
	}

}

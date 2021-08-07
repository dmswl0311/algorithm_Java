package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형방 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
		for (int t = 1; t < T + 1; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] map=new int[N][N];
			for (int r=0; r<N; r++) {
				st=new StringTokenizer(br.readLine()," ");
				for (int c=0; c<N; c++) {
					map[r][c]=Integer.parseInt(st.nextToken());
				}
			}
			int result=N*N;
			int max=2;
			int flag=0;
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					int x=r; //이전의 좌표값
					int y=c; 
					int cnt=1;
					while(true) {
						for(int i=0; i<4; i++) {
							int nr=x+dir[i][0];
							int nc=y+dir[i][1];
							if(isOkay(nr, nc)&&(map[nr][nc]==map[x][y]+1)) {
								cnt++;
								flag=1;
								x=nr; //이동
								y=nc;
								break;
							}
						}
						if (flag==0) {
							break;
						}else flag=0;
					}
					if (max<=cnt) {
						if(max==cnt) {
							result=map[r][c]<result?map[r][c]:result;
						}else result=map[r][c];
						max=cnt;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(result).append(" ").append(max).append("\n");
		}
		System.out.println(sb);

	}
	private static boolean isOkay(int r,int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}

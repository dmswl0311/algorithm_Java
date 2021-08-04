package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_Ladder1 {
	private static StringBuilder sb=new StringBuilder();
	private static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[][] dir= {{0,1},{0,-1},{1,0}}; //밑으로 갈 때 옆이 우선 오른쪽, 왼쪽, 아래
		for (int t=0; t<10; t++) {
			int T=Integer.parseInt(br.readLine()); //테케 순서
			int[][] data=new int[100][100];
			for (int r=0; r<100; r++) {
				st=new StringTokenizer(br.readLine()," ");
				for (int c=0; c<100; c++) {
					data[r][c]=Integer.parseInt(st.nextToken());
				}
			}
			outer: for (int dc=0; dc<100; dc++) {
				if (data[0][dc]==1) {
					int[][] visited=new int[100][100];
					int r=0;
					int c=dc;
					int result=dc;
//					System.out.println("c: "+dc);
					visited[r][c]=1;
					// 탐색 시작
					while(true) {
						if (r>=99 && data[r][c]==2) {
							System.out.println("#"+(T)+" "+result);
//							sb.append("#").append(T).append(" ").append(result).append("\n");
							break outer;
						}else if(r>=99) {
							break;
						}
						int nr=0;
						int nc=0;
						for (int i=0; i<3; i++) {
							nr=r+dir[i][0];
							nc=c+dir[i][1];
							if (isOkay(nr,nc) && visited[nr][nc]==0 && (data[nr][nc]==1 || (data[nr][nc]==2))) {
								//다음으로 옮겨감
								r=nr;
								c=nc;
								visited[r][c]=1;
//								System.out.println("옮겨간 r:"+r+" c:"+c);
								break;
							}
						}
					}
				}
			}
		}
//		System.out.println(st.toString());
	}
	private static boolean isOkay(int r,int c) {
		return r>=0 && c>=0 && r<100 && c<100;
	}

}

package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author CHO
 * @see https://www.acmicpc.net/problem/10163
 */
public class BOJ_10163_색종이 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] input=new int[N+1][4];
		int maxX=Integer.MIN_VALUE;
		int maxY=Integer.MIN_VALUE;
		int[] result=new int[N+1]; // 결과를 저장할 배열
		for (int i = 1; i <N+1; i++) {
			st=new StringTokenizer(br.readLine());
			int y=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int width=Integer.parseInt(st.nextToken());
			int height=Integer.parseInt(st.nextToken());
			input[i]= new int[]{y,x,width,height};
			maxX=maxX<x+height?x+height:maxX;
			maxY=maxY<y+width?y+width:maxY;
		}
		int[][] map=new int[maxX][maxY];
		
		for (int n = 1; n <N+1; n++) {
			int y=input[n][0];
			int x=input[n][1];
			int width=input[n][2];
			int height=input[n][3];
			for (int i = x; i < x+height; i++) {
				for (int j = y; j < y+width; j++) {
					map[i][j]=n;
				}
			}
		}
		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				result[map[i][j]]+=1;
			}
		}
		for (int i = 1; i < N+1; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);

	}

}
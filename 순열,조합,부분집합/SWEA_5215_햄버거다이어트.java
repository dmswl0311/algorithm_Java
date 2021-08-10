package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분집합을 이용, 조합 nCr
public class SWEA_5215_햄버거다이어트 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	static int N,L;
	static boolean[] isVisited;
	static int[][] com;
	static int[][] input;
	static int max,sum,score;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken()); //재료 개수
			L=Integer.parseInt(st.nextToken()); //칼로리 
			input=new int[N][2]; //칼로리와 맛점수가 들어가는 재료배열
			isVisited=new boolean[N];
			max=0;
			for (int n=0; n<N; n++) {
				st=new StringTokenizer(br.readLine());
				input[n][0]=Integer.parseInt(st.nextToken());
				input[n][1]=Integer.parseInt(st.nextToken());
			}
			//1개 뽑는거부터 N개 뽑는거까지 다 해봐야함 
			for (int i=1; i<N+1; i++) {
				com=new int[i][2]; //조합 결과가 들어갈 배열
				sum=0;
				score=0;
				combination(0,0,i);
			}			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);

	}
	// 조합 
	private static void combination(int cnt, int start,int R) {
		if(cnt==R) {
			for (int x=0; x<R; x++) {
				score+=com[x][0]; //점수
				sum+=com[x][1]; //칼로리
			}
			if (sum<=L) {
				//칼로리의 합이 작거나 같고
				if(max<score) {
					max=score;
				}
			}
			sum=0;
			score=0;
			return;
		}
		for (int i=start; i<N; i++) {
			if(isVisited[i]) continue;
			com[cnt][0]=input[i][0];
			com[cnt][1]=input[i][1];
			isVisited[i]=true;
			combination(cnt+1, i+1, R);
			isVisited[i]=false;
		}
	}

}

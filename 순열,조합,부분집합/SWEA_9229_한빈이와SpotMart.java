package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합 nCr
public class SWEA_9229_한빈이와SpotMart {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	// 변수
	static int N,M;
	static int[] weight;
	static int[] nums;
	static boolean[] isVisited;
	static int max,sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken()); // 봉지 개수
			M=Integer.parseInt(st.nextToken()); // 무게 합 제한
			st=new StringTokenizer(br.readLine());
			weight=new int[N];
			nums=new int[2];
			isVisited=new boolean[N];
			max=0;
			sum=0;
			for (int n=0; n<N; n++) {
				weight[n]=Integer.parseInt(st.nextToken());
			} // 과자 봉지 무게 저장
			combination(0,0);
			if (max==0) sb.append("#").append(t).append(" ").append(-1).append("\n");
			else sb.append("#").append(t).append(" ").append(max).append("\n");
			
		}
		System.out.println(sb);

	}
	private static void combination(int cnt, int start) {
		if (cnt==2) {
			for (int x:nums) sum+=x;
			if (M>=sum) {
				if (max<sum) max=sum;
			}
			sum=0;
			return;
		}
		for (int i=start; i<N; i++) {
			if(isVisited[i]) continue;
			nums[cnt]=weight[i];
			isVisited[i]=true;
			combination(cnt+1, start+1);
			isVisited[i]=false;
		}
	}

}

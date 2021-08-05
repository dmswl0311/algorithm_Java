package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class SWEA_1218_괄호짝짓기 {
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=10;
		char[][] dir= {{'0','0'},{'(',')'},{'[',']'},{'{','}'},{'<','>'}};
		for (int t=1; t<T+1; t++) {
			int N=Integer.parseInt(br.readLine());
			String str=br.readLine();
			char[] data=str.toCharArray();
			int result=0;
			for (int i=0; i<data.length; i++) {
				// 첫번째 문자부터 비교
				char start=data[i];
				// 어떤 문자인지 알아내자
				// 찾아야 할 char 지정
				int index_x=0;
				int index_y=0;
				for (int d=1; d<dir.length; d++) {
					if (start==dir[d][0]) {
						index_x=d;
						// start가 dir[d][0]이면 찾아야 할 것은 dir[d][1]이므로
						index_y=1;
						break;
					}
					else if(start==dir[d][1]) {
						index_x=d;
						index_y=0;
						break;
					}
				}
				// 나 다음부터 찾자
				for(int j=i+1; j<data.length; j++) {
					if (data[j]==dir[index_x][index_y]) {
						data[j]='0';
						data[i]='0';
						break;
					}
				}
			}
			int cnt=0;
			for (int i=0; i<data.length; i++) {
				if(data[i]=='0') cnt++;
			}
			result=cnt==data.length?1:0;
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}

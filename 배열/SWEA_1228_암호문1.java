package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * LinkedList 사용
 * 중간에 데이터 추가와 삭제를 하더라도 
 * 인덱스가 한 칸씩 뒤로 밀리거나 당겨지지 않기 때문에
 * ArrayList에 비해서 데이터의 추가나 삭제가 용이하다.
 */
public class SWEA_1228_암호문1 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int t = 1; t < T + 1; t++) {
			int N=Integer.parseInt(br.readLine());
			LinkedList<Integer> data = new LinkedList<Integer>();
			st=new StringTokenizer(br.readLine()," ");
			for (int i=1; i<N+1; i++) {
				data.add(Integer.parseInt(st.nextToken()));
			}
			int C=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine(),"I");
			for (int i=0; i<C; i++) {
				String[] x=st.nextToken().split(" "); // 명령어
				int index=Integer.parseInt(x[1]); // 어느 노드에서부터 추가할건지
				int f=Integer.parseInt(x[2]); // 몇개를 추가할건지
				int cnt=0; // 추가된 개수만큼 노드 위치 옮겨줌 (순서대로 추가할려면 노드위치 옮겨주어야 함!)
				for (int j=3; j<f+3; j++) {
					data.add(index+cnt,Integer.parseInt(x[j]));
					cnt++;
				}
			}
			sb.append("#").append(t).append(" ");
			for (int i=0; i<10; i++){
				sb.append(data.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

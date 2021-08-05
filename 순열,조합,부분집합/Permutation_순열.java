package com.ssafy.ws;

import java.util.Arrays;

//nPr 구하기
public class Permutation_순열 {
	static int[] array; //순열에 사용할 숫자들
	static int N; //전체 숫자 개수
	static int R; //몇개를 뽑을건지
	static boolean[] isVisited; //방문 확인
	static int[] result; //순열 결과 저장하는 배열
	public static void main(String[] args) {
		array=new int[] {1,2,3,4,5};
		N=array.length;
		R=3;
		isVisited=new boolean[array.length];
		result=new int[R];
		permutation(0);
	}
	private static void permutation(int cnt) {
		if (cnt==R) {
			//R개 다 뽑았으면 return
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i=0; i<array.length; i++) {
			if (isVisited[i]) {
				// 방문했다면
				continue;
			}
			result[cnt]=array[i]; //뽑은 숫자를 result에 저장
			isVisited[i]=true; //뽑았으니까 true로
			permutation(cnt+1); //다음자리 숫자 뽑기
			isVisited[i]=false; //다시 다른 순열 뽑아야하니까 false로 다시 주기
		}
		
	}
	
}

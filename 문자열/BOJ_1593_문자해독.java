package algo;

import java.io.*;
import java.util.*;

/**
 * 33416	256
 * @author CHO
 * @see https://www.acmicpc.net/problem/1593
 * @category 슬라이딩 윈도우
 */
public class BOJ_1593_문자해독 {

	static StringTokenizer st;
	static int g, s, result;
	static String W, S;
	static int[] cnt, next;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		g = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		W = br.readLine();
		S = br.readLine();
		cnt = new int[52]; // W
		next = new int[52]; // S
		
		for (int i = 0; i < g; i++) {
			cal(i,true,cnt,W);
		}
		result = 0; 
		find();
		System.out.println(result);
	}

	private static void cal(int i, boolean flag, int[] array, String str) {
		char cur = str.charAt(i);
		if (65 <= cur && cur < 91) {
			if(flag) array[cur - 'A'] += 1;
			else array[cur - 'A'] -= 1; //대문자
		} else {
			if(flag) array[cur - 'a' + 26] += 1; 
			else array[cur - 'a' + 26] -= 1; //소문자 
		}
	}
	private static void find() {
		int start = 0;
		int end = g;
		boolean flag=true;

		for (int j = start; j < end; j++) {
			cal(j,true,next,S);
		}
		for (int j = 0; j < cnt.length; j++) {
			if (cnt[j] != next[j]) {
				flag = false;
				break;
			}
		}
		if (flag) result++; //처음은 무조건 실행
		start++;
		end++;
		while(true) {
			flag=true;
			if(end>s) break;
			cal(start-1,false,next,S); //이전의 첫번째 문자 -
			cal(end-1,true,next,S); //새로 생긴 문자 +
			// 포함되는 문자열인지 확인
			for (int j = 0; j < cnt.length; j++) {
				if (cnt[j] != next[j]) {
					flag = false;
					break;
				}
			}
			if (flag) result++;
			start++;
			end++;
		}
	}
}

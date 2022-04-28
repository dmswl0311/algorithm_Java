package algo;

import java.io.*;
import java.util.*;

/**
 * 32300	456
 * @author CHO
 * @see https://www.acmicpc.net/problem/17232
 * @category 누적합,DP
 * @tip 누적합 구하는 방법!!! 
 */
public class BOJ_17232_생명게임 {

	static StringTokenizer st;
	static int N, M, T, K, a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][M + 1];
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N + 1; i++) {
			String str = br.readLine();
			for (int j = 1; j < M + 1; j++) {
				if (str.charAt(j - 1) == '*')
					map[i][j] = 1;
			}
		} // 입력 완료
		int[][] sum = new int[N + 1][M + 1];
		int[][] copy;
		while (T-- > 0) {
			copy=new int[N+1][M+1];
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < M + 1; j++) {
					copy[i][j]=map[i][j];
				}
			}
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < M + 1; j++) {
					sum[i][j] = map[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
				}
			} // 누적합 구하기
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < M + 1; j++) {
					int Y1 = Math.max(1, i - K);
					int X1 = Math.max(1, j - K);
					int Y2 = Math.min(N, i + K);
					int X2 = Math.min(M, j + K);
					int cnt = sum[Y2][X2] - sum[Y1 - 1][X2] - sum[Y2][X1 - 1] + sum[Y1 - 1][X1 - 1] - map[i][j];
					if (map[i][j] == 1) {
						// 생명일 때
						if (cnt >= a && cnt <= b) {
							copy[i][j] = 1;
						} else if (cnt < a || cnt > b) {
							copy[i][j] = 0;
						}
					} else {
						// 생명이 아닐 때
						if (cnt > a && cnt <= b) {
							copy[i][j] = 1;
						}
					}
				}
			}
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < M + 1; j++) {
					map[i][j]=copy[i][j];
				}
			}
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (map[i][j] == 1)
					System.out.print("*");
				else
					System.out.print(".");
			}
			System.out.println();
		}
	}
}

package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2747_피보나치수 {
	static int N;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		System.out.println(fibo(N));
	}
	private static int fibo(int n) {
		if (n==0 || n==1) {
			return n;
		}
		return fibo(n-1)+fibo(n-2);
	}
}

//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//N=Integer.parseInt(br.readLine());
//int[] fibo=new int[N+1];
//fibo[1]=1;
//for (int i=2; i<N+1; i++) {
//	fibo[i]=fibo[i-1]+fibo[i-2];
//}
//System.out.println(fibo[N]);

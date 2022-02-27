package algo;

import java.io.*;
import java.util.*;

public class BOJ_20299_3¥Î√¯¡§ {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int result=0;
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			if(x1>=L && x2>=L && x3>=L && x1+x2+x3>=K) {
				result++;
				sb.append(x1+" "+x2+" "+x3+" ");
			}
			
		}
		System.out.println(result);
		System.out.println(sb);

	}
}

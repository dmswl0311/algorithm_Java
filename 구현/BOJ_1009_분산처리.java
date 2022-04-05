package algo;

import java.io.*;
import java.util.*;

public class BOJ_1009_분산처리 {
	
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int r=1;
			for (int i = 0; i < b; i++) r=(r*a)%10;
			if(r==0) r=10;
			System.out.println(r);
		}

	}
}

package algo;

import java.io.*;
import java.util.*;

public class BOJ_4299_AFCÀ«ºí´ø {
	
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		if(a<b || (a-b)%2!=0 || (a+b)%2!=0) {
			System.out.println(-1);
		}else {
			int answer=(a+b)/2;
			int answer2=a-answer;
			if(answer>=answer2) System.out.println(answer+" "+answer2);
			else System.out.println(answer2+" "+answer);
		}
	}
}

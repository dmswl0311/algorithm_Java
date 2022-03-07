package algo;

import java.io.*;
import java.util.*;

public class BOJ_9093_단어뒤집기 {
	
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String str=br.readLine();
			String[] sp=str.split(" ");
			for (int j = 0; j < sp.length; j++) {
				String cur=sp[j];
				for (int k = cur.length()-1; k >= 0; k--) {
					sb.append(cur.charAt(k));
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}

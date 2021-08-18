import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @see https://www.acmicpc.net/problem/1992
 * 분할정복, 재귀
 */
public class BOJ_1992_쿼드트리 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	static int[][] map;
	static int cnt_zero;
	static int cnt_one;
	static int cnt;
	static int N;
	static String str;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0; i<N; i++) {
			String str=br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		cnt=0;
		if(N==1) {
			System.out.println("1");
		}else {
			str="(";
			
			divide(0,0,N);
			
			str=str.concat(")");
			
			while(true) {
				if (str.contains("(0000)") || str.contains("(1111)")) {
					str=str.replace("(0000)", "0");
					str=str.replace("(1111)", "1");
				}else {
					break;
				}
			}
			
			System.out.println(str);
		}
		
	}

	private static void divide(int x, int y, int n) {
		if(n==2) {
			for(int i=x; i<x+2; i++) {
				for (int j=y; j<y+2; j++) {
					str=str.concat(String.valueOf(map[i][j]));
				}
			}
			return;
		}
		
		int len=n/2;
		
		str=str.concat("(");
		divide(x,y,len);
		str=str.concat(")");
		
		str=str.concat("(");
		divide(x,y+len,len);
		str=str.concat(")");
		
		str=str.concat("(");
		divide(x+len,y,len);
		str=str.concat(")");
		
		str=str.concat("(");
		divide(x+len,y+len,len);
		str=str.concat(")");
		
	}
}
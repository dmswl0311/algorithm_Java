import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see https://www.acmicpc.net/problem/1992
 * 분할정복, 재귀
 * 괄호 묶어주는 부분 **
 */

public class BOJ_1992_쿼드트리 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	static int[][] map;
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
		divide(0,0,N);
		System.out.println(sb);
	}

	private static void divide(int x, int y, int n) {
		cnt=0;
		
		// 어떤 수로 이루어져 있는지 알기 위해 cnt에 현재 값 저장
		for (int i=x; i<x+n; i++) {
			for (int j=y; j<y+n; j++) {
				cnt+=map[i][j];
			}
		}
		
		// 기저조건이 따로 없지만, if~else문이 기저조건
		if (cnt==n*n) {
			// 만약, cnt 값이 넓이와 같다면, 1로 채워져있음
			sb.append(1);
		}else if (cnt==0) {
			// cnt 값이 0과 같다면, 0으로 채워져있음
			sb.append(0);
		}
		else {
			// 1과 0이 섞여있다면, 괄호로 묶어주고 다시 4분할
			sb.append("(");
			int len=n/2;
			divide(x,y,len);
			divide(x,y+len,len);
			divide(x+len,y,len);
			divide(x+len,y+len,len);
			sb.append(")");
		}
	}
}
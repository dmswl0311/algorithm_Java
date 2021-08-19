import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * @see https://www.acmicpc.net/problem/2630
 * 분할 정복, 재귀
 */
public class BOJ_2630_색종이만들기 {
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int blue;
	static int white;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		blue=0;
		white=0;
		cut(0,0,N);

		System.out.println(white);
		System.out.println(blue);
	}
	
	private static void cut(int r,int c,int size) {
		int sum=0;

		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				// 어떤 색으로 채워져있는지 확인하기 위해 더하기
				sum+=map[i][j]; 
			}
		}
		// if, else if문이 기저조건
		if (sum==(size*size)) blue+=1;
		else if(sum==0) white+=1;
		else {
			// 4분할, 각각의 사각형 처리
			int len=size/2;
			cut(r,c,len);
			cut(r,c+len,len);
			cut(r+len,c,len);
			cut(r+len,c+len,len);
		}
	}
}

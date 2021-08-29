import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * @author CHO
 * @see https://www.acmicpc.net/problem/2567
 * 구현, 값이 달라지면 +1
 */

public class BOJ_2567_색종이2 {
	static StringTokenizer st;
	static int t=100;
	static int[][] dir= {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] map=new int[t+1][t+1];
		int result=0;
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			int C=Integer.parseInt(st.nextToken());
			int R=Integer.parseInt(st.nextToken());
			for (int r= R; r < R+10; r++) {
				for (int c = C; c < C+10; c++) {
					map[r][c]=1;
				}
			}
		}
		int before=0;
		for (int r= 1; r < t+1; r++) {
			for (int c = 1; c < t+1; c++) {
				if(map[r][c]!=before) result++;
				before=map[r][c];
			}
		}
		before=0;
		for (int c= 1; c < t+1; c++) {
			for (int r = 1; r < t+1; r++) {
				if(map[r][c]!=before) result++;
				before=map[r][c];
			}
		}
		System.out.println(result);
	}
}
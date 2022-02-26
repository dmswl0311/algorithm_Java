package algo;

import java.io.*;
import java.util.*;

/**
 * 21616	476
 * @author CHO
 * @see https://www.acmicpc.net/problem/20165
 * @category 구현
 */
public class BOJ_20165_인내의도미노장인호석 {
	
	static StringTokenizer st;
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}}; //동,서,남,북

	public static void main(String[] args) throws IOException {
		int result=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] ori=new int[N+1][M+1];
		boolean[][] vis=new boolean[N+1][M+1]; //넘어짐 표시, true면 넘어짐
		for (int n = 1; n < N+1; n++) {
			st=new StringTokenizer(br.readLine());
			for (int m = 1; m < M+1; m++) {
				ori[n][m]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) {
			st=new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			char D=st.nextToken().charAt(0); //공격수
			st=new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()); //수비수,입력 완료
			int d=-1; //방향
			if(D=='E') d=0;
			else if(D=='W') d=1;
			else if(D=='S') d=2;
			else if(D=='N') d=3;
			int r=ori[X][Y]; //몇번 넘어질지
			int nx=X;
			int ny=Y;
			while(r>0) {
				if(!vis[nx][ny]) {
					r=Math.max(r, ori[nx][ny]);
					r--;
					vis[nx][ny]=true;
					result++;
				}else {
					r--;
				}
				nx=nx+dir[d][0];
				ny=ny+dir[d][1];
				if(nx<=0 || ny<=0 || nx>N || ny>M) break;
			}
			if(vis[x][y]) vis[x][y]=false; //도미노 다시 세움
		}
		System.out.println(result);
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				System.out.print(vis[i][j]==true?"F":"S");
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}

}

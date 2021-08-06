import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 실버5 체스판 다시 칠하기
 * https://www.acmicpc.net/problem/1018
 * 
 * 사방탐색 + 2차원배열을 2차원배열로 탐색 이용
 * 체스판이 'W'로 시작하는것과 'B'로 시작하는것 나눔
 * 처음 map은 원래상태, 두번째 map2는 'W'로 시작했다면 'B'로, 'B'->'W'로 바꿈
 * 사방탐색 :: 'W'->'B'처럼 값을 바꿨다면 state배열 값을 1로 설정
 * 2차원배열 탐색 :: state배열을 통해 최소 sum 찾음
 * 
 */

public class BOJ_1018_체스판다시칠하기 {
	static int N,M;
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
		char[][] map=new char[N][M];
		char[][] map2=new char[N][M];
		int[][] state=new int[N][M];
		int[][] state2=new int[N][M];
		for (int i=0; i<N; i++) {
			String str=br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j]=str.charAt(j);
				map2[i][j]=map[i][j];
			}
		}

		map2[0][0]=map[0][0]=='W'?'B':'W';
		state2[0][0]=1;
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if(map[r][c]=='W') {
					for(int i=0; i<4; i++) {
						int nr=r+dir[i][0];
						int nc=c+dir[i][1];
						if (isOkay(nr, nc)&&map[nr][nc]!='B') {
							//B가 아니면 B로 칠해주고 
							map[nr][nc]='B';
							state[nr][nc]=1;
						}
					}
				}else {
					for(int i=0; i<4; i++) {
						int nr=r+dir[i][0];
						int nc=c+dir[i][1];
						if (isOkay(nr, nc)&&map[nr][nc]!='W') {
							//B가 아니면 B로 칠해주고 
							map[nr][nc]='W';
							state[nr][nc]=1;
						}
					}
				}
				if(map2[r][c]=='W') {
					for(int i=0; i<4; i++) {
						int nr=r+dir[i][0];
						int nc=c+dir[i][1];
						if (isOkay(nr, nc)&&map2[nr][nc]!='B') {
							//B가 아니면 B로 칠해주고 
							map2[nr][nc]='B';
							state2[nr][nc]=1;
						}
					}
				}else {
					for(int i=0; i<4; i++) {
						int nr=r+dir[i][0];
						int nc=c+dir[i][1];
						if (isOkay(nr, nc)&&map2[nr][nc]!='W') {
							//B가 아니면 B로 칠해주고 
							map2[nr][nc]='W';
							state2[nr][nc]=1;
						}
					}
				}
			}
		}
		int startY=0;
		int startX=0;
		int min=2601;
		int r=0;
		while(startY<(M-8)+1) {
			while(startX<(N-8)+1) {
				int sum=0;
				int sum2=0;
				for(int i=startX; i<startX+8; i++) {
					for(int j=startY; j<startY+8; j++) {
						sum+=state[i][j];
						sum2+=state2[i][j];
					}
				}
				startX++;
				r=sum>sum2?sum2:sum;
				if(min>r) {
					min=r;
				}
			}
			startX=0;
			startY++;
		}
		System.out.println(min);

	}
	private static boolean isOkay(int r,int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}

}

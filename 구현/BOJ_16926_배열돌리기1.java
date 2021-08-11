import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken()); //배열 크기
		int M=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken()); //몇번 회전
		int[][] map=new int[N][M];
		for(int n=0; n<N; n++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int m=0; m<M; m++) {
				map[n][m]=Integer.parseInt(st.nextToken());
			}
		}
		int[][] move=new int[N][M];
		int cntr=N-1;
		int cntc=M-1;
		int r=0;
		int c=0;
		int re=min(N,M)/2;
		for (int num=0; num<R; num++) {
			while(re>0) {
				for (int i=0; i<cntc; i++) {
					c++;
					move[r][c-1]=map[r][c];
				}
				for (int i=0; i<cntr; i++) {
					r++;
					move[r-1][c]=map[r][c];
				}
				for (int i=0; i<cntc; i++) {
					c--;
					move[r][c+1]=map[r][c];
				}
				for (int i=0; i<cntr; i++) {
					r--;
					move[r+1][c]=map[r][c];
				}
				cntc-=2;
				cntr-=2;
				r=r+1;
				c=c+1;
				re--;
			}
			//move를 map으로 만들기
			map=move.clone();
			//move 비우기
			move=new int[N][M];
			cntr=N-1;
			cntc=M-1;
			r=0;
			c=0;
			re=min(N,M)/2;
		}
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static int min(int n, int m) {
		return n>=m?m:n;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 팔방탐색 
 * @author CHO
 * @see https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWlTKTUqCN8DFAVS&categoryId=AWlTKTUqCN8DFAVS&categoryType=CODE
 */
public class SWEA_7236_저수지 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static int N;
	static int[][] dir= {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			N=Integer.parseInt(br.readLine());
			char[][] map=new char[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=st.nextToken().charAt(0);
				}
			}
			int max=0;
			for (int r = 0; r < N; r++) {
				for (int c= 0; c < N; c++) {
					int cnt=0;
					for (int i = 0; i < dir.length; i++) {
						int nr=r+dir[i][0];
						int nc=c+dir[i][1];
						if(isOkay(nr,nc)) {
							if(map[nr][nc]=='W') cnt++;
						}
						if (cnt==0) max=max>1?max:1;
						else max=max>cnt?max:cnt;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);

	}
	private static boolean isOkay(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}

}

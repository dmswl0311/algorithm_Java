import java.io.*;
import java.util.*;

/**
 * 11656	88
 * @author CHO
 * @see https://www.acmicpc.net/status?group_id=11777
 * @category 구현
 *
 */
public class BOJ_1051_숫자정사각형 {
	static StringTokenizer st;
	static int[][] dir= {{0,1},{1,0},{1,1}};
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map=new int[N][M];
		for (int i = 0; i < N; i++) {
			String str=br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}// 입력 완료
		int max=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int cnt=1;
				while(true) {
					int nx1=i+(dir[0][0]*cnt);
					int ny1=j+(dir[0][1]*cnt);
					int nx2=i+(dir[1][0]*cnt);
					int ny2=j+(dir[1][1]*cnt);
					int nx3=i+(dir[2][0]*cnt);
					int ny3=j+(dir[2][1]*cnt);
					if(is(nx1,ny1) && is(nx2,ny2) && is(nx3,ny3)) {
						if(map[i][j]==map[nx1][ny1] && map[nx1][ny1]==map[nx2][ny2] && map[nx2][ny2]==map[nx3][ny3] && map[nx3][ny3]==map[i][j]) {
							max=max<cnt?cnt:max;
						}
						cnt++;
					}else break;
				}
			}
		}
		System.out.println((int)Math.pow(max+1, 2));
	}
	private static boolean is(int nx, int ny) {
		return nx>=0 && ny>=0 && nx<N && ny<M;
	}
}

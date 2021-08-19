import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * @see https://www.acmicpc.net/problem/3109
 * 백트래킹, dfs
 * 
 * 조건 확인**
 * 1. 탐색 방향 위,옆,아래 순으로 
 * 2. 하나의 파이프가 만들어지면, 방문처리 
 * 3. 파이프가 만들어지지 않았다면, 안되는 경로 표시 (실패한 길 안가도록)
 */
public class BOJ_3109_빵집 {
	static int R,C;
	static char[][] map;
	static int cnt; // 총 경우의 수
	static StringTokenizer st;
	static int[][] dir= {{-1,1},{0,1},{1,1}}; // 오른쪽 대각선 위, 오른쪽, 오른쪽 대각선 아래
	static int[][] visited;
	static int flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		
		map=new char[R][C];
		visited=new int[R][C];
		cnt=0;
		
		for (int i = 0; i < R; i++) {
			String str=br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j]=str.charAt(j);
			}
		}

		for (int i=0; i<R; i++) {
			// 0행~R-1행까지 
			flag=0;
			setQueens(i,0);
		}
		System.out.println(cnt);
	}
	private static void setQueens(int r,int c) {
		if (c==C-1) {
			cnt++;
			// 완성했을 경우 flag=1
			flag=1;
			visited[r][c]=1;
			return;
		}
		
		for (int d=0; d<3; d++) {
			int dr=r+dir[d][0];
			int dc=c+dir[d][1];
			if(isOkay(dr,dc) && visited[dr][dc]==0 && map[dr][dc]=='.') {
				setQueens(dr, dc);
				if (flag==1) {
					// 하나 완성했을때, 방문했던 곳 표시, 다른곳 탐색할 필요x
					visited[r][c]=1; 
					return;
				}else {
					// 완성하지 못했을 경우, 안되는 경로 표시
					visited[r][c]=2;
				}
			}
		}
		
	}
	
	private static boolean isOkay(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}
}

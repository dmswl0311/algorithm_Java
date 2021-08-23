import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author CHO
 * @see https://www.acmicpc.net/problem/10026
 * DFS
 */
public class BOJ_10026_적록색약 {
	static StringTokenizer st;
	static boolean[][] visited;
	static char[][] map;
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		map=new char[N][N];
		for (int i = 0; i < N; i++) {
			String str=br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j]=str.charAt(j);
			}
		}
		visited=new boolean[N][N];
		int sum=0; // 적록색약 x
		for (int i=0; i<N; i++) {
			for (int j = 0; j <N; j++) {
				char value=map[i][j];
				if(dfs(i,j,value)) {
					sum++;
				}
			}
		}
		// R==G이기 때문에 R->G로 바꿔줌
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]=='R') map[i][j]='G';
			}
		}
		int redblue=0; // 적록색약
		visited=new boolean[N][N];
		for (int i=0; i<N; i++) {
			for (int j = 0; j <N; j++) {
				char value=map[i][j];
				if(dfs(i,j,value)) {
					redblue++;
				}
			}
		}

		System.out.println(sum+" "+redblue);

	}
	private static boolean dfs(int x, int y, char value) {
		if(!visited[x][y]) {
			visited[x][y]=true;
			for(int i=0; i<4; i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if(isOkay(nx,ny)&&map[nx][ny]==value&&!visited[nx][ny]) {
					dfs(nx,ny,value);
				}
			}
			return true;
		}else {
			return false;
		}
	}
	private static boolean isOkay(int x, int y) {
		return x>=0 && y>=0 && x<N && y<N;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @see https://www.acmicpc.net/problem/1987
 * 
 * DFS, 백트래킹, 조건**
 * 1.갈 수 있으면 cnt+1
 * 2.끝까지 갔다면, max값과 cnt값 비교
 * 3.되돌아가서 안가본 다른 곳으로 탐색하기 위해 cnt-1,마지막으로 갔던 visited->false
 */
public class BOJ_1987_알파벳 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static int R,C;
	static char[][] map;
	static boolean[] visited;
	static int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}}; //상하좌우
	static int max,cnt;
	static boolean[][] map_visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		map=new char[R][C];
		for (int i = 0; i < R; i++) {
			String str=br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j]=str.charAt(j);
			}
		}
		visited=new boolean [26]; 
		map_visited=new boolean[R][C];
		max=Integer.MIN_VALUE;
		// 무조건 한번은 방문하므로
		cnt=1;
		find(0,0);
		System.out.println(max);
	}
	private static void find(int x, int y) {

		visited[map[x][y]-65]=true;
		map_visited[x][y]=true;
//		System.out.println(map[x][y]+" 방문");
		
		for(int d=0; d<4; d++) {
			// 사방탐색
			int nx=x+dir[d][0];
			int ny=y+dir[d][1];
			if (isOkay(nx,ny)) {
				// 범위 벗어나지 않고, 방문하지 않았다면 
				if(visited[map[nx][ny]-65]==false && map_visited[nx][ny]==false) {
					cnt++;
					find(nx,ny);
				}
			}
		}
		// 갈 수 있는 곳 모두 탐색
		max=max<cnt?cnt:max;
		// 되돌아 가기 위해 cnt-1, 방문한 곳들 false로
		cnt--;
		visited[map[x][y]-65]=false;
		map_visited[x][y]=false;
	}
	private static boolean isOkay(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}

}

package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23747_와드 {
	static StringTokenizer st;
	static int R, C;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // R,L,U,D
	static char[][] map, result;
	static boolean[][] vis;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R + 1][C + 1];
		result = new char[R + 1][C + 1];
		for (int r = 1; r <= R; r++) {
			Arrays.fill(result[r], '#');
		}
		for (int r = 1; r <= R; r++) {
			String input = br.readLine();
			for (int c = 1; c <= C; c++) {
				map[r][c] = input.charAt(c - 1);
			}
		}
		st = new StringTokenizer(br.readLine());
		int HR = Integer.parseInt(st.nextToken());
		int HC = Integer.parseInt(st.nextToken());
		String input = br.readLine(); // 여행기록
		vis=new boolean[R+1][C+1];
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			int d = -1; // 방향
			if (cur == 'U')
				d = 3;
			else if (cur == 'D')
				d = 2;
			else if (cur == 'L')
				d = 1;
			else if (cur == 'R')
				d = 0;
			if (cur != 'W') {
				int nr = HR + dir[d][0];
				int nc = HC + dir[d][1];
				HR=nr;
				HC=nc;
				if(i==input.length()-1) {
					result[HR][HC]='.';
					for (int j = 0; j < dir.length; j++) {
						nr = HR + dir[j][0];
						nc = HC + dir[j][1];
						if(nr>0 && nc>0 && nr<=R && nc<=C) {
							result[nr][nc]='.';
						}
					}
				}
			}else {
				ward(HR,HC);
			}
		}
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				sb.append(result[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void ward(int x, int y) {
		Queue<int[]> q=new LinkedList<int[]>();
		q.add(new int[] {x,y});
		vis[x][y]=true;
		result[x][y]='.';
		while(!q.isEmpty()) {
			int cur[]=q.poll();
			x=cur[0];
			y=cur[1];
			for (int j = 0; j < dir.length; j++) {
				int nx = x + dir[j][0];
				int ny = y + dir[j][1];
				if(nx>0 && ny>0 && nx<=R && ny<=C && map[x][y]==map[nx][ny] && !vis[nx][ny]) {
					result[nx][ny]='.';
					vis[nx][ny]=true;
					q.add(new int[] {nx,ny});
					
				}
			}
		}
	}

}
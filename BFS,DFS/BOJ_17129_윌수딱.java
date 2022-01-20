import java.io.*;
import java.util.*;

/**
 * 338648	1328
 * @author CHO
 * @see https://www.acmicpc.net/problem/17129
 * @category BFS
 */
public class BOJ_17129_윌수딱 {
	static class Pos{
		int x;
		int y;
		public Pos(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static StringTokenizer st;
	static int N,M;
	static int[][] map;
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map=new int[N][M];
		int sX=0,sY=0; //시작 위치
		for (int i = 0; i < N; i++) {
			String str=br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=str.charAt(j)-'0';
				if(map[i][j]==2) {
					sX=i;
					sY=j;
				}
			}
		}//입력 완료
		
		int result=bfs(sX,sY);
		if(result>=0) {
			System.out.println("TAK"+"\n"+result);
		}else {
			System.out.println("NIE");
		}

	}
	public static int bfs(int x,int y) {
		int dis=0;
		Queue<Pos> q=new LinkedList<>();
		q.add(new Pos(x, y));
		boolean[][] vis=new boolean[N][M];
		vis[x][y]=true;
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
				Pos cur=q.poll();
				int cx=cur.x;
				int cy=cur.y;
				if(map[cx][cy]>2) {
					return dis;
				}
				for (int i = 0; i < dir.length; i++) {
					int nx=cx+dir[i][0];
					int ny=cy+dir[i][1];
					if(Ok(nx, ny) && !vis[nx][ny] && map[nx][ny]!=1) {
						vis[nx][ny]=true;
						q.add(new Pos(nx, ny));
					}
				}
			}
			dis++;
		}
		return -1;
	}
	public static boolean Ok(int x,int y) {
		return x>=0 && y>=0 && x<N && y<M;
	}

}

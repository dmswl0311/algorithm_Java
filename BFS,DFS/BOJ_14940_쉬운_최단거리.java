package algo;

import java.io.*;
import java.util.*;

public class BOJ_14940_쉬운_최단거리 {
	static class Pos{
		int x;
		int y;
		public Pos(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	static StringTokenizer st;
	static int x,y;
	static int [][] map,result;
	static int [][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		map=new int[x][y];
		result=new int[x][y];
		int targetX=0,targetY=0;
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					targetX=i;
					targetY=j;
				}
			}
		}
		vis=new boolean[x][y];
		bfs(targetX,targetY);
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if(map[i][j]==1 && !vis[i][j]) result[i][j]=-1;
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void bfs(int i, int j) {
		Queue<Pos> q=new LinkedList<>();
		q.add(new Pos(i, j));
		vis[i][j]=true;
		while(!q.isEmpty()) {
			Pos cur=q.poll();
			for (int k = 0; k < dir.length; k++) {
				int nx=cur.x+dir[k][0];
				int ny=cur.y+dir[k][1];
				if(nx>=0 && ny>=0 && nx<x && ny<y && map[nx][ny]!=0 && !vis[nx][ny]) {
					result[nx][ny]=result[cur.x][cur.y]+1;
					vis[nx][ny]=true;
					q.add(new Pos(nx, ny));
				}
			}
		}
		
	}

}

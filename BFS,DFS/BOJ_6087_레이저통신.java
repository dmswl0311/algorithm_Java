import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 13880	108
 * @author CHO
 * @see https://www.acmicpc.net/problem/6087
 * @category BFS
 * if문 조건 잘보기, 우선순위 큐 사용, visited 배열에 거울의 최솟값 저장
 */
public class BOJ_6087_레이저통신 {
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int mirror;
		int d;
		public Point(int x, int y, int mirror, int d) {
			super();
			this.x = x;
			this.y = y;
			this.mirror = mirror;
			this.d = d;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.mirror-o.mirror;
		}
		
		
	}
	static StringTokenizer st;
	static int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
	static int W,H;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		char[][] map=new char[W][H];
		ArrayList<int[]> index=new ArrayList<>(); //C의 위치
		for (int i = 0; i < W; i++) {
			String str=br.readLine();
			for (int j = 0; j < H; j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='C') index.add(new int[] {i,j}); //C의 위치 저장
			}
		}// 입력 완료
		// 빈칸:. 벽:* 
		int startX=index.get(0)[0];
		int startY=index.get(0)[1];
		int endX=index.get(1)[0];
		int endY=index.get(1)[1];
		
		//BFS
		
		int[][] visited=new int[W][H];
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				visited[i][j]=Integer.MAX_VALUE;
			}
		}
		PriorityQueue<Point> q=new PriorityQueue<>();
		visited[startX][startY]=0;
		q.add(new Point(startX,startY,0,-1)); //x,y,거울개수,진행방향

		while(!q.isEmpty()) {
			Point curr=q.poll();
			int x=curr.x;
			int y=curr.y;
			int mirror=curr.mirror;
			int d=curr.d;
			if(x==endX && y==endY) break;
			for (int i = 0; i < 4; i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if(isOkay(nx,ny) && map[nx][ny]!='*') { // 원래의 진행방향을 알아야 함 
					int temp=mirror;
					if(d==-1 || d==i) { //거울 안씀
						if(visited[nx][ny]>=temp) {
							visited[nx][ny]=temp;
							q.add(new Point(nx,ny,temp,i));
						}
					}else {
						temp+=1;
						if(visited[nx][ny]>=temp) {
							visited[nx][ny]=temp;
							q.add(new Point(nx,ny,temp,i));
						}
					}
				}
			}
		}
		System.out.println(visited[endX][endY]);
	}

	private static boolean isOkay(int nx, int ny) {
		return nx>=0 && ny>=0 && nx<W && ny<H;
	}
}

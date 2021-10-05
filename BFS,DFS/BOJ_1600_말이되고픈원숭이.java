import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 79656	540
 * @author CHO
 * @see https://www.acmicpc.net/problem/1600
 * @category BFS
 * visited 3차원 배열 (기존 visited+말 이동 횟수를 관리하는 배열 추가)
 * 
 */
public class BOJ_1600_말이되고픈원숭이 {
	static class XY{
		int x;
		int y;
		int cnt; //주의! 말 이동 횟수
		
		public XY(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt= cnt;
		}

	}
	static StringTokenizer st;
	static int K,W,H;
	static int[][] map;
	static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
	static int[][] dir_horse= {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		map=new int[H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}// 입력완료
		
		
		int result=bfs();
		System.out.println(result);

	}
	private static int bfs() {
		int depth=0;
		// 주의! 말 이동횟수를 추가한 3차원 배열
		boolean[][][] visited=new boolean[H][W][K+1];
		Queue<XY> q=new LinkedList<>();
		q.add(new XY(0, 0, 0));
		visited[0][0][0]=true;
		
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
				XY curr=q.poll();
				int x=curr.x;
				int y=curr.y;
				// 말 이동 횟수
				int c=curr.cnt;
				if(x==H-1 && y==W-1) return depth;
				
				// 원숭이처럼 움직이기
				for (int k = 0; k < 4; k++) {
					int nx=x+dir[k][0];
					int ny=y+dir[k][1];
					if(isIn(nx,ny)&&!visited[nx][ny][c]&&map[nx][ny]==0) {
						visited[nx][ny][c]=true;
						q.add(new XY(nx, ny, c));
					}
				}
				// 주의! 말처럼 움직이기 
				if(c<K) {
					for (int k = 0; k < 8; k++) {
						int nx=x+dir_horse[k][0];
						int ny=y+dir_horse[k][1];
						if(isIn(nx,ny)&&!visited[nx][ny][c+1]&&map[nx][ny]==0) {
							visited[nx][ny][c+1]=true;
							q.add(new XY(nx, ny, c+1));
						}
					}
				}
			}
			depth++;
		}
		return -1;
	}
	private static boolean isIn(int nx, int ny) {
		// TODO Auto-generated method stub
		return nx>=0 && ny>=0 && nx<H && ny<W;
	}

}

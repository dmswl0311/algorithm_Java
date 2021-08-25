import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author CHO
 * @see https://www.acmicpc.net/problem/16236
 * BFS, 구현
 * 먹을 수 있는 물고기 좌표 저장, 나중에 정렬하기
 * 
 */
public class BOJ_16236_아기상어 {
	static StringTokenizer st;
	static int[][] dir= {{-1,0},{0,-1},{0,1},{1,0}};
	static int N;
	static int[][] map;
	static int sharkSize,eat;
	static int time;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map=new int[N][N];
		int startX=0;
		int startY=0;
		sharkSize=2;
		eat=0;
		time=0;
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					startX=i;
					startY=j;
					map[i][j]=0;
				}
			}
		}
		bfs(startX,startY);
		System.out.println(time);
	}

	private static void bfs(int x, int y) {
		int depth=0;
		boolean find=false;
		ArrayList<int[]> fishes=new ArrayList<>();
		Queue<int[]> queue=new LinkedList<>();
		boolean visited[][]=new boolean[N][N];
		queue.add(new int[] {x,y});
		visited[x][y]=true;
		while(!queue.isEmpty()) {
			int size=queue.size();
			while(size-->0) {
				int[] list=queue.poll();
				x=list[0];
				y=list[1];
				for (int i = 0; i < 4; i++) {
					int nx=x+dir[i][0];
					int ny=y+dir[i][1];
					if (isOkay(nx, ny)&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						if(map[nx][ny]==0 || map[nx][ny]==sharkSize) {
							queue.add(new int[] {nx,ny});
						}else if (map[nx][ny]<sharkSize) {
							// 먹을 수 있는 물고기의 좌표 저장
							fishes.add(new int[] {nx,ny});
							find=true;
						}
					}
				}
			}
			if(find) break;
			depth++;
		}
		if (fishes.size()>0) {
			CheckEat(fishes,depth+1);
		}else return;
	}

	private static void CheckEat(ArrayList<int[]> fishes,int depth) {
		Collections.sort(fishes,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0]==o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});
		int nx=fishes.get(0)[0];
		int ny=fishes.get(0)[1];
		map[nx][ny]=0;
		time+=depth;
		eat++;
		if (eat==sharkSize) {
			sharkSize++;
			eat=0;
		}
		bfs(nx, ny);
	}

	private static boolean isOkay(int x, int y) {
		return x>=0 && y>=0 && x<N && y<N;
		
	}
	
}

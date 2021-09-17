import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 	171900	448
 * @author CHO
 * @see https://www.acmicpc.net/problem/14502
 * @category 조합, BFS
 * 조합으로 설치할 수 있는 모든 벽의 개수 설치해봄, 범위 주의!
 */
public class BOJ_14502_연구소 {
	static StringTokenizer st;
	static int N,M;
	static int[][] map;
	static int dir[][]= {{0,1},{0,-1},{1,0},{-1,0}};
	static int[][] copy;
	static int R=3;
	static int pick[];
	static int safe;
	static ArrayList<int[]> virus,hubo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map=new int[N+1][M+1];
		copy=new int[N+1][M+1];
		virus=new ArrayList<>();
		hubo=new ArrayList<>();
		
		for (int i = 1; i < N+1; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 1; j < M+1; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if (map[i][j]==2) {
					virus.add(new int[] {i,j});
				}else if(map[i][j]==0) {
					// 벽 세울 수 있는 후보 
					hubo.add(new int[] {i,j});
				}
				copy[i][j]=map[i][j];
			}
		}
		safe=0;
		pick=new int[R];
		combination(hubo,0,0);
		
		System.out.println(safe);

	}
	
	private static void combination(ArrayList<int[]> hubo, int cnt, int start) {
		if(cnt==R) {
			// 벽 다 세움
			for (int i = 0; i < R; i++) {
				copy[hubo.get(pick[i])[0]][hubo.get(pick[i])[1]]=1;
			}
			// 바이러스 퍼져나감
			v();
			safe=safe<cal()?cal():safe;
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < M+1; j++) {
					copy[i][j]=map[i][j];
				}
			}
			return;
		}
		for (int i = start; i < hubo.size(); i++) {
			pick[cnt]=i;
			combination(hubo, cnt+1, i+1);
		}
		
	}

	// 바이러스 퍼뜨림
	private static void v() {
		for (int i = 0; i < virus.size(); i++) {
			int x=virus.get(i)[0];
			int y=virus.get(i)[1];
			bfs(x,y);
		}
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q=new LinkedList<int[]>();
		boolean visited[][]=new boolean[N+1][M+1];
		
		q.add(new int[] {x,y});
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			int[] list=q.poll();
			int r=list[0];
			int c=list[1];
			for (int i = 0; i < 4; i++) {
				int nr=r+dir[i][0];
				int nc=c+dir[i][1];
				if(isOkay(nr,nc) && !visited[nr][nc] &&copy[nr][nc]==0) {
					copy[nr][nc]=2;
					q.add(new int[] {nr,nc});
					visited[nr][nc]=true;
					
				}
			}
		}
	}
	// 안전영역 크기 구하기
	private static int cal() {
		int count=0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				if(copy[i][j]==0) count++;
			}
		}
		return count;
	}

	private static boolean isOkay(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr>=1 && nc>=1 && nr<N+1 && nc<M+1;
	}

}

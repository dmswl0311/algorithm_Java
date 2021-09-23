import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 13MB	228ms
 * @author CHO
 * @see http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=954&sca=30
 * @category DFS, 백트래킹
 */
public class Jungol_1681_해밀턴순환회로 {
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static boolean visited[];
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		min=Integer.MAX_VALUE;
		
		// start는 1부터 
		visited=new boolean[N+1];
		dfs(1,0,0);
		
		if (min==Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);

	}
	private static void dfs(int r,int cnt,int c) {
		if (c==N-1) {
			// 마지막으로 방문한곳 -> 1 이 연결되어 있을 때 
			if(map[r][1]!=0) {
				cnt+=map[r][1];
				min=min>cnt?cnt:min;
				cnt-=map[r][1];
			}
			return;
		}
		if (r!=1) visited[r]=true;
		for (int i = 2; i < N+1; i++) {
			if(map[r][i]!=0 && !visited[i]) {
				if(cnt+map[r][i]>=min) continue;
				dfs(i,cnt+map[r][i],c+1);
				visited[i]=false;
			}
		}
	}

}

import java.io.*;
import java.util.*;

public class BOJ_2583_영역구하기 {
	
	static StringTokenizer st;
	static int N,M;
	static int[][] map;
	static int count;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map=new int[M][N];
		for (int k = 0; k < K; k++) {
			st=new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken()); //왼쪽 아래
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken()); //오른쪽 위
			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					map[i][j]=1;
				}
			}
		}
		List<Integer> list=new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0) {
					count=0;
					dfs(i,j);
					list.add(count);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}

	private static void dfs(int i, int j) {
		map[i][j]=1;
		count++;
		for (int k = 0; k < dir.length; k++) {
			int nx=i+dir[k][0];
			int ny=j+dir[k][1];
			if(is(nx,ny) && map[nx][ny]==0) {
				dfs(nx,ny);
			}
		}
		
	}

	private static boolean is(int nx, int ny) {
		return nx>=0 && ny>=0 && nx<M && ny<N;
	}
}

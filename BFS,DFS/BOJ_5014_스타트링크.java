import java.io.*;
import java.util.*;

/**
 * 59828	156
 * @author CHO
 * @see https://www.acmicpc.net/problem/5014
 * @category BFS
 */
public class BOJ_5014_스타트링크 {
	 
	static StringTokenizer st;
	static int F,S,G,U,D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken()); //전체 층수
		S = Integer.parseInt(st.nextToken()); //현재 위치
		G = Integer.parseInt(st.nextToken()); //목적 위치
		U = Integer.parseInt(st.nextToken()); //위로 U층 가는 버튼
		D = Integer.parseInt(st.nextToken()); //아래로 D층 가는 버튼
		
		bfs(S);
	}

	private static void bfs(int g) {
		Queue<int[]> q=new LinkedList<int[]>();
		q.add(new int[] {g,0});
		boolean[] vis=new boolean[F+1];
		vis[g]=true;
		
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			int floor=cur[0]; //현재 위치
			int cnt=cur[1]; //몇번 움직였는지
			if(floor==G) {
				System.out.println(cnt);
				return;
			}
			if(floor+U<=F && !vis[floor+U]) {
				vis[floor+U]=true;
				q.add(new int[] {floor+U,cnt+1});
			}
			if(floor-D>=1 && !vis[floor-D]) {
				vis[floor-D]=true;
				q.add(new int[] {floor-D,cnt+1});
			}
		}
		System.out.println("use the stairs");
	}
}

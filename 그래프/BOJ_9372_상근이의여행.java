import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 연결그래프일때 한 정점에서 모든 정점으로 가는 최소 정점 개수는 N-1
 * @author CHO
 * @see https://www.acmicpc.net/problem/9372
 */
public class BOJ_9372_상근이의여행 {
	static int N,M;
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			list=new ArrayList<>();
			for (int i = 0; i < N+1; i++) {
				list.add(i,new ArrayList<Integer>());
			}
			for (int i = 0; i < M; i++) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
			}
			sb.append(N-1).append("\n");
		}
		System.out.println(sb);
	}
}

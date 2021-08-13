import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * @see https://www.acmicpc.net/problem/15686
 * 조합 이용, 구현?
 */
public class BOJ_15686_치킨배달 {
	static StringTokenizer st;
	static int N;
	static ArrayList<int[]> chicken;
	static int [] pick;
	static int[][] map;
	static int distance;
	static int result;
	static int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		chicken=new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					// 치킨집이면, 치킨집 좌표 저장
					chicken.add(new int[] {i,j});
				}
			}
		}
		result=Integer.MAX_VALUE;
		distance=0;
		for (int R=1; R<=M; R++) {
			pick=new int[R];
			combination(0, 0, R);
		}
		System.out.println(result);
		
	}
	private static void combination(int cnt,int start, int R) {
		if (cnt==R) {
			find(pick);
			result=result>distance?distance:result;
			distance=0;
			return;
		}
		for(int i=start; i<chicken.size(); i++) {
			pick[cnt]=i;
			combination(cnt+1, i+1, R);
		}
	}
	private static void find(int[] pick) {
		int min=Integer.MAX_VALUE;
		int d=0;
		// 최소거리 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					for (int index:pick) {
						int x=chicken.get(index)[0];
						int y=chicken.get(index)[1];
						d=Math.abs(i-x)+Math.abs(j-y);
						min=min>d?d:min;
					}
					distance+=min;
					min=Integer.MAX_VALUE;
				}
			}
		}
	}

}

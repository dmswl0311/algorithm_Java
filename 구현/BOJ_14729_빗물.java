import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 12360	92
 * @author CHO
 * @see https://www.acmicpc.net/problem/14719
 * @category 구현
 * 주의! 1과 1사이의 0갯수 구하기
 * cnt값 초기화 
 *
 */
public class BOJ_14729_빗물 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C=  Integer.parseInt(st.nextToken());
		int[][] map=new int[R+2][C+2];
		
		st=new StringTokenizer(br.readLine());
		for (int c = 1; c < C+1; c++) {
			int num = Integer.parseInt(st.nextToken()); //채워야 할 칸수
			for (int r = R; r >R-num; r--) {
				// 밑에서부터 채워야 하므로, 채워야 할 칸수만큼 1 채워줌
				map[r][c]=1;
			}
		}
		// 입력 완료

		int result=0;
		int cnt=0;
		for (int r = R; r > 0; r--) {
			boolean flag=false;
			for (int c = 1; c < C+1; c++) {
				if(flag&&map[r][c]==0) cnt++;
				if(map[r][c]!=map[r][c+1]) {
					//1로 시작하거나, 끝난다는 말임
					if (map[r][c]==0 && map[r][c+1]==1) {
						// 1로 끝남 --> 1과 1 사이의 cnt값 저장
						result+=cnt;
						cnt=0;
						flag=false;
					}
					else {
						// 1로 시작한다 --> flag==true
						flag=true;
					}
				}
			}
			cnt=0;
		}
		System.out.println(result);

	}

}

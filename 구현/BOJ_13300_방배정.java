import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author CHO
 * @see https://www.acmicpc.net/problem/13300
 * K로 나누어 떨어지지 않을 경우, +1
 */
public class BOJ_13300_방배정 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[][] input=new int[7][2]; //학년,성별
		int result=0;
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			int gender=Integer.parseInt(st.nextToken());
			int grade=Integer.parseInt(st.nextToken());
			input[grade][gender]+=1;
		}
		
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				if (input[i][j]==0) continue;
				else if(input[i][j]<=K) result+=1;
				else {
					result+=input[i][j]/K;
					if(input[i][j]%K!=0) {
						result+=1;
					}
				}
			}
		}
		System.out.println(result);
	}

}

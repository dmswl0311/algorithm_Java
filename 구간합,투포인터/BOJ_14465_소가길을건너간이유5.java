import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 13756	124
 * @author CHO
 * @see https://www.acmicpc.net/problem/14465
 * @category 슬라이딩 윈도우
 */

public class Main {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K= Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] zero=new int[N+1];
		for (int i = 0; i < B; i++) {
			zero[Integer.parseInt(br.readLine())]+=1;
		}
		
		int min=0; // 답
		// 처음 슬라이딩 윈도우 설치
		for (int i = 1; i <=K; i++) {
			if(zero[i]==1) min+=1;
		}
		
		int cal=min;
		for (int start = 2; start <= N-K+1; start++) {
			int end=start+K-1;
			if(zero[start-1]==1) cal-=1;
			if(zero[end]==1) cal+=1;
			min=min>cal?cal:min;
		}
		
		System.out.println(min);

	}

}

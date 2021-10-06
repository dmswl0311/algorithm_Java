import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 168724	524
 * @author CHO
 * @see https://www.acmicpc.net/problem/15961
 * @category 슬라이딩 윈도우
 */
public class BOJ_15961_회전초밥 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] list=new int[N+k-1];
		for (int i = 0; i < N; i++) {
			list[i]=Integer.parseInt(br.readLine());
		}// 입력완료
		
		for (int i = 0; i < k-1; i++) {
			list[N++]=list[i];
		}

		int[] eaten=new int[d+1];
		int max=1; // 쿠폰 먹었다고 치자
		eaten[c]+=1;
		
		// 처음 
		int start=0;
		for (int i = start; i < k; i++) {
			if(eaten[list[i]]==0) {
				max++;
			}
			eaten[list[i]]+=1;
		}
		
		// 윈도우 이동
		start=0;
		int end=k;
		
		int result=max;
		for (int i = end; i < list.length; i++) {
			eaten[list[start]]-=1;
			if(eaten[list[start]]==0) {
				result-=1;
			} // 전처리
			// 추가된거 처리
			if(eaten[list[i]]==0) result+=1;
			eaten[list[i]]+=1;
			max=Math.max(max, result);
			start++;
		}
		
		System.out.println(max);
	}
}
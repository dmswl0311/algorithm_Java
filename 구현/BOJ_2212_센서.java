package algo;

import java.io.*;
import java.util.*;

public class BOJ_2212_센서 {
	
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}// 입력 완료
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		int[] dis=new int[N];
		for (int i = 0; i < N-1; i++) {
			dis[i]=arr[i+1]-arr[i];
		}
		Arrays.sort(dis);
//		System.out.println(Arrays.toString(dis));
		if(N<=K) {
			// 집중국의 개수가 센서의 개수보다 같거나 많을 경우
			System.out.println(0);
		}else {
			int result=0;
			for (int i = 0; i <= N-K; i++) {
				result+=dis[i];
			}
			System.out.println(result);
		}
		

	}
}

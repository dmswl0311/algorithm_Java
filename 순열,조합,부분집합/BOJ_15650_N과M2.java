package collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 조합 nCr
 * combination(cnt+1,i+1); => i+1 주의!
 */

public class BOJ_15650_N과M2 {
	static StringTokenizer st;
	static boolean[] isVistied;
	static int[] nums;
	static int N,R;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		isVistied=new boolean[N+1];
		nums=new int[R];
		combination(0,1);
	}
	private static void combination(int cnt,int start) {
		if (cnt==R) {
			for(int i=0;i<R;i++) {
				System.out.printf(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i=start; i<N+1; i++) {
			if(isVistied[i]) {
				continue;
			}
			nums[cnt]=i;
			isVistied[i]=true;
			combination(cnt+1,i+1);
			isVistied[i]=false;
		}
		
	}

}

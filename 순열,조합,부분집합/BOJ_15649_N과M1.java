package collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 순열 nPr
 */

public class BOJ_15649_N과M1 {
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
		permutation(0);

	}
	private static void permutation(int cnt) {
		if (cnt==R) {
			for(int i=0;i<R;i++) {
				System.out.printf(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i=1; i<N+1; i++) {
			if(isVistied[i]) {
				continue;
			}
			isVistied[i]=true;
			nums[cnt]=i;
			permutation(cnt+1);
			isVistied[i]=false;
		}
		
	}
	

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author CHO
 * @see https://www.acmicpc.net/problem/1074
 * 분할정복, 재귀
 */

public class BOJ_1074_Z {
	static StringTokenizer st;
	static int N,r,c;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		cnt=0;
		cal(0,0,(int)Math.pow(2, N));
		System.out.println(cnt);
	}
	private static void cal(int x,int y,int n) {
		
		if (n==1) {
			return;
		}
		
		int len=n/2;
		
		// 4사분면으로 나눠서, 해당 범위에 r과 c가 존재하면 넓이만큼 cnt++
		if(x<=r && r<x+len && y<=c &&c<y+len) {
			 cal(x,y,len);
		}else if(x<=r && r<x+len && y+len<=c && c<y+len*2) {
			 cnt+=len*len;
			 cal(x,y+len,len);
		}else if(x+len<=r && r<x+len*2 && y<=c && c<y+len) {
			 cnt+=len*len*2;
			 cal(x+len,y,len);
		}else if(x+len<=r && r<x+len*2 && y+len<=c && c<y+len*2) {
			 cnt+=len*len*3;
			 cal(x+len,y+len,len);
		}
	}
}

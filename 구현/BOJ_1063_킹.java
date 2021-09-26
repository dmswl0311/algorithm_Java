import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 	11496	80
 * @author CHO
 * @see https://www.acmicpc.net/problem/1063
 * @ 구현
 */
public class BOJ_1063_킹 {
	static StringTokenizer st;
	static int N;
	static int dir[][]= {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		String king=st.nextToken();
		String stone=st.nextToken();
		N=Integer.parseInt(st.nextToken());
		
		int kingC=king.charAt(0)-65+1;
		int kingR=8-(king.charAt(1)-'0')+1;
		
		int stoneC=stone.charAt(0)-65+1;
		int stoneR=8-(stone.charAt(1)-'0')+1;
		
		for (int i = 0; i < N; i++) {
			int d=-1;
			String input=br.readLine();
			if(input.equals("R")) d=0;
			else if(input.equals("L")) d=1;
			else if(input.equals("B")) d=2;
			else if(input.equals("T")) d=3;
			else if(input.equals("RT")) d=4;
			else if(input.equals("LT")) d=5;
			else if(input.equals("RB")) d=6;
			else if(input.equals("LB")) d=7;
			
			//king 움직임
			int nr=kingR+dir[d][0];
			int nc=kingC+dir[d][1];
			if(isOkay(nr,nc)) {
				if(nr==stoneR && nc==stoneC) {
					int snr=stoneR+dir[d][0];
					int snc=stoneC+dir[d][1];
					if(isOkay(snr,snc)) {
						kingR=nr;
						kingC=nc;
						stoneR=snr;
						stoneC=snc;
					}
				}else {
					kingR=nr;
					kingC=nc;
				}
			}else continue;
		}
		
		char resultKingR=(char)(kingC+65-1);
		char resultStoneR=(char)(stoneC+65-1);
		int resultKingC=8-kingR+1;
		int resultStoneC=8-stoneR+1;

		System.out.println(resultKingR+""+resultKingC);
		System.out.println(resultStoneR+""+resultStoneC);
		
		
	}
	private static boolean isOkay(int nr, int nc) {
		return nr>0 && nc>0 && nr<=8 && nc<=8;
	}

}

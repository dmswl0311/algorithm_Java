import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol_1037_오류교정 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int [][] map=new int[N+1][N+1];
		int[] c=new int[N+1]; // 0은 O, 1은 X
		int[] r=new int[N+1];
		int resultR=0,resultC=0;
		
		// 입력받고, 행 검사
		for (int i = 1; i < N+1; i++) {
			int cntC=0;
			st=new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				int num=Integer.parseInt(st.nextToken());
				map[i][j]=num;
				if(map[i][j]==1) cntC++;
			}
			if (cntC%2!=0) {
				r[i]=1;
				resultR=i;
			}
		}
		// 열 검사
		for (int j = 1; j < N+1; j++) {
			int cntR=0;
			for (int i = 1; i < N+1; i++) {
				if(map[i][j]==1) cntR++;
			}
			if (cntR%2!=0) {
				c[j]=1;
				resultC=j;
			}
		}
		
		int cntC=0,cntR=0;
		
		for (int i = 1; i < N+1; i++) {
			cntC+=c[i];
			cntR+=r[i];
		}
		if (cntC==0 && cntR==0) {
			System.out.println("OK");
		}else {
			if(cntC>1 || cntR>1) {
				System.out.println("Corrupt");
			}else {
				System.out.println("Change bit ("+resultR+","+resultC+")");
			}
		}

	}

}

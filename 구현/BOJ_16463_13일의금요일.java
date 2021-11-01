import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 11836	96
 * @author CHO
 * @see https://www.acmicpc.net/problem/16463
 * @category 날짜 계산
 */
public class BOJ_16463_13일의금요일 {
	static int[] month= {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		int day=1;
		int result=0;
		
		for (int y = 2019; y < year+1; y++) {
			for (int m = 1; m <= 12; m++) {
                if((day+12)%7==4) result++;
				if(m==2) {
					if(y%400==0) day+=29;
					else if(y%400!=0 && y%100==0) day+=28;
					else if(y%100!=0 && y%4==0) day+=29;
					else day+=28;
				}else day+=month[m];
			}
		}

		System.out.println(result);
		
	}

}
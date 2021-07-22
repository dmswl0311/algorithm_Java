import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10808 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String s=scan.next();
		int[] result=new int[26];
		// String을 Char배열로 변환
		char[] ns=s.toCharArray();
		for (char x:ns ) {
			result[((int)x)-97]+=1;
		}
		for (int x:result) {
			System.out.printf("%d ",x);
		}
	}

}

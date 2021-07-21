import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11656 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String str=scan.next();
		char[] c=str.toCharArray();
		String[] r=new String[str.length()];
		for (int i=0; i<str.length(); i++) {
			String result="";
			for (int j=i; j<str.length(); j++) {
				result+=Character.toString(c[j]);
			}
			r[i]=result;
		}
		Arrays.sort(r);
		for (String x:r) {
			System.out.println(x);
		}
	}

}

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1431 {
	private static Scanner scan=new Scanner(System.in);
	private static int N;
	private static StringBuilder builder=new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=scan.nextInt();
		String[] list=new String[N];
		for (int n=0; n<N; n++) {
			list[n]=scan.next();
		}
		
		Arrays.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()!=o2.length()) {
					return Integer.compare(o1.length(), o2.length());
				}else{
					int sum1=0;
					int sum2=0;
					for (int i=0; i<o1.length();i++) {
						if (0<=o1.charAt(i)-'0' && o1.charAt(i)-'0'<10) {
							// 숫자이면
							sum1+=o1.charAt(i)-'0';
						}
						if (0<=o2.charAt(i)-'0' && o2.charAt(i)-'0'<10) {
							sum2+=o2.charAt(i)-'0';
						}
					}
					if (sum1!=sum2) {
						return Integer.compare(sum1, sum2);
					}else {
						return o1.compareTo(o2);
					}
				}
			}
		});
		
		for (String i:list) {
			builder.append(i).append("\n");
		}
		System.out.println(builder);
	}

}

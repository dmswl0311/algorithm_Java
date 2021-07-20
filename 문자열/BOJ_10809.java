import java.util.Scanner;

public class BOJ_10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		char[] alphabet= {'a','b','c','d','e','f','g','h','i',
							'j','k','l','m','n','o','p','q','r',
							's','t','u','v','w','x','y','z'};
		int[] result=new int[26];
		String str=scan.next();
		// string을 char 배열로
		char[] str2=str.toCharArray();
		// result 값을 -1로 초기화
		for (int i=0; i<result.length; i++) {
			result[i]=-1;
		}
		for (int i=0; i<str2.length; i++) {
			for (int j=0; j<alphabet.length; j++) {
				if (str2[i]==alphabet[j] && result[j]==-1) {
					result[j]=i;
				}
			}
		}
		for (int x:result) {
			System.out.printf("%d ",x);
		}
	}

}

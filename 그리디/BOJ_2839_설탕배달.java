import java.util.Scanner;

/*
 * @see https://www.acmicpc.net/problem/2839
 */
public class BOJ_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int var1=N/5;
		int var2=N%5;
		int var3=var2/3;
		int var4=var2%3;
		if(var4!=0) {
			// 5로 안나눠질때
			while(var1>0) {
				var2+=5; //나머지 +5
				var1-=1; //몫 -1 하면서 3으로 나눠질 수 있는지 확인
				var3=var2/3;
				var4=var2%3;
				if(var4==0) {
					System.out.println(var1+var3);
					break;
				}
			}
			if (var4!=0) {
				System.out.println(-1);
			}
		}else {
			System.out.println(var1+var3);
		}
		
	}

}

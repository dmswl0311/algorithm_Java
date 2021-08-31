import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author CHO
 * @see https://www.acmicpc.net/problem/2851
 *
 */
public class BOJ_2851_슈퍼마리오 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] list=new int[10];
		int sum=0;
		for (int i = 0; i < 10; i++) {
			int N = Integer.parseInt(br.readLine());
			list[i]=N;
		}
		boolean flag=false;
		for (int i = 0; i < list.length-1; i++) {
			sum+=list[i];
			if(Math.abs(100-sum)>Math.abs(100-(sum+list[i+1]))) {
				// 다음 숫자를 더한게 100과 더 가까우면
				continue;
			}else if(Math.abs(100-sum)==Math.abs(100-(sum+list[i+1]))) {
				if (sum<sum+list[i+1]) {
					continue;
				}else {
					flag=true;
					break;
				}
			}else {
				// 지금 숫자 더한게 100과 더 가까우면
				flag=true;
				break;
			}
		}
		if (!flag) {
			if(Math.abs(100-sum)>Math.abs(100-(sum+list[list.length-1]))) {
				sum=sum+list[list.length-1];
			}else if(Math.abs(100-sum)==Math.abs(100-(sum+list[list.length-1]))) {
				if (sum<sum+list[list.length-1]) {
					sum=sum+list[list.length-1];
				}
			}
		}
		System.out.println(sum);
	}

}

import java.util.Arrays;
import java.util.Scanner;

public class Insertion_Sort {
	static int MAX=10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 0~10까지의 자연수 10개를 입력받고, 삽입 정렬해라
		 * ex) 7 5 9 0 3 1 6 2 4 8
		 */
		Scanner scan = new Scanner(System.in);
		int[] arr=new int[MAX];
		
		// 자연수 10개 입력 받음
		for (int i=0; i<MAX; i++) {
			arr[i]=scan.nextInt();
		}
		
		// 0번째 원소는 정렬되어있다고 가정하므로, index=1부터 시작
		for (int i=1; i<MAX; i++) {
			for (int j=i; j>0; j--) {
				if (arr[j]<arr[j-1]) {
					// 현재 원소보다 작을 경우, swap
					int swap=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=swap;
				}else {
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

}

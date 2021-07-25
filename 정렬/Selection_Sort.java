import java.util.Arrays;
import java.util.Scanner;

public class Selection_Sort {
	static int MAX=10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 0~10까지의 자연수 10개를 입력받고, 선택 정렬해라
		 * ex) 7 5 9 0 3 1 6 2 4 8
		 */
		Scanner scan = new Scanner(System.in);
		int[] arr=new int[MAX];
		
		// 자연수 10개 입력 받음
		for (int i=0; i<MAX; i++) {
			arr[i]=scan.nextInt();
		}
		
		for (int i=0; i<MAX; i++) {
			// 가장 작은 원소의 인덱스
			int min=i;
			// 최소값의 위치 구함 
			for (int j=i; j<MAX; j++) {
				if (arr[min]>arr[j]) {
					min=j;
				}
			}
			// 첫번째와 최소값 자리 바꿈
			int swap=arr[min];
			arr[min]=arr[i];
			arr[i]=swap;
		}
		
		System.out.println(Arrays.toString(arr));
	}

}

import java.util.Arrays;
import java.util.Scanner;

public class Quick_Sort {
	static int MAX=10;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 0~10까지의 자연수 10개를 입력받고, 퀵 정렬해라
		 * ex) 5 7 9 0 3 1 6 2 4 8
		 */
		Scanner scan = new Scanner(System.in);
		int[] arr=new int[MAX];
		
		// 자연수 10개 입력 받음
		for (int i=0; i<MAX; i++) {
			arr[i]=scan.nextInt();
		}
		
		// 피봇 설정
		//현재 피봇 위치 == 0
		quick_sort(arr,0,(arr.length)-1);
		
		System.out.println(Arrays.toString(arr));
	}
	// quick sort 재귀함수
	public static void quick_sort(int[] arr, int start,int end) {
		
		// arr의 원소 개수가 1이면 종료
		if (start>=end) {
			return;
		}
		int pivot=start;
		int left=start+1;
		int right=end;
		
		while(left<=right) {
			// 왼쪽으로 돌자! 피봇보다 큰수를 찾아라
			while(left<=end && arr[left]<=arr[pivot]) {
				left++;
				}
			// 오른쪽부터 돌자! 피봇보다 작은 수를 찾아라
			while(right>start && arr[right]>=arr[pivot]) {
				right--;
				}
			// 만약, 큰수의 위치와 작은 수의 위치가 엇갈리면 피봇의 위치와 작은 수의 위치를 swap
			if (left>right) {
				int swap=arr[pivot];
				arr[pivot]=arr[right];
				arr[right]=swap;
			}else {
				// 아니라면, 큰수와 작은 수의 위치 swap
				int swap=arr[left];
				arr[left]=arr[right];
				arr[right]=swap;
			}
		}
		quick_sort(arr,start,right-1);
		quick_sort(arr,right+1,end);
	}

}

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_201 {
	/*
	 * 파라메트릭 서치 유형
	 * 이것이 코딩 테스트다 201p, 떡볶이 떡 만들기 문제
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		int[] array=new int[N];
		for (int i=0; i<N; i++) {
			array[i]=scan.nextInt();
		}
		Arrays.sort(array);
		//System.out.println(Arrays.toString(array));
		int max=array[N-1];
		int[] list=new int[max+1];
		
		// 후보들 배열로 만들었음
		for (int i=0; i<max+1; i++) {
			list[i]=i;
		}
		//System.out.println(Arrays.toString(list));
		System.out.println(bs(list,array,M,0,list.length-1));
		
		
	}
	public static int bs(int[] list,int[] array,int M,int start,int end) {
		if(start>end) {
			return -1;
		}
		int mid=(start+end)/2;
		int target=0;
		for (int i=0; i<array.length; i++) {
			if (list[mid]<array[i]) {
				target+=array[i]-list[mid];
			}
		}
		
		if (M==target) {
			return list[mid];
		}else if(M<target){
			// 오른쪽으로 이동
			start=mid+1;
		}else {
			end=mid-1;
		}
		return bs(list,array,M,start,end);
	}
}

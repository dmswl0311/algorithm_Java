import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=10;
		int[] array=new int[N];
		for (int i=0; i<N; i++) {
			array[i]=i+1;
		}	
		int target=4;
		System.out.println(bs(array,target,0,N-1));
	}
	
	public static int bs(int[] array,int target,int start,int end) {
		if(start>end) {
			return -1;
		}
		int mid=(start+end)/2;
		if (target==array[mid]) {
			// target과 array[mid]에 있는 값이 같다면
			return mid;
		}else if (target<array[mid]) {
			// 왼쪽으로 이동
			end=mid-1;
		}else{
			start=mid+1;
		}
		return bs(array,target,start,end);
	}

}

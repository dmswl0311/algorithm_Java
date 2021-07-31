import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_11652 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		List<Long> list=new ArrayList<Long>();
		
		for (int n=0; n<N; n++) {
			Long num=scan.nextLong();
			list.add(num);
		}
		Collections.sort(list);
		int cnt=1;
		Long result=list.get(0);
		int max=-1;
		
		for (int i=0; i<N-1; i++) {
			if (list.get(i).equals(list.get(i+1))) {
				cnt++;
				if (i==N-2) {
					// 마지막일때도 확인
					if (max<cnt) {
						max=cnt;
						result=list.get(i);
					}
				}
			}else {
				if (max<cnt) {
					max=cnt;
					result=list.get(i);
				}
				cnt=1;
			}
		}
		System.out.println(result);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 69868	300
 * @author CHO
 * @see https://www.acmicpc.net/problem/1107
 * @category 브루트포스
 * 100일때, +, - 나눠서 그 중 최솟값 구하기
 */
public class BOJ_1107_리모컨 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] error=new int[M];
		ArrayList<Integer> list=new ArrayList<>();
		
		if(M!=0) {
			error=new int[M];
			st=new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				error[i]=Integer.parseInt(st.nextToken());
			}// 입력 완료
			
			list=new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				boolean flag=true;
				int curr=i;
				for (int j = 0; j < M; j++) {
					if(curr==error[j]) {
						flag=false;
						break;
					}
				}
				if(flag) {
					list.add(curr);
				}
			} // 입력 가능한 숫자만 뽑음
		}else {
			String str=Integer.toString(N);
			int m=Math.abs(N-100);
			if (m>str.length()) {
				System.out.println(str.length());
			}else {
				System.out.println(m);
			}
			System.exit(0);
		}// M이 있을때와 없을때 처리 ok
		
		if(N==100) {
			System.out.println(0);
			System.exit(0);
		}
		
		// N에 금지 숫자가 들어가있는지 확인
		String str=Integer.toString(N);
		boolean flag=true;
		outer: for (int i = 0; i < str.length(); i++) {
			char c=str.charAt(i);
			for (int j = 0; j < M; j++) {
				if(c==(char)(error[j]+'0')) {
					flag=false;
					break outer;
				}
			}
		}
		if(flag) {
			String li=Integer.toString(N);
			int m=Math.abs(N-100);
			if (m>str.length()) {
				System.out.println(li.length());
			}else {
				System.out.println(m);
			}
			System.exit(0);
		}
		
		// -------바로 입력할 수 없고, 100이 아닌 숫자들 처리
		
		int min=Integer.MAX_VALUE;
		// 1. 100에서부터 계산 
		min=Math.abs(N-100);
		
		int ori=min; // min 저장
		int count=min;
		
		// 2. 직접 입력해서 계산
		// ++
		int curr=N;
		int min2=0;
		
		while(count-->0) {
			curr++; //현재 숫자
			min2++; //몇번 이동
			String number=Integer.toString(curr);
			// 에러 숫자를 포함하는지 화인
			boolean flag2=true;
			outer: for (int i = 0; i < number.length(); i++) {
				char c=number.charAt(i);
				for (int j = 0; j < M; j++) {
					if(c==(char)(error[j]+'0')) {
						flag2=false;
						break outer;
					}
				}
			}
			//포함하지 않는다면 break
			if(flag2) {
				min=min>(min2+Integer.toString(curr).length())?(min2+Integer.toString(curr).length()):min;
				break;
			}
		}
		
		// --
		curr=N;
		min2=0;
		count=ori;
		while(count-->0) {
			curr--;
			min2++;
			String number=Integer.toString(curr);
			boolean flag2=true;
			outer: for (int i = 0; i < number.length(); i++) {
				char c=number.charAt(i);
				for (int j = 0; j < M; j++) {
					if(c==(char)(error[j]+'0')) {
						flag2=false;
						break outer;
					}
				}
			}
			if(flag2) {
				min=min>(min2+Integer.toString(curr).length())?(min2+Integer.toString(curr).length()):min;
				break;
			}
		}
		System.out.println(min);
		
	}
}

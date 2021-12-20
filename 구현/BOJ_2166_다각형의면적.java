import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 17436	184
 * @author CHO
 * @see https://www.acmicpc.net/problem/2166
 * @category 신발끈 공식 (https://namu.wiki/w/%EC%8B%A0%EB%B0%9C%EB%81%88%20%EA%B3%B5%EC%8B%9D)
 */
public class BOJ_2166_다각형의면적 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<long[]> list=new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			long x=Long.parseLong(st.nextToken());
			long y=Long.parseLong(st.nextToken());
			list.add(new long[] {x,y});
		}
		list.add(list.get(0));
		long num1=0L;
		long num2=0L;
		for (int i = 0; i < list.size()-1; i++) {
			long a=list.get(i)[0];
			long b=list.get(i+1)[1];
			num1+=(a*b);
		}
		for (int i = 0; i < list.size()-1; i++) {
			long a=list.get(i)[1];
			long b=list.get(i+1)[0];
			num2+=(a*b);
		}
		
		System.out.println(String.format("%.1f",Math.abs((num1-num2)/2.0)));
		

	}
}

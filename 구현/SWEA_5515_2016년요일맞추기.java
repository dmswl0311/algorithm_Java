import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 20,712 kb 107 ms
 * @author CHO
 * @see
 * @category 수학
 * 1/1일부터 몇일이나 떨어져 있는지 구하고, 금요일만큼 뺌-> 6을 넘어갈 수 있으니 %7
 */
public class SWEA_5515_2016년요일맞추기 {
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static int[] day= {0,31,29,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int sumDay=d;
			
			for (int i = 1; i < m; i++) {
				sumDay+=day[i];
			}
			int result=((4+sumDay-1)%7);
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

}

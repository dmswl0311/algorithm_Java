import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author CHO
 * @see https://www.acmicpc.net/problem/2941
 * 문자열
 */
public class BOJ_2941_크로아티아알파벳 {
	static String[] alpha= {"c=","c-","dz=","d-","lj","nj","s=","z="};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		for (int i = 0; i < alpha.length; i++) {
			if(str.contains(alpha[i])) {
				str=str.replace(alpha[i], "0");
			}
		}
		System.out.println(str.length());

	}

}

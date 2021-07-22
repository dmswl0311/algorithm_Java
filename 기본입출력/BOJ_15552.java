import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15552 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			st=new StringTokenizer(br.readLine());
			
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			int result=num1+num2;
			
			bw.write(result+"\n");
		}
		bw.flush();
		bw.close();
	}

}

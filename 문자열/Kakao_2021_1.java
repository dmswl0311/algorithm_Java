import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2021 카카오 블라인드 채용
 * 1번 신규 아이디 추천
 * @author CHO
 * 문자열
 */

public class Kakao_2021_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		// 1. 소문자로 치환
		str=str.toLowerCase();
		
		// 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
		String str2="";
		
		for (int i = 0; i < str.length(); i++) {
			char curr=str.charAt(i);
			
			if(97<=curr && curr<=122) {
				str2+=str.charAt(i);
			}
			else if(0<=curr-'0' && curr-'0'<=9) {
				str2+=str.charAt(i);
			}
			else if(curr=='-') {
				str2+=str.charAt(i);
			}
			else if(curr=='_') {
				str2+=str.charAt(i);
			}
			else if(curr=='.') {
				str2+=str.charAt(i);
			}
			else {
				continue;
			}
		}
		
		// 3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		String str3="";
		int cnt=0;
		
		for (int i = 0; i < str2.length(); i++) {
			char curr=str2.charAt(i);
			if(curr=='.') {
				cnt++;
			}else if(curr!='.' && cnt>0) {
				str3+='.';
				str3+=curr;
				cnt=0;
			}else {
				str3+=curr;
			}
		}
		
		// 4. 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		if (str3.length()>0) {
			if (str3.charAt(0)=='.') {
				str3=str3.substring(1);
			}
			if (str3.charAt(str3.length()-1)=='.') {
				str3=str3.substring(0, str3.length()-1);
			}
		}
		
		// 5.빈 문자열이라면, new_id에 "a"를 대입합니다.
		if (str3=="") {
			str3="a";
		}
		
		/* 6.길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
		 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다. */
		if (str3.length()>=16) {
			str3=str3.substring(0, 15);
		}
		if (str3.charAt(str3.length()-1)=='.') {
			str3=str3.substring(0, str3.length()-1);
		}
		
		// 7. 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		if(str3.length()<=2) {
			while(str3.length()<3) {
				str3+=str3.charAt(str3.length()-1);
			}
		}

		
		System.out.println(str3);
		
	}

}

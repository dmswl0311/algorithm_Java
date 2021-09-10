import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 2021 카카오 블라인드 채용
 * 메뉴 리뉴얼
 * @author CHO
 * 순열, 정렬
 */

public class Kakao_2021_메뉴리뉴얼 {
	static char pick[];
	static String[] list;
	static ArrayList<String> result;
	static int max;
	public static void main(String[] args) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"
		list= new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		result=new ArrayList<>();
		for (int i = 0; i < list.length; i++) {
			for (int j = 2; j < list[i].length(); j++) {
				pick=new char[j];
				max=Integer.MIN_VALUE;
				combination(0,0,j,list[i],i);
			}
		}
		Collections.sort(result);
		System.out.println(result);
	}
	private static void combination(int cnt, int start,int R,String str,int index) {
		if(cnt==R) {
			String pick_str="";
			for (char x:pick) {
				pick_str+=x;
			}
			System.out.println(pick_str);
			boolean flag=false;
			
			for (int i = 0; i < result.size(); i++) {
				if (result.get(i).equals(pick_str)) {
					flag=true;
					break;
				}
			}
			
			// 만약, 지금 뽑은게 result에 없다면 카운트 세기
			int menu_cnt=1;
			if (!flag) {
				for (int i =0; i < list.length; i++) {
					boolean flag2=false;
					System.out.println("비교문자열"+list[i]);
					if (i!=index&&list[i].length()>=pick_str.length()) {
						for (int j = 0; j < R; j++) {
							char curr=pick_str.charAt(j);
							if(list[i].contains(String.valueOf(curr))) {
								continue;
							}else {
								flag2=true;
								break;
							}
						}
						if(!flag2) menu_cnt++;
					}
				}
				if(menu_cnt>=2 && max<=menu_cnt) {
					max=menu_cnt;
					System.out.println("정답::"+pick_str);
					result.add(pick_str);
				}
			}
			return;
		}
		for (int i = start; i < str.length(); i++) {
			pick[cnt]=str.charAt(i);
			combination(cnt+1,i+1,R,str,index);
		}
	}

}

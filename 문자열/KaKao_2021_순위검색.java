import java.util.Arrays;

/**
 * 2021 카카오 블라인드 채용
 * 순위검색
 * @author CHO
 * 문자열
 */


public class KaKao_2021_순위검색 {

	public static void main(String[] args) {
		String[] info= {
				"java backend junior pizza 150",
				"python frontend senior chicken 210",
				"python frontend senior chicken 150",
				"cpp backend senior pizza 260",
				"java backend junior chicken 80",
				"python backend senior chicken 50"};
		String[] query= {
				"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150"};
		int[] result=new int[query.length];
		
		// i번째 조건에 맞는 사람
		for (int i = 0; i < query.length; i++) {
			int cnt=0;
			String q=query[i];
			q=q.replaceAll(" ","");
			String[] resultq=q.split("and");
			char[] list=resultq[resultq.length-1].toCharArray();
			String food="";
			String score="";
			for (int j = 0; j < list.length; j++) {
				if(97<=list[j] && list[j]<=122) food+=list[j];
				else if(list[j]!=' ' && list[j]!='-') score+=list[j];
			}
			
			// p번째 사람은 i번째 조건에 맞을까? 
			for (int p = 0; p < info.length; p++) {
				String[] resultinfo=info[p].split(" ");
				boolean flag=true;
				// p번째 사람의 조건들 비교 
				for (int index = 0; index < 3; index++) {
					if (resultq[index].equals("-")) {
						continue;
					}else if(resultq[index].equals(resultinfo[index])) {
						continue;
					}else {
						flag=false;
						break;
					}
				}
				if (flag) {
					// 점수와 food 비교
					if(food.equals(resultinfo[3])) {}
					else if(food.equals("")) {}
					else {
						flag=false;
					}
					if (flag) {
						if(Integer.parseInt(score)<=Integer.parseInt(resultinfo[4])) {
							cnt++;
						}
					}
				}
			}
			result[i]=cnt;
		}
		
		System.out.println(Arrays.toString(result));
	}

}

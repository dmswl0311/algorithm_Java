package com.ssafy.ws;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1244 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] sw=new int[N];
		for (int n=0; n<N; n++) {
			sw[n]=scan.nextInt();
		}
		int S=scan.nextInt();
		int[][] student=new int[S][2];
		for (int s=0; s<S; s++) {
			for (int j=0; j<2; j++) {
				student[s][j]=scan.nextInt();
			}
		}
		//학생이 남자인지, 여자인지에 따라 스위치 다름
		//남:1 여:2
		for(int i=0; i<S; i++) {
			if(student[i][0]==1) {
				//남자
				for(int n=1; n<N+1; n++) {
					if (n%student[i][1]==0) {
						//배수이면
						sh(sw,n-1);
					}
				}
			}
			else if(student[i][0]==2) {
				//여자
				int index=student[i][1]-1; //받은 스위치의 인덱스
				int step=1; //시작
				while(true) {
					if(index-step<0 || index+step>=N) {
						//범위를 나가거나
						step-=1;
						break;
					}
					if(sw[index-step]==sw[index+step]) {
						//값 바꿔줌
						sh(sw,index-step);
						sh(sw,index+step);
						step+=1;
					}else {
						//대칭이 아닐 때에는 break;
						step-=1;
						break;
					}
				}
				sh(sw,index);
			}
		}
		// 한줄에 20개씩 출력
		//System.out.println(Arrays.toString(sw));
		for(int i=0;i<sw.length; i++) {
			if(i%20==0 && i!=0) {
				System.out.println();
			}
			System.out.print(sw[i]+" ");
		}
	}
	
	public static void sh(int[] array,int index) {
		if(array[index]==1) {
			array[index]=0;
		}else {
			array[index]=1;
		}
	}

}

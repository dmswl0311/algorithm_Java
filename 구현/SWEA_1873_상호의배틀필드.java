package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드 {
	private static StringTokenizer st;
	private static StringBuilder sb=new StringBuilder();
	private static int H;
	private static int W;
	private static int startR;
	private static int startC;
	private static char[][] map;
	private static int nr,nc=0;
	private static int dir[][]= {{0,0},{-1,0},{1,0},{0,-1},{0,1}}; // 전차의 방향 상태
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine()); // 테케 수
		for (int t=0; t<T; t++) { // 테케만큼 반복
			
			st=new StringTokenizer(br.readLine()," ");
			H=Integer.parseInt(st.nextToken()); // 맵의 높이
			W=Integer.parseInt(st.nextToken()); // 맵의 너비
			map=new char[H][W]; // 입력받은 맵
			
			int state=0; // 초기 전차의 방향 상태

			startR=0; // 시작할 전차 위치 r
			startC=0; // 시작할 전차 위치 c
			
			for (int h=0; h<H; h++) {
				String str=br.readLine();
				for (int w=0; w<W; w++) {
					char c=str.charAt(w);
					map[h][w]=c;
					if ((c=='^' || c=='v' || c=='<' || c=='>')) {
						// 전차의 현재 방향 저장(state) 
						if (c=='^') {
							state=1;
						}else if (c=='v') {
							state=2;
						}else if (c=='<') {
							state=3;
						}else {
							state=4;
						}
						// start 위치 저장
						startR=h;
						startC=w;
					}
				}
			}
			int N=Integer.parseInt(br.readLine());
			char data[]=new char[N];
			String str=br.readLine();
			for (int n=0; n<N; n++) {
				data[n]=str.charAt(n);
			}
			// logic ------------------------------------
            for (int i=0; i<N; i++) {
                if(data[i]=='U') {
                    // 방향을 위쪽으로 바꿈
                    state=1;
                    cal(state);
                     
                }else if(data[i]=='D') {
                    state=2;
                    cal(state);
                     
                }else if(data[i]=='L') {
                    state=3;
                    cal(state);
                     
                }else if(data[i]=='R') {
                    state=4;
                    cal(state);
                     
                }else if(data[i]=='S') {
                    int sr=startR;
                    int sc=startC;
                    while(true) {
                        nr=sr+dir[state][0];
                        nc=sc+dir[state][1];
                        if (!(isOkay(nr,nc))) {
                            // 바깥으로 나가면 직진 끝
                            break;
                        }
                        if (map[nr][nc]=='*') {
                            map[nr][nc]='.';
                            break;
                        }
                        if (map[nr][nc]=='#') {
                            break;
                        }
                             
                        sr=nr;
                        sc=nc;
                    }
                }
            }
			if (state==1) {
				map[startR][startC]='^';
			}else if (state==2) {
				map[startR][startC]='v';
			}else if (state==3) {
				map[startR][startC]='<';
			}else {
				map[startR][startC]='>';
			}
			
			sb.append("#").append(t+1).append(" ");
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	// 범위 메서드
	private static boolean isOkay(int r,int c) {
		return r>=0 && c>=0 && r<H && c<W;
	}
	// 이동 메서드
	private static void cal(int state) {
		nr=startR+dir[state][0];
        nc=startC+dir[state][1];
        if (isOkay(nr,nc) && map[nr][nc]=='.') {
            // 맵 밖으로 나가지 않고, 한칸 위가 평지라면
            map[startR][startC]='.';
            startR=nr;
            startC=nc;
        }
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {
	static int N,M,R;
	static int[][] map;
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); //배열 크기
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken()); //몇번 회전
		map=new int[N][M];
		for(int n=0; n<N; n++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int m=0; m<M; m++) {
				map[n][m]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine()," ");
		for(int r=0; r<R; r++) {
			int A=Integer.parseInt(st.nextToken());
			switch(A) {
			case 1:
				// 상하 반전
				updown(map.length, map[0].length);
				break;
			case 2:
				// 좌우 반전
				leftright(map.length, map[0].length);
				break;
			case 3:
				// 오른쪽으로 90도
				right90(map.length, map[0].length);
				break;
			case 4:
				// 왼쪽으로 90도
				left90(map.length, map[0].length);
				break;
			case 5:
				mov(map.length, map[0].length);
				// 앞에서 나눈 맵 출력
				break;
			case 6:
				mov2(map.length, map[0].length);
				// 나눈 맵 각자의 위치로 이동
				break;
			}
		}
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	// 6.옮기기
	private static void mov2(int N,int M) {
		int[][] move=new int[N][M];
		int r=N/2;
		// 1-> 4
		for(int i=0; i<N/2; i++) {
			for (int j=0; j<M/2; j++) {
				move[i+r][j]=map[i][j];
			}
		}
		
		// 4-> 3 dd
		int c=M/2;
		for(int i=N/2; i<N; i++) {
			for (int j=0; j<M/2; j++) {
				move[i][j+c]=map[i][j];
			}
		}
		// 3-> 2
		for(int i=N/2; i<N; i++) {
			for (int j=M/2; j<M; j++) {
				move[i-r][j]=map[i][j];
			}
		}
		// 2-> 1 dd
		for(int i=0; i<N/2; i++) {
			for (int j=M/2; j<M; j++) {
				move[i][j-c]=map[i][j];
			}
		}
		// 다시 map으로 만들어주기
		map=new int[N][M];
		// 다시 map으로 만들어주기
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				map[i][j]=move[i][j];
			}
		}
	}
	
	// 5번 연산
	private static void mov(int N,int M) {
		int[][] move=new int[N][M];
		int c=M/2;
		// 1-> 2
		for(int i=0; i<N/2; i++) {
			for (int j=0; j<M/2; j++) {
				move[i][j+c]=map[i][j];
			}
		}
		
		// 2-> 3
		int r=N/2;
		for(int i=0; i<N/2; i++) {
			for (int j=M/2; j<M; j++) {
				move[r][j]=map[i][j];
			}
			r++;
		}
		// 3-> 4
		for(int i=N/2; i<N; i++) {
			for (int j=M/2; j<M; j++) {
				move[i][j-c]=map[i][j];
			}
		}
//		// 4-> 1
		r=0;
		for(int i=N/2; i<N; i++) {
			for (int j=0; j<M/2; j++) {
				move[r][j]=map[i][j];
			}
			r++;
		}
		
		// 다시 map으로 만들어주기
		map=new int[N][M];
		// 다시 map으로 만들어주기
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				map[i][j]=move[i][j];
			}
		}
	}

	// 1. 상하 반전
	private static void updown(int N,int M) {
		int[][] move=new int[N][M];
		int i=N-1;
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				move[i][c]=map[r][c];
			}
			i--;
		}
		// 다시 map으로 만들어주기
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				map[r][c]=move[r][c];
			}
		}
	}
	
	// 2. 좌우 반전
		private static void leftright(int N,int M) {
			int[][] move=new int[N][M];
			int i=M-1;
			for (int c=0; c<M; c++) {
				for (int r=0; r<N; r++) {
					move[r][i]=map[r][c];
				}
				i--;
			}
			// 다시 map으로 만들어주기
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					map[r][c]=move[r][c];
				}
			}
		}
		// 3. 오른쪽 90도 회전
		private static void right90(int N,int M) {
			int[][] move=new int[M][N];
			int i=0;
			int j=N-1;
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					move[i][j]=map[r][c];
					i++;
				}
				j--;
				i=0;
			}
			map=new int[M][N];
			// 다시 map으로 만들어주기
			for (int r=0; r<M; r++) {
				for (int c=0; c<N; c++) {
					map[r][c]=move[r][c];
				}
			}
		}
		// 4. 왼쪽 90도 회전
		private static void left90(int N,int M) {
			int[][] move=new int[M][N];
			int i=0;
			int j=M-1;
			for (int r=0; r<M; r++) {
				for (int c=0; c<N; c++) {
					move[r][c]=map[i][j];
					i++;
				}
				j--;
				i=0;
			}
			// 다시 map으로 만들어주기
			map=new int[M][N];
			// 다시 map으로 만들어주기
			for (int r=0; r<M; r++) {
				for (int c=0; c<N; c++) {
					map[r][c]=move[r][c];
				}
			}
		}
}

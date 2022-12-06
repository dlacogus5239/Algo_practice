package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7964 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int[] kingdom = new int[N]; // 차원관문 정보
			int broken = 0;	// 게이트가 없는 곳 count
			int result = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				kingdom[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {	
				if (kingdom[i] == 0) { // 게이트가 없는 곳들을 count한다
					broken++;
					if (broken == D) {	// 만약 게이트가 없는 곳들이 게이트가 커버 가능한 최대거리일 경우 
						result++;	// 관문 하나 세워주고 
						broken = 0;	// 다시 세기 시작
					}
				}
				if (kingdom[i] == 1) {	// 커버 가능한 최대거리 이내에 게이트가 존재 할 경우 
					broken = 0;	// 그곳까진 커버 가능하므로 다시 처음부터 세기 시작
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}

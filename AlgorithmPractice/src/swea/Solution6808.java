package swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6808 {
	static int[] gyuCard;
	static int[] inCard;
	static boolean[] gSelected; // 인영의 카드를 판별하기 위함
	static int[] inCardSelected; // 순열
	static int[] win;
	static int gyuWin;
	static int inWin;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			gyuWin = 0;
			inWin = 0;
			gyuCard = new int[9];
			inCard = new int[9];
			gSelected = new boolean[19];
			inCardSelected = new int[9];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gyuCard[i] = Integer.parseInt(st.nextToken());
				gSelected[gyuCard[i]] = true;
			}

			int cnt = 0;
			for (int i = 1; i <= 18; i++) {
				if ((!gSelected[i])) {
					inCard[cnt] = i;
					cnt++;
				}
			}
			perm(0, 0);
			System.out.println("#" + test_case + " " + gyuWin + " " + inWin);
		}
	}

	public static void perm(int cnt, int flag) {

		if (cnt == 9) {
			ScoreCalc();
			return;
		}
		for (int i = 0; i < 9; i++) {
			if ((flag & 1 << i) != 0)
				continue; // 1이면 선택된 원소임.
			inCardSelected[cnt] = inCard[i];
			perm(cnt + 1, flag | 1 << i);
		}
	}

	public static void ScoreCalc() {
		int gyuScore = 0;
		int inScore = 0;
		for (int c = 0; c < 9; c++) {
			if (gyuCard[c] > inCardSelected[c]) {
				gyuScore += gyuCard[c] + inCardSelected[c];
			} else {
				inScore += gyuCard[c] + inCardSelected[c];
			}
		}
		if (gyuScore > inScore) {
			gyuWin++;
		} else {
			inWin++;
		}

	}
}
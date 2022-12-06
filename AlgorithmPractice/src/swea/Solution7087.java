package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution7087 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // input / test_case
			ArrayList<String> title = new ArrayList<>();
			int[] isExist = new int[26]; // 알파벳 등장 하는지 검사
			for (int i = 0; i < N; i++) {
				title.add(br.readLine());
			}
			title.sort((o1, o2) -> (o1.charAt(0) - o2.charAt(0)));
			int result = 0;
			for (int i = 0; i < title.size(); i++) {
				int tmp = title.get(i).charAt(0) - 'A';
				isExist[tmp]++; // 앞글자 알파벳 등장여부 체크
			}
			for (int i = 0; i < isExist.length; i++) {
				if (isExist[i] == 0) {
					break;
				}
				result++;
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}

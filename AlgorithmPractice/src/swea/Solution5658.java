package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution5658 {
	// SWEA [모의 SW 역량테스트] 보물상자 비밀번호

	// 회전했을때 똑같은 경우 체크
	static HashSet<String> Rotation = new HashSet<>();
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		// test case START
		for (int t = 1; t <= T; t++) {
			// 숫자 개수 N, 크기 순서 K
			int N, K;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			String lock = br.readLine();

			// 중복된 수를 제거할 HashSet
			HashSet<Integer> nums = new HashSet<>();

			// 사각형이라 생각하자
			// 한변의 길이는 start ~ start + N / 4
			// 0 ~ N / 4
			// N / 4 + 1 ~ 2 * N / 4
			// 2 * N / 4 + 1 ~ 3 * N / 4
			// 3 * N / 4 + 1 ~ N

			// 회전하고 다음 문자열
			String next = lock;
			while (!flag) {

				// 수로 변환할 처음 idx, 끝 idx
				int start = 0;
				int end = start + N / 4;

				for (int i = 0; i < 3; i++) {
					int tmp = toDec(next.substring(start, end).toCharArray());

					nums.add(tmp);
					start = end;
					end = start + N / 4;
				}
				nums.add(toDec(next.substring(start, end).toCharArray()));

				next = Rotate(next);
			}

			Integer[] arr = nums.toArray(new Integer[0]);
			Arrays.sort(arr, (o1, o2) -> (o2 - o1));
			flag = false;
			sb.append("#").append(t).append(" ").append(arr[K - 1]).append("\n");
//
//			for (int i = 0; i < arr.length; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();

		}
		// test case END

		// output
		System.out.println(sb.toString());
	}

	// 16 진수 변환 함수

	public static int toDec(char[] hex) {
		int result = 0;

		for (int i = 0; i < hex.length; i++) {
//			System.out.print(hex[i] + " ");
			int cur = 0;
			if (Character.isAlphabetic(hex[i])) {
				cur = hex[i] - 'A' + 10;
			} else {
				cur = hex[i] - '0';
			}
			result += Math.pow(16, hex.length - (i + 1)) * cur;
		}

//		System.out.println();
		return result;
	}

	// 회전 함수
	public static String Rotate(String cur) {
		String tmp = "";
		tmp += cur.charAt(cur.length() - 1);
		tmp += cur.substring(0, cur.length() - 1);
		// 회전했을때 똑같은지 판별
		if (Rotation.contains(tmp)) {
			flag = true;
			return tmp;
		}

		Rotation.add(tmp);
		return tmp;
	}

}

package swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//SWEA 1233 사칙연산 유효성 검사  --> dfs
public class Solution1233{
	static LinkedList<String> input;
	static int N;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			result = 1;
			N = Integer.parseInt(br.readLine());
			input = new LinkedList<String>();
			input.add("");
			for (int i = 0; i < N; i++) {
				input.add(br.readLine().split(" ")[1]); // 완전이진트리 --> 자식 노드 번호 필요없음 입력에서 첫번째가 노드에 들어가는 정보
			}
			dfs(1);

			System.out.println("#" + test_case + " " + result);
		}
	}

	public static void dfs(int cur) { // Inorder --> 부모 노드가 Operator이고, 자식 두개가 숫자이면 계산 가능
		if (cur > N) { // 계산 가능 할 경우 부모 노드를 숫자로 바꿔주자.
			return;
		}

		dfs(cur * 2); // L
		dfs(cur * 2 + 1); // R
		// 처리

		if (!isDigit(input.get(cur))) { // Operator 인 경우
			if (cur * 2 > N) {
				return;
			}
			if (cur * 2 + 1 > N) {
				return;
			}
			if (isDigit(input.get(cur * 2)) && isDigit(input.get(cur * 2 + 1))) { // 자식 노드 두개가 숫자이면 계산
				input.set(cur, "0");
			} else {
				result = 0;
				return;
			}
		} else if (cur / 2 > 1) {
			if (isDigit(input.get(cur / 2))) {
				result = 0;
				return;
			}
		}

	}

	public static boolean isDigit(String s) {
		if (s.charAt(0) - '0' <= 9 && s.charAt(0) - '0' >= 0) {
			return true;
		}
		return false;

	}

}

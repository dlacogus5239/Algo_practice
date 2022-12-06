package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// SWEA 5432 쇠막대기 자르기

public class Solution5432 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		Stack<String> s = new Stack<String>(); // 괄호 저장 스택
		int test_case = Integer.parseInt(br.readLine());
		for (int T = 1; T <= test_case; T++) {
			input = br.readLine().split("");
			int result = 0;
			for (int k = 0; k < input.length; k++) {
				if (input[k].equals("(")) {
					// System.out.println("Push");
					if (input[k + 1].equals(")")) { // lazer
						result += s.size();
						// System.out.println(s.size());
						k++;
						continue;
					} else {
						s.push(input[k]);
					}

				} else if (input[k].equals(")")) {

					s.pop();
					result += 1;
				}
			}
			System.out.println("#" + T + " " + result);
		}
	}
}

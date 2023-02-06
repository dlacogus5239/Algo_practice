package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1918_noSolved0206 {
	// 백준 1918 후위 표기식
	/*
	 * 스택에는 연산자만 사용하고, 피연산자는 바로바로 출력한다 연산자의 우선 순위 지정 현재 연산자의 우선순위보다 큰 연산자가 stack의 맨
	 * 위에 있다면 없을 때까지 pop ")"일 경우 "("가 나올 때까지 stack안의연산자를 pop 피연산자는 따로 스택에 넣지 않고 그냥
	 * 출력하기 위해 붙여주자
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);

		}
	}

}

package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1541 {
	// 백준 1541 잃어버린 괄호
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 숫자와 +, - 로만 이루어져 있기 때문에 StringTokenizer 구분자로 +-를 주고,
		// 구분자도 토큰화에 포함시킨다.
		StringTokenizer st = new StringTokenizer(br.readLine(), "-+", true);

		// 총 토큰 개수를 저장한다.
		// 토큰개수로 for문을 돌리면 토큰을 뽑을때마다 토큰수가 줄어들어 정상적인 값이 도춛되지 않는다.
		int L = st.countTokens();

		// 연산자와 숫자를 저장하기 위한 스택
		Stack<String> s = new Stack<>();
		int result = 0;

		// +가 나오다가 -가 나오는 시점에 괄호를 치면 가장 작은 값을 도출할 수 있다.
		// +는 무시하고, 숫자가 나오면 더해주다가 -가 나오면 빼주자
		for (int i = 0; i < L; i++) {
			s.add(st.nextToken());
		}

		int tmp = 0;
		while (!s.isEmpty()) {
			String cur = s.pop();
			if (cur.equals("-")) {
				result -= tmp;
				tmp = 0;
			} else if (!cur.equals("+")) {
				tmp += Integer.parseInt(cur);
			}
		}
		// tmp에는 +로 더해줄수 밖에 없는 값들이 모여있다. 마지막에 더해주자
		
		result += tmp;

		System.out.println(result);
	}
}

package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Main1181 {
	static int N;

	static class str {
		String s;

		public str(String s) {
			this.s = s;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();
		// 중복 제거
		for (int i = 0; i < N; i++) {
			hs.add(br.readLine());
		}
		ArrayList<str> arr = new ArrayList<>();

		for (String s : hs) {
			arr.add(new str(s));
		}

		arr.sort(new Comparator<str>() {
			@Override
			public int compare(str o1, str o2) {
				if (o1.s.length() != o2.s.length()) {
					return o1.s.length() - o2.s.length();
				} else {
					return o1.s.compareTo(o2.s);
				}

			}
		});

		for (str cur : arr) {
			System.out.println(cur.s);
		}
	}

}

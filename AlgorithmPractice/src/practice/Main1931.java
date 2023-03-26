package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1931 {
	// 백준 1931 회의실 배정
	static class meeting implements Comparable<meeting> {
		int start;
		int end;

		public meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(meeting o) {
			if (this.end == o.end) {
				return (this.start - o.start);
			}
			return (this.end - o.end);
		}

		@Override
		public String toString() {
			return "meeting [start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<meeting> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr.add(new meeting(start, end));
		}
		Collections.sort(arr);

		int result = 0;
		int end = 0;
		for (int i = 0; i < arr.size(); i++) {
			meeting cur = arr.get(i);
			if (end <= cur.start) {
				end = cur.end;
				result++;
			}
//			System.out.println(cur.toString());
		}
		System.out.println(result);
	}

}

package programmers;

public class Solution0419_2 {
	class Solution {
		public int solution(String skill, String[] skill_trees) {
			int answer = 0;
			for (String cur : skill_trees) {
				String tmp = cur;
				for (int i = 0; i < tmp.length(); i++) {
					String s = tmp.substring(i, i + 1);
					// System.out.print(s + " ");

					if (!skill.contains(s)) {
						cur = cur.replace(s, "");
					}
				}
				// System.out.println();
				if (skill.indexOf(cur) == 0) {
					answer++;
				}
			}

			return answer;
		}
	}
}

package my.anson;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Third {
	public static void main(String[] args) {
		Third third = new Third();
		int length = third.lengthOfLongestSubstring2("pwwkew");
		System.out.println(length);
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0 ){
			return 0;
		}else {
			Set<Character> charSet = new HashSet<>();
			int maxLength = 0;
			for (int i = 0; i < s.length(); i++) {
				for (int k = i; k < s.length(); k++) {
					char c = s.charAt(k);
					if (charSet.contains(c)) {
						if (charSet.size() > maxLength) {
							maxLength = charSet.size();
						}
						charSet = new HashSet<>();
						break;
					}else {
						charSet.add(c);
					}
				}
			}
			if (!charSet.isEmpty() && charSet.size() > maxLength) {
				maxLength = charSet.size();
			}
			return maxLength;
		}
	}

	/**
	 * a smarter way
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring2(String s){
		if (s == null || s.length() == 0 ){
			return 0;
		}
		int left = 0;
		int right = 0;
		int maxLength = 0;
		Map<Character, Integer> charMap = new HashMap<>();
		while (right < s.length()) {
			char c = s.charAt(right);
			Integer lastInd = charMap.get(c);
			if (lastInd != null) {
				//更新左边坐标
				left = Math.max(lastInd + 1, left);
			}
			maxLength = Math.max(maxLength, right - left + 1);
			charMap.put(c, right);
			right++;
		}
		return maxLength;
	}
}

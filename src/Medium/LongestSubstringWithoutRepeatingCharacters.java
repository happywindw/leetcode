package Medium;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int maxLength = 1;  // 最长子串长度
        int j = 1;
        for(int i = 0; j < s.length();) {
            for(; j < s.length(); j++) {
                if(s.length() - i <= maxLength) {  // 剩余长度比之前找出的最长子串长度小时就结束
                    j = s.length() + 1;
                    break;
                }
                if(repeatIndex(i, j - 1, s.charAt(j), s) == -1)  // 没有重复
                    continue;

                int k = repeatIndex(i, j - 1, s.charAt(j), s);
                maxLength = (j - i) > maxLength ? (j - i) : maxLength;
                i = k + 1;
                break;
            }
            if(j == s.length()) {
                maxLength = (j - i) > maxLength ? (j - i) : maxLength;
                break;
            }
        }
        return maxLength;
    }

    final int repeatIndex(int st, int ed, char a, String s) {
        for(int k = st; k <= ed; k++) {
            if(s.charAt(k) == a)
                return k;
        }
        return -1;  // 未发现重复
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lc = new LongestSubstringWithoutRepeatingCharacters();
        String st1 = "aaaaaaaaaa";
        String st2 = "abcdefghij";
        String st3 = "asdfabczxb";
        System.out.println(lc.lengthOfLongestSubstring(st1));
        System.out.println(lc.lengthOfLongestSubstring(st2));
        System.out.println(lc.lengthOfLongestSubstring(st3));
    }
}

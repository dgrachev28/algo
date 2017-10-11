package algo;

public class Strings {

    /**
     * http://practice.geeksforgeeks.org/problems/subsequence-matching/0
     */
    public static boolean subsequenceMatching(String s) {
        String[] patterns = {"R", "RY", "RYY"};
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < patterns.length; j++) {
                int begin = i - patterns[j].length();
                if (begin >= 0) {
                    if (s.substring(begin, i).equals(patterns[j]) && dp[begin]) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * http://practice.geeksforgeeks.org/problems/longest-prefix-suffix/0
     */
    public static int longestPrefixSuffix(String s) {
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int t = i;
            while (t != 0 && s.charAt(i) != s.charAt(dp[t - 1])) {
                t = dp[t - 1];
            }
            if (t != 0) {
                dp[i] = dp[t - 1] + 1;
            }
        }
        return dp[s.length() - 1];
    }
}

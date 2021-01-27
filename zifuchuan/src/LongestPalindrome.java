/**
 * 最长回文子串
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */


public class LongestPalindrome {

    /**
     * 动态规划
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;  //判断
        int maxLen = 1;         //  最长的长度
        int begin = 0;          //  最长的开始的位置
        boolean[][] dp = new boolean[len][len];  //初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();

        //状态转移，注意规则
        for (int  i=len-1 ; i>=0 ; i--){
            for (int j = i ; j<len ; j++){
                // 头尾不相等，肯定不是回文
                if (chars[i] != chars[j]) dp[i][j] = false;
                else {
                    //去掉头尾之后，只剩一个字母或者没有字母剩余的时候，肯定是回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                // 此时更新记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);  //返回值
    }

    /**
     * 中心扩展法
     */
    public static String longestPalindrome1(String s) {
        int n = s.length();
        if (n < 2) {    //判断
            return s;
        }
        int start = 0;  // 最长回文串开始的位置
        int end = 0;    // 最长回文串结束的位置

        for (int i = 0; i < n; i++) {       // 遍历每个位置，当做中心位
            // 分别拿到奇数偶数的回文子串长度
            int len_odd = expandCenter(s, i, i);
            int len_even = expandCenter(s, i, i + 1);
            // 对比最大的长度
            int len = Math.max(len_odd, len_even);
            // 计算对应最大回文子串的起点和终点
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        // 注意：这里的end+1是因为 java自带的左闭右开的原因
        return s.substring(start, end+1);
    }

    /**
     * @param s             输入的字符串
     * @param left          起始的左边界
     * @param right         起始的右边界
     * @return              回文串的长度
     */
    public static int expandCenter(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        // 跳出循环的时候恰好满足 s.charAt(left) ！= s.charAt(right)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 回文串的长度是right-left+1-2 = right - left - 1
        return right - left + 1 - 2;
    }


    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}

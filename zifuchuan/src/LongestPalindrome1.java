/**
 * 最长回文串
 *      输入:
 *       "abccccdd"
 *      输出:
 *        7
 *
 *      出现偶数次的字符+一个出现奇数次的字符
 */


public class LongestPalindrome1 {
    public static int longestPalindrome(String s) {
        //定义一个数组，存储字符出现的次数
        int [] res = new int[128];
        for (char c:s.toCharArray()) {
            res[c] ++;
        }
        
        int count = 0 ;  //用来存储结果

        for (int i: res) {
            count += (i%2);
        }
        return  count==0 ? s.length(): s.length()-count+1;  //如果字符全部出现偶数次，最长=字符串的长度；
                                                            // 如果有奇数次的字符，字符串的长度-出现奇数次字符的个数+1
    }

    public static void main(String[] args) {
        String s ="abccccdd";
        System.out.println(longestPalindrome(s));
    }
}

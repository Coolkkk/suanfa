/**
 * 回文子串
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 */


public class CountSubStr {
    /**
     * 中心扩展法
     */
    public static int countSubstrings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int num = 0;    //用来保存个数
        for (int i = 0; i < n; i++) {          //遍历回文中心点
            for (int j = 0; j <= 1; j++) {      //j=0,中心是一个点，j=1,中心是两个点
                int left = i;
                int right = i + j;
                while (left >= 0 && right < n && chars[left--] == chars[right++]) num++;
            }
        }
        return num;
    }

    /**
     *  动态规划
     */
    public static int countSubstrings1(String s){
        int n = s.length();
        int num = 0;    // 用来保存个数
        boolean [][] dp = new boolean[n][n];  //初始化

        //状态转移，注意规则
        for (int  i=n-1 ; i>=0 ; i--){
            for (int j = i ; j<n ; j++){
                //头尾相等的时候&&（去掉头尾之后，只剩一个字母或者没有字母剩余的时候||状态转移）
                if (s.charAt(i)==s.charAt(j)&&(j-i<=3||dp[i+1][j-1])){
                    dp[i][j]=true;   // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                    num++;  // 此时更新记录回文个数
                }
            }
        }
        return  num;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings1(s));
    }
}

/**
 *  字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 *
 *  输入: s = "abcdefg", k = 2
 *  输出: "cdefgab"
 *
 */

/**
 *  1.直接使用字符串切片函数
 *  2.列表遍历拼接
 */

public class ReverseLeftStr {
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length())+s.substring(0,n);
    }

    public static String reverseLeftWords1(String s, int n) {
        StringBuilder sb = new StringBuilder("");
        for(int i =n ; i<s.length() ; i++){
            sb.append(s.charAt(i));
        }
        for(int i =0 ; i<n ; i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        String num1 = "abcdefg";
        int n = 2;
        System.out.println(reverseLeftWords1(num1,n));
    }
}

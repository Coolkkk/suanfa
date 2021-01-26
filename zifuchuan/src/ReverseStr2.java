/**
 *  反转字符串2：
 *  给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *            如果剩余字符少于 k 个，则将剩余字符全部反转。
 *             如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 */

/**
 *  把字符串转换成字符数组
 *  start=0 ， end =k-1；
 *  判断（如果end>数组长度-1，则令end=数组长度-1）
 *  反转
 *  然后 start=start+2k  end = end+2k
 *  继续反转
 */

public class ReverseStr2 {
    public static String reverseStr(String s, int k) {
        char [] chars = s.toCharArray();
        int start=0 , end = k-1;
        int length = chars.length-1;
        while(start<length){
            if (end>length) {
                end = length;
            }
            rever(chars,start,end);
            start=start+2*k;
            end=end+2*k;
        }
        return new String(chars);
    }

    public static void rever (char [] chars, int start , int end){
        while(start<end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        String s="abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}

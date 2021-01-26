/**
 * 反转字符串：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 */

/**
 * 双指针法：
 *   第一个指针指向第一个元素
 *   第二个指针指向最后一个元素
 *    元素互换
 *    第一个指针++
 *    第二个指针--
 *    继续互换
 *    直到第一个指针大于等于第二个指针
 *
 */

public class ReverseStr {
    public static  void reverseString(char[] s) {
        int first = 0 , last= s.length-1;
        while(first<last){
            char tmp = s[first];
            s[first] = s[last];
            s[last] = tmp;
            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        char [] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }
}

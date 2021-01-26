/**
 *  旋转字符串：
 *  A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。
 *  如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 *    输入: A = 'abcde', B = 'cdeab'
 *    输出: true
 *
 *    输入: A = 'abcde', B = 'abced'
 *    输出: false
 */

public class RotateString {

    /**
     *  暴力法：每次旋转一个就和B比较
     *
     */
    public static boolean rotateString(String A, String B) {
        if(A.equals("")&&B.equals("")) return  true;
        int len = A.length();
        for(int i = 0; i<len ; i++){
           String A1=A.substring(1,len)+A.substring(0,1);
            A=A1;
            if (A1.equals(B)) {
                return true;
            }
        }
        return false;
    }

    /**
     *  直接判断B只要是A+A的字串
     */
    public  static  boolean rotateString1(String A, String B){
        return A.length() == B.length() && (A + A).contains(B);
    }



    public static void main(String[] args) {
        String num1 = "abcde";
        String num2 = "cdeab";
        System.out.println(rotateString(num1, num2));
        System.out.println(rotateString1(num1, num2));
    }
}

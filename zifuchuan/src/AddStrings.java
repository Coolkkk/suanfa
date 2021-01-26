/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 */


/**
 *   定义一个空sb，用于字符串拼接
 *   定义两个指针分别指向两个字母串末尾
 *   定义进位carry
 *   从字符串末尾逐位相加然后拼接
 *   最后反转输出
 */
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder("");
        int i = num1.length()-1 , j = num2.length()-1 , carry =0 ;
        while(i>=0 || j>=0){
            int n1 = i>=0 ? num1.charAt(i)-'0' : 0 ;
            int n2 = j>=0 ? num2.charAt(j)-'0' : 0 ;
            int tmp = n1 + n2 + carry;
            carry = tmp/10;
            sb.append(tmp%10);
            i--;
            j--;
        }
        if (carry==1) sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "103";
        String num2 = "104";
        System.out.println(addStrings(num1, num2));
    }
}

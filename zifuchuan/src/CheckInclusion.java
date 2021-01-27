/**
 * 字符串的排列
 * 第一个字符串的排列之一是第二个字符串的子串。
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 */

public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;  //判断
        int[] temp1 = new int[26];      //用两个长度26的数组，分别存储s1，s2字母出现的个数
        int[] temp2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {         //字母出现的个数存储到数组
            temp1[s1.charAt(i) - 'a']++;
            temp2[s2.charAt(i) - 'a']++;               //滑动窗口，大小为s1的大小
        }
        for (int j = 0; j < s2.length() - s1.length(); j++) {
            if(isMatch(temp1,temp2)){                  //开始先比较，如果相等就返回true
                return true;
            }
            temp2[s2.charAt(j+s1.length())-'a']++;      //滑动窗口移动，加入下一个字母
            temp2[s2.charAt(j)-'a']--;                 // 移除第一个字母
        }
        return isMatch(temp1,temp2);                // 最后比较i = s2.length-s1.length的情况
    }

    public static boolean isMatch(int [] temp1 , int [] temp2){  //比较temp1和temp2
        for (int i = 0; i <temp1.length ; i++) {
            if(temp1[i]!=temp2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 ="ab";
        String s2 ="eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }
}

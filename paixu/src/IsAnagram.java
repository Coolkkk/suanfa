import java.util.Arrays;

/**
 *  有效得字母异位词
 *
 *  输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 */


public class IsAnagram {

    /**
     * t 是 ss 的异位词等价于「两个字符串排序后相等」。
     * 因此我们可以对字符串 ss 和 tt 分别排序，看排序后的字符串是否相等即可判断。
     * 此外，如果 ss 和 tt 的长度不同，tt 必然不是 ss 的异位词。
     *
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())  return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 标签：哈希映射
     * 首先判断两个字符串长度是否相等，不相等则直接返回 false
     * 若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
     * s 负责在对应位置增加，t 负责在对应位置减少
     * 如果哈希表的值都为 0，则二者是字母异位词
     *
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] rs = new int[26];
        for(int i=0;i<s.length();i++){
            rs[s.charAt(i)-'a']++ ;
            rs[t.charAt(i)-'a']-- ;
        }

        for(int j=0;j<26;j++){
            if(rs[j]!=0) return false;
        }
        return true;
    }
}

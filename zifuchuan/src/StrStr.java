/**
 *  实现 strStr()
 *      给定一个 haystack 字符串和一个 needle 字符串，
 *      在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 *      输入: haystack = "hello", needle = "ll"
 *     输出: 2
 *
 */

public class StrStr {
    public static int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 == 0) return 0;
        for (int start= 0; start< len1 - len2+1; start++) {
            if (haystack.substring(start, start + len2).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s="abbcd";
        String s1 = "cd";
        System.out.println(strStr(s, s1));;
    }
}


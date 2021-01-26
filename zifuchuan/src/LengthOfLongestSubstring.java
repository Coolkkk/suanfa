import java.util.HashMap;

/**
 *  无重复字符的最长子串
 *
 *  输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */



public class LengthOfLongestSubstring {
    /**
     *  滑动窗口
     *  其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
     *
     * 如何移动？
     *  我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     *  一直维持这样的队列，找出队列出现最长的长度时候，求出解！
     *
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); //定义map集合，key为字符，value为字符位置
        int max = 0; //滑动窗口大小
        int left = 0; //滑动窗口的左边界
        for(int i = 0; i < s.length(); i ++){  //遍历字符串
            if(map.containsKey(s.charAt(i))){   //判断字符串的字符出现过没有，出现过就更新左边界
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);    //把字符防入map集合
            max = Math.max(max,i-left+1);  // 滑动窗口的大小
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

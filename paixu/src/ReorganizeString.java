/**
 *   重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 输入: S = "aaab"
 * 输出: ""
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *   基于最大堆的贪心算法
 *   1.判断（如果字符串长度小于2 ， 直接返回）
 *   2. 需要一个26位数组，存放a-z的元素； 一个int数表示出现次数最多的字母
 *   3. 遍历字符串，找出字母以及出现的次数
 *   3. 判断如果一个字母出现次数超过长度+1的一半返回空
 *   4. 构建最大堆
 *   5. 把字符防入堆中
 *   6. 如果堆的大小大于1，一次取出两个字符，字符次数-1，如果字符出现的次数大于0，继续放入；
 *   7. 如果堆的大小大于0，取出最后一个字符
 *   8. 返回字符串
 *
 */
public class ReorganizeString {
    public static String reorganizeString(String S) {
        if(S.length()<2) return  S;
        int [] counts = new int [26];
        int maxCounts = 0;
        int length = S.length();
        for (int i = 0; i <length ; i++) {
            char c = S.charAt(i);
            counts[c-'a']++;
            maxCounts = Math.max(maxCounts,counts[c-'a']);
        }
        if(maxCounts>(length+1)/2) return "";
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(queue.size()>1){
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1-'a' , index2=letter2-'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1]>0){
                queue.offer(letter1);
            }
            if (counts[index2]>0){
                queue.offer(letter2);
            }
        }

        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static String reorganizeString1(String S) {
        //把字符串S转化为字符数组
        char[] alphabetArr = S.toCharArray();
        //记录每个字符出现的次数
        int[] alphabetCount = new int[26];
        //字符串的长度
        int length = S.length();
        //统计每个字符出现的次数
        for (int i = 0; i < length; i++) {
            alphabetCount[alphabetArr[i] - 'a']++;
        }
        int max = 0, alphabet = 0, threshold = (length + 1) >> 1;
        //找出出现次数最多的那个字符
        for (int i = 0; i < alphabetCount.length; i++) {
            if (alphabetCount[i] > max) {
                max = alphabetCount[i];
                alphabet = i;
                //如果出现次数最多的那个字符的数量大于阈值，说明他不能使得
                // 两相邻的字符不同，直接返回空字符串即可
                if (max > threshold)
                    return "";
            }
        }
        //到这一步说明他可以使得两相邻的字符不同，我们随便返回一个结果，res就是返回
        //结果的数组形式，最后会再转化为字符串的
        char[] res = new char[length];
        int index = 0;
        //先把出现次数最多的字符存储在数组下标为偶数的位置上
        while (alphabetCount[alphabet]-- > 0) {
            res[index] = (char) (alphabet + 'a');
            index += 2;
        }
        //然后再把剩下的字符存储在其他位置上
        for (int i = 0; i < alphabetCount.length; i++) {
            while (alphabetCount[i]-- > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String s ="vvvlo";
        System.out.println(reorganizeString(s));
        System.out.println(reorganizeString1(s));
    }

}



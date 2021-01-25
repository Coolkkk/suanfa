import java.util.Arrays;

/**
 *  最大数
 *
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"

 * 输入：nums = [1]
 * 输出："1"
 *
 */




public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String [] nums1 = new String [nums.length];
        for(int i = 0 ; i<nums.length ; i++){
            nums1[i] = String.valueOf(nums[i]);
        }

        //自定义排序
        Arrays.sort(nums1,(o1, o2)->(o2+o1).compareTo(o1+o2));

        StringBuilder sb = new StringBuilder();
        for(int j =0 ; j<nums.length ; j++){
            sb.append(nums1[j]);
        }
        if(sb.charAt(0)=='0') return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        int [] nums ={10,2};
        System.out.println(largestNumber(nums));
    }
}

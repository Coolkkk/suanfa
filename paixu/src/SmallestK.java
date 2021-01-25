
/**
 *  最小K个数
 *  找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 *
 * 快排
 */


public class SmallestK {
    
    public int[] smallestK(int[] arr, int k) {
        quickSort(arr,0,arr.length-1,k);
        int [] result = new int[k];
        for(int c = 0 ; c<k ; c++){
            result[c]=arr[c];
        }
        return result;
    }

    public static void quickSort(int[] arr, int left, int right,int k){
        if(left>=right){
            return;
        }
        int p = partition(arr,left,right);
        if(p==k){
            return;
        }if(p>k){
            quickSort(arr,0,p-1,k);
        }else{
            quickSort(arr,p+1,right,k);
        }
    }

    public static int  partition(int[] arr, int left, int right){
        // 三数取中法 , 随机数在这里写
        int model = (left+right)/2;
        int piort = arr[model];

        // 交换到最右边
        int val = arr[model];
        arr[model] = arr[right];
        arr[right] = val;

        //判断
        int i = left;
        for(int j = left ; j<right ; j++){
            if(arr[j]<piort){
                int tmp = arr[j];
                arr[j] = arr [i];
                arr[i] = tmp;
                i++;
            }
        }
        int tmp = arr [i];
        arr[i] = arr [right];
        arr[right] = tmp;
        return i ;
    }
}

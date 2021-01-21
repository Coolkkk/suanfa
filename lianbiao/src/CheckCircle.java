public class CheckCircle {

    /**
     *   快慢指针
     *   快指针一次走两步
     *   慢指针一次一步
     *   如果两个相遇有环
     *
     */
    // 检测环
    public static boolean checkCircle(ListNode head) {
        if(head==null) return false;
        ListNode fast = head ,  slow =head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;
    }
}

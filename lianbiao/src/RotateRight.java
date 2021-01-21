//旋转链表

public class RotateRight {

    //暴力法
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode pre = new ListNode(0), tmp = pre;
        for (int i = 0; i < k; i++) {
            ListNode cur = head;
            ListNode cur1 = head;
            while (head != null) {
                tmp = head;
                head = head.next;
            }

            while (cur1.next.next != null) {
                cur1 = cur1.next;
            }
            cur1.next = cur1.next.next;
            tmp.next = cur;
            head = tmp;

        }
        return tmp;
    }

    // 快慢指针
    public static ListNode rotateRight1(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        ListNode tmp = head;
        int count = 0;
        while(tmp!=null){
            tmp=tmp.next;
            count++;
        }
        k = k % count;
        if(k==0) return head;
        ListNode p = head, fast = head, slow = head;
        for(int i = 0; i < k; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }


    //测试
    public static void main(String[] args) {
        RotateRight reverseLink = new RotateRight();
        ListNode head = RotateRight.createLink();
        System.out.println("输出创建好的链表:");
        reverseLink.printLink(head);
        System.out.println();
        System.out.println("打印后的单链表:");
//        ListNode result = rotateRight(head, 2);
//        reverseLink.printLink(result);
//        System.out.println();
        ListNode result1 = rotateRight1(head, 2);
        reverseLink.printLink(result1);
        System.out.println();

    }

    //构建链表
    private static ListNode createLink() {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        return node_1;
    }

    //打印输出链表
    private void printLink(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ——> ");
        }
    }

}

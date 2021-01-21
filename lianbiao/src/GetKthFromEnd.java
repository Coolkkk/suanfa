import java.util.Stack;


//倒数第K个节点
public class GetKthFromEnd {

    /**
     *  先把全部元素放进栈
     *  然后从栈中拿出第k个节点
     *   返回当前节点就是倒数的
     *
     */
    //利用栈先进后出实现
    public static  ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.add(head);
            head=head.next;
        }
        ListNode re = null;
        for(int i =0 ; i<k ; i++){
            re=stack.pop();
        }
        return re;
    }


    /**
     *   两个指针都指向头节点
     *   第一个指针先走到第K个元素
     *    然后两个指针同时走
     *    第一个指针走到最后一个元素的时候
     *    第二个指针就是倒数第k个元素
     *
     */

    // 双指针
    public static ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode per=head , temp = head;
        for(int i = 0;i<k-1;i++){
            per=per.next;
        }
        while(per.next!=null){
            per = per.next;
            temp = temp.next;
        }
        return temp;
    }


    //测试
    public static void main(String[] args) {
        GetKthFromEnd reverseLink = new GetKthFromEnd();
        ListNode head = GetKthFromEnd.createLink();
        System.out.println("输出创建好的链表:");
        reverseLink.printLink(head);
        System.out.println();
        System.out.println("打印后的单链表:");
        ListNode result = getKthFromEnd(head,2);
        ListNode result1 = getKthFromEnd1(head,2);
        reverseLink.printLink(result);
        System.out.println();
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

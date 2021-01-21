import java.util.Stack;

//两两反转链表
public class SwapPairs {

    /**
     *  如果链表为空或者只有一个节点直接返回
     *   先把节点中的元素全部放入栈
     *   如果是奇数，弹出最后一个元素
     *   然后如果栈不为空，一次弹出两个元素
     *   弹出的第一个元素next指向第二个元素（1->2->3->4     4->3）
     *   弹出的第二个元素next指向tmp （1->2->3->4     3->null）
     *   tmp指向第一个元素（tmp=4）
     *
     *   再弹一次
     *   （2->1）  (1->4) 即 （2->1->4->3）
     *    (tmp=2)
     *    返回tmp
     *
     */
    //利用栈实现
    public static ListNode swapPairs(ListNode head) {
        Stack<ListNode>  stack = new Stack<>();
        ListNode tmp = null;
        if(head==null || head.next==null){
            return head;
        }
        while(head!=null){
            stack.add(head);
            head=head.next;
        }
        if(stack.size()%2==1){
            tmp=stack.pop();
        }
        while (!stack.isEmpty()){
            ListNode first = stack.pop();
            ListNode second= stack.pop();
            first.next=second;
            second.next=tmp;
            tmp=first;
        }
        return tmp;
    }

    /**
     * 返回值：交换完成的子链表
     * 调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
     * 终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
     *
     */
    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }



    //测试
    public static void main(String[] args) {
        SwapPairs reverseLink = new SwapPairs();
        ListNode head = SwapPairs.createLink();
        System.out.println("输出创建好的链表:");
        reverseLink.printLink(head);
        System.out.println();
        System.out.println("打印后的单链表:");
        ListNode result = swapPairs(head);
        reverseLink.printLink(result);
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

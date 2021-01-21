
//合并两个有序链表
public class MergeTwoLists {

    /**
     *  定义一个哨兵节点
     *   判断两个链表都不为空的时候：
     *      l1和l2 谁的值小就先放到下一个节点
     *      更新l1和l2
     *      更新当前节点
     *     如果l1或者l2一个为空  把另一个直接添加到后面
     *
     */
    public static  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0), tmp = pre;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tmp.next=l1;
                l1=l1.next;
            }else{
                tmp.next=l2;
                l2=l2.next;
            }
            tmp=tmp.next;
        }
        tmp.next=l1==null?l2:l1;
        return pre.next;
    }

    //测试
    public static void main(String[] args) {
        MergeTwoLists reverseLink = new MergeTwoLists();
        ListNode head = MergeTwoLists.createLink();
        ListNode head1 = MergeTwoLists.createLink();
        System.out.println("输出创建好的链表:");
        reverseLink.printLink(head);
        System.out.println();
        System.out.println("打印后的单链表:");
        ListNode result = mergeTwoLists(head,head1);
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

//两数相加

public class addTwoNumbers {

    /**
     *  传入两个链表 2->1->3  1->2->3  得 3->3->6
     *  定义一个哨兵系节点  和  一个进位
     *  l1或者l2不是null  取值相加
     *  如果有进位 （4+8） count=12/10=1   12%10=2
     *  节点存2 向上进1
     *
     */
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode per = new ListNode(0) , tmp=per;
        int count = 0 , sum;

        while (l1!=null || l2!=null){
            int a = l1!=null ? l1.val: 0;
            int b = l2!=null ? l2.val: 0;
            sum = a+b+count;
            tmp.next = new ListNode( sum%10);
            tmp = tmp.next;
            count=sum/10;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }

        if (count> 0) {
            tmp.next = new ListNode(count);
        }
        return  per.next;
    }

    //测试
    public static void main(String[] args) {
        addTwoNumbers reverseLink = new addTwoNumbers();
        ListNode head = addTwoNumbers.createLink();
        ListNode head1 = addTwoNumbers.createLink();
        System.out.println("输出创建好的链表:");
        reverseLink.printLink(head);
        System.out.println();
        reverseLink.printLink(head1);
        System.out.println();
        System.out.println("打印后的单链表:");
        ListNode result = addTwoNumbers(head,head1);
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

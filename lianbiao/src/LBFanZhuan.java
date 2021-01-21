// 单链表反转
public class LBFanZhuan {

    /**
      原地反转
      先保存当前结点的下一个节点
      然后头结点指向上一个节点（头节点指向null）
      然后暂存当前节点
      然后访问下一个节点
     下一个节点再指向头节点
     1——>2——>3——>4——>5——>null
     null<——1<——2<——3<——4<——5
     */
    public static ListNode reverse(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;       //暂存后继节点
            cur.next = pre;                 //修改next引用指向
            pre = cur;                     //pre暂存cur
            cur = tmp;                    // cur访问下一节点
        }
        return pre;
    }

    //测试
    public static void main(String[] args) {
        LBFanZhuan reverseLink = new LBFanZhuan();
        ListNode head = LBFanZhuan.createLink();
        System.out.println("输出创建好的链表:");
        reverseLink.printLink(head);
        System.out.println();
        System.out.println("反转后的单链表:");
        ListNode result = reverse(head);
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

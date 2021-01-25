/**
 *   对链表进行插入排序
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 */

/**
 *  插入排序： 假定第一个元素已经排好序，从第二个开始，依次和它前面所有元素比较，找到合适的位置插入
 *  1.定义哨兵节点，让它的next指向头节点
 *  2.定义第一个指针last指向head节点，和cur指针指向head.next节点
 *  3.只要cur不为null，就和last比较，只要last.val<cur.val，继续往后比较
 *  4.直到找到last.val>cur.val的地方，然后找位置插入
 *  5.插入（定义一个prev指针，从head开始依次和cur比较，找到合适的位置之后插入）
 *
 */
public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode dummy = new ListNode(0) ;
        dummy.next = head;
        ListNode last = head , cur = head.next;
        while(cur!=null){
            if(last.val<=cur.val){
                last=last.next;
            }else{
                ListNode prev= dummy;
                while(prev.next.val<=cur.val){
                    prev=prev.next;
                }
                last.next=cur.next;
                cur.next=prev.next;
                prev.next=cur;
            }
            cur = last.next;
        }
        return dummy.next;
    }


    //测试
    public static void main(String[] args) {
        InsertionSortList reverseLink = new InsertionSortList();
        ListNode head = reverseLink.createLink();
        System.out.println("输出创建好的链表:");
        reverseLink.printLink(head);
        System.out.println();
        System.out.println("打印后的单链表:");
        ListNode result = insertionSortList(head);
        reverseLink.printLink(result);
        System.out.println();

    }

    //构建链表
    private static ListNode createLink() {
        ListNode node_1 = new ListNode(4);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(1);
        ListNode node_4 = new ListNode(3);
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

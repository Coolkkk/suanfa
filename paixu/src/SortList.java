
/**
 *  排序链表
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 *  O(n log n) 时间复杂度和常数级空间复杂度
 *  归并排序： 分治思想，每次把链表分成一半，一直细分，到一定细度之后，再归并就好了
 *      递归法（自上向下）：空间复杂度是 O(logn)
 *      迭代法（自下向上）：空间复杂度是 O(1)
 */


public class SortList {

    /**
     * 递归法
     * 1.判断（链表为空或者只有一个元素的时候直接返回）
     * 2.用快慢指针找到链表中间位置，分成左右两部分
     * 3.递归
     * 4.归并（合并有序链表）
     *
     */
    public static ListNode sortList1(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode fast = head.next , slow = head;
        if(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightHead = slow.next;
        slow.next= null ;
        ListNode right =  sortList1(rightHead);
        ListNode left =   sortList1(head);
        return merge (left , right);
    }

    public static ListNode merge (ListNode left , ListNode right){
        ListNode pre = new ListNode(0) , tmp = pre;
        while(left!=null && right != null){
            if(left.val<right.val){
                tmp.next=left;
                left=left.next;
            }else {
                tmp.next=right;
                right=right.next;
            }
            tmp = tmp.next;
        }
        tmp.next=left==null?right:left;
        return pre.next;
    }


    /**
     * 迭代法
     *  1.链表的长度  lengthForList
     *  2.断表  cutList  （切掉链表l的前n个节点，并返回后半部分的链表头。
     *                      比如原来链表是dummy->1->2->4->3->NULL
     *                      cutList(l,2)的操作造成：
     *                      dummy->1->2->NULL
     *                      4->3->NULL）
     *  3.合并有序链表 mergeList
     *
     *
     */
    public static ListNode sortList(ListNode head) {
        ListNode p = new ListNode(0); p.next=head ; //定义哨兵节点
        int length = lengthForList(head); //获取链表长度
        for(int i = 1;i<length ;i*=2){  //依次将链表分成1块，2块，4块...
            //每次变换步长，pre指针和cur指针都初始化在链表头
            ListNode pre1 = p;
            ListNode cur1 = p.next;
            while(cur1!=null){
                ListNode h1 = cur1;  //第一部分头 （第二次循环之后，cur为剩余部分头，不断往后把链表按照步长step分成一块一块...）
                ListNode h2 = cutList(h1,i); //第二部分头
                cur1 = cutList(h2,i); //剩余部分的头
                ListNode temp = mergeList(h1,h2); //将一二部分排序合并
                pre1.next=temp;  //将前面的部分与排序好的部分连接
                while(pre1.next!=null){
                    pre1=pre1.next;  //把pre指针移动到排序好的部分的末尾
                }
            }
        }
        return p.next;
    }

    public static int lengthForList(ListNode head){
        ListNode tmp = head;
        int count = 0;
        while(tmp!=null){
            tmp=tmp.next;
            count++;
        }
        return count;
    }

    public static ListNode cutList(ListNode head , int node){
        if(head==null) return null;
        ListNode cur = head;
        for(int i = 1 ; i<node && cur.next!=null;i++){
            cur = cur.next;
        }
        ListNode right = cur.next;
        cur.next=null;
        return right;

    }

    public static ListNode mergeList(ListNode h1, ListNode h2){
        ListNode pre = new ListNode(0) , tmp = pre;
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                tmp.next=h1;
                h1=h1.next;
            }else{
                tmp.next=h2;
                h2=h2.next;
            }
            tmp=tmp.next;
        }
        tmp.next=h1==null?h2:h1;
        return pre.next;
    }

    //测试
    public static void main(String[] args) {
        SortList reverseLink = new SortList();
        ListNode head = SortList.createLink();
        System.out.println("输出创建好的链表:");
        reverseLink.printLink(head);
        System.out.println();
        System.out.println("打印后的单链表:");
        ListNode result = sortList(head);
        reverseLink.printLink(result);
        System.out.println();


    }

    //构建链表
    private static ListNode createLink() {
        ListNode node_1 = new ListNode(-1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(0);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        return node_1;
    }

    //打印输出链表
    private static  void printLink(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ——> ");
        }
    }

}

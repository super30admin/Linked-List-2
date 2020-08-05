//time complexity : O(1)
//space complexity: O(1)
//executed on leetcode: not on leetcode

public class DeleteNodeWithoutHead{
    class ListNode {
        int val;
        ListNode next;
        ListNode(final int x) {
            val = x;
            next = null;
        }
        void delete(ListNode node)
        {   if(node.next==null) node=null;
            else{
                node.val = node.next.val;
            node.next=node.next.next;    
            }
        }
        public void main(final String[] args) {
            final ListNode head = new ListNode(1);
            final ListNode N2 = new ListNode(2);
            final ListNode N3 = new ListNode(3);
            final ListNode N4 = new ListNode(4);
            final ListNode N5 = new ListNode(5);
            final ListNode N6 = new ListNode(6);
            head.next = N2;
            N2.next = N3;
            N3.next = N4;
            N4.next = N5;
            N5.next =N6;
            delete(N4);
        }
   }}
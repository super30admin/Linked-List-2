//Time Complexity: O(n)
//Space Complexity:O(n) because of recusrion to reverse
/*Approach 
1.Traversing to find the middle of the list
2.Making reverse of the second half
3.merging both the list taking one node from each
*/
public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
   }
   public void reorderList(ListNode head) {
       if(head == null || head.next == null) return;
       ListNode slow = head;
       ListNode fast = head.next;
       while(fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }
       fast = slow.next;
       slow.next = null;
       slow = head;
       fast = reverse(fast);
       ListNode curr;
       while(fast != null){
           curr = slow.next;
           slow.next = fast;
           fast = fast.next;
           slow.next.next = curr;
           slow = curr;
       }
   }

   public ListNode reverse(ListNode head){
       if(head == null || head.next == null) return head;
       ListNode rev = reverse(head.next);
       head.next.next = head;
       head.next = null;
       return rev;
   }
   public static void main(String args[]){
    ListNode newNode = new ListNode(1);
    ListNode n1 = new ListNode(2);
    ListNode n2 = new ListNode(3);
    ListNode n3 = new ListNode(4);
    ListNode n4 = new ListNode(5);
    newNode.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    ReorderList obj = new ReorderList();
    obj.reorderList(newNode);
    while(newNode != null){System.out.print(newNode.val+" "); newNode= newNode.next;}

   }
}
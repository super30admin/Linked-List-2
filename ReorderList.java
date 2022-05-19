class ReorderList{
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static  void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = reverseList(slow);
        fast = head;
        ListNode tmp;
        while(slow.next != null){
          tmp = fast.next;
          fast.next = slow;
          fast = tmp;

          tmp = slow.next;
          slow.next = fast;
          slow = tmp;
        }
    }
    static public ListNode reverseList(ListNode head) {
        ListNode prev = null; 
        ListNode current = head; 
        ListNode next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        head = prev; 
        return head;
    }

    private static void printList(ListNode head){
        while(head!= null){
            System.out.print(head.val +" -> ");
            head = head.next;
        }
        return;
    }
    public static void main(String[] args) {
        ReorderList.ListNode head = new ListNode();
        head.val = 1;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        ReorderList.reorderList(head);
        printList(head);
    }
}

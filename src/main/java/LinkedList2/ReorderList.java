package LinkedList2;

/**
 * Time Complexity O(N)
 * Space O(1)
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next;
    }
  }

public class ReorderList {
    public static void main(String[] args) {
        ReorderList ro = new ReorderList();

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next = new ListNode(3);
        root.next = new ListNode(4);
        root.next = new ListNode(5);


        System.out.println("Before");
        ro.printList(root);
        //Reordering:
        ro.reorderList(root);
        System.out.println("END");
        ro.printList(root);
    }

    public void printList(ListNode head) {
        System.out.println("Reversed Linked List : ");
        ListNode temp = head;
        while( temp!= null ){
            System.out.print("Node : "+temp.val+ " ");
            temp = temp.next;
        }
        System.out.println( "\n");
    }

    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!= null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode ll2 = slow.next;

        // setting the second node to null;
        slow.next = null;
        ll2 = reverse(ll2);
        ListNode trav2 = ll2;
        slow = head;

        while(trav2 != null && slow != null) {

            ListNode temp = slow.next;
            ListNode temp2 = trav2.next;
            slow.next = trav2;
            trav2.next = temp;
            slow = temp;
            trav2 = temp2;
        }

    }

    public ListNode reverse(ListNode node) {

        if(node == null || node.next == null) {
            return node;
        }

        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}

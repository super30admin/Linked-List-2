// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Y

/* 1. split the list from middle
    2. reverse the second list
    3. merge both list
*/
public class Reorder {
    
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null || head.next.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }    
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        while(fast!=null)
        {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
          
            curr = temp;
        }
       
        return prev;
    }

    public static void main(String args [])
    {
        Reorder list = new Reorder();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
      
 
     
        list.printList(node);
        list.reorderList(node);
        System.out.println("After Reorder");
        list.printList(node);
    
    
    }

    void printList(ListNode node)
    {
        while (node != null) {
            System.out.println(node.val + " ");
            node = node.next;
        }
    }
}

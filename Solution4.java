// Time complexity: O(M + N), where M is the number of nodes in linked list 1 and N is the number of nodes in linked list 2.
// Space complexity: O(1)

public class Solution4 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // count the number of nodes in linked list 1
        int m = 0;
        ListNode ha = headA;
        while(ha != null) {
            m++;
            ha = ha.next;
        }
        
        // count the number of nodes in linked list 2
        int n = 0;
        ListNode hb = headB;
        while(hb != null) {
            n++;
            hb = hb.next;
        }
        
        ha = headA;
        hb = headB;
        // move pointers till the count of nodes is equal
        if(m>n) {
            while(m!=n) {
                m--;
                ha = ha.next;
            }
        }
        else {
            while(m!=n) {
                n--;
                hb = hb.next;
            }
        }
        
        // move pointers till they are same
        while(ha!=hb) {
            ha = ha.next;
            hb = hb.next;
        }
        
        return ha; 
    }
}
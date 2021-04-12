//reorder list
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
we reorder in three steps Fist we find the middle of the whole list. 
2nd step, reverse the second half of the list
3rd step merge both the lists by taking one of first half and another of second half which is reversed
*/
public class Problem2 {
    public static void main(String[] args){
        Problem2 p = new Problem2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        p.reorderList(head);
        while(head != null){
            System.out.print(" " +head.val);
            head = head.next;

        }
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        //find middle 
        ListNode fast = head;
        ListNode slow = head;
       
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse whatever is after slow
        
         
        fast = reverse(slow.next);
        //cut the link 
        slow.next = null;
        //merge the lists
        slow = head;
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
            
        }
        
        
    }
    public ListNode reverse(ListNode head){
        if(head == null)
            return head;
        ListNode curr = head;
        ListNode next = head;
        ListNode prev = null;
        while(curr != null){
            next = curr.next; //4
            curr.next = prev; //null
            prev = curr; //3
            curr = next; //4
            // next = next.next;
            
        }
        head = prev;
        return head;
    }
}
    


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
//time- o(n)
//space-o(1)
//passed in leetcode-yes
class Solution {
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null) return;
        
        //find midpoint       //o(n)
        ListNode walker = head;
        ListNode runner = head;
        
        while(runner.next!=null && runner.next.next!=null)
        {
            walker= walker.next;
            runner= runner.next.next;        
        }
        
        //reverse secondhalf       //o(logn) 
        runner = reverse(walker.next);
        walker.next= null;
        walker=head;
        
        
        //merge
        ListNode curr1;
        ListNode curr2;
                
        while(runner!=null)
        {
            curr1= walker.next;
            curr2= runner.next;
            
            walker.next = runner;
            runner.next= curr1;
                
            runner= curr2;
            walker = curr1;           
            
      }
        
        
    }
    
    
    
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null; //to make the list tail point to null
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;//store curr.next, as it will change in below steps
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
}
}
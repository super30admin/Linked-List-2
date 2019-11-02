


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode first=head, last=head, temp;
        Stack<ListNode> list = new Stack<>();
        
        while(last!= null){
            System.out.println(last.val);
            list.add(last);
            last=last.next;
        }
        // last = stack.top();
        
        while(first!= last){
            
            last = list.pop();
            System.out.print("first.val"+first.val+" ");
            System.out.print("last val"+last.val+" ");
           
            temp = first.next;
            last.next = first.next;
            first.next= last;
            first = temp;
        }
        last.next = null;
                
        while(head != null){
            System.out.println("head val"+ head.val + " " );
            head=head.next;
        }
        
    }
}

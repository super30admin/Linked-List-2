// Time Complexity:  O(max(m, n))
// Space Complexity: O(1)

public class Solution 
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1 != cur2)                                 // if both at same node or null
        {
            cur1 = cur1 == null ? headB : cur1.next;        // if only cur1 is null then rebase it to headB
            cur2 = cur2 == null ? headA : cur2.next;        // if only cur2 is null then rebase it to headA
        }
        return cur1;
    }
  
  
//     // ******************** Another Method ******************** 
  
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         int lenA = getLength(headA);                                            
//         int lenB = getLength(headB);
//         int diff = Math.abs(lenA-lenB);
        
//         ListNode first = lenA > lenB ? headA : headB;                           // first will have head of longer LinkedList
//         ListNode second = first == headA ? headB : headA;                       // second will have head of another LinkedList
        
//         while(diff > 0) {                                                       // moving first upto the difference between both LinkedLists
//             diff--;
//             first = first.next;
//         }
//         while(first != second) {                                                // running loop upto we get intersection
//             first = first.next;
//             second = second.next;
//         }
//         return first;                                                       
//     }
    
//     // Getting length of LinkedLists using this method
//     private int getLength(ListNode head) {
//         int len = 0;    
//         while(head != null) {
//             len++;
//             head = head.next;
//         }
//         return len;
//     }
  
}

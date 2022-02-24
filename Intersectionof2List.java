/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 
 listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
 
  4 1 
      8 4 5
5 6 1  

skip (Math.abs(lengthOfB-lengthOfA))
 
 
TC -  O(m) + O(n) + O(m) + O(n)
 
 2 * O(m) + 2* O(n)
 2 O(m+n)
 
 SC - O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lengthOfA = lengthOfList(headA);
        int lengthOfB = lengthOfList(headB);
        
        ListNode first = lengthOfA > lengthOfB ? headA : headB;
        ListNode second = first == headA ? headB : headA;
        int diff = Math.abs(lengthOfA - lengthOfB);
        
        while (diff > 0)
        {
            first = first.next;
            diff--;
        }
        
        while(first != null && second != null)
        {
            if (first == second)
            {
                return first;
            }
            
            first = first.next;
            second = second.next;
        }
        
        return null;
    }
    
    public int lengthOfList(ListNode head)
    {
        int count = 0;
        ListNode current = head;
        
        while(current != null)
        {
            current = current.next;
            count++;
        }
        
        return count;
    }
}
// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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
 */

// 2Pass solution
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         if(headA == null || headB == null)
//             return null;
        
//         int lengthA=length(headA), lengthB=length(headB);
//         if(lengthA > lengthB)
//             headA=move(headA, lengthA-lengthB);
//         else
//             headB=move(headB, lengthB-lengthA);
        
//         while(headA != null || headB != null)
//         {
//             if(headA == headB)
//             {
//                 return headA;
//             }
//             headA=headA.next;
//             headB=headB.next;
//         }
//         return null;   
//     }
//     private int length(ListNode node)
//     {   
//         int count=1;
//         while(node!=null)
//         {
//             node=node.next;
//             count++;
//         }
//         return count;
//     }
//     private ListNode move(ListNode node, int x)
//     {
//         while(x > 0)
//         {
//             node=node.next;
//             x--;
//         }
//         return node;
//     }
// }

//1Pass solution
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cursorA=headA, cursorB=headB;
        while(cursorA != cursorB)
        {
            if(cursorA == null)
                cursorA=headB;
            else
                cursorA=cursorA.next;
                
            if(cursorB == null)
                cursorB=headA;
            else
                cursorB=cursorB.next;
        }
        return cursorA;
    }
}
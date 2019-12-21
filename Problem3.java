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

/**
LeetCode Submitted : YES
Time Complexity : O(Sizeof(A) + Sizeof(B))
Space Complexity : O(Sizeof(A) + Sizeof(B))

The idea is to use Set to store the element and then check if it exists or not
**/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> s  = new HashSet<>();
        while(headA != null){   
            if(s.contains(headA)){
                return headA;
            }
            else{
                s.add(headA);
                headA = headA.next;
            }
        } 
            
        while(headB != null){
            if(s.contains(headB)){
                //System.out.println(headB.val);
                return headB;
            
            }
            else{
                s.add(headB);
                headB = headB.next;
            }
        }
            
        return null;
    }
}

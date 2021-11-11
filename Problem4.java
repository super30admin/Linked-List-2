// Leetcode 160 - Intersection of two LL
// Time - O(n + m) n - Len of LL1 and m - Len of LL2
// Space - O(m)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int len1 = 0;
        int len2 = 0;
        
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        
        while(ptr1 != null){
            
            len1++;
            ptr1 = ptr1.next;
        }
        
        while(ptr2 != null){
            
            len2++;
            ptr2 = ptr2.next;
        }
        while(len1 > len2){
            
            headA = headA.next;
            len1--;
        }
        
        while(len2 > len1){
            
            headB = headB.next;
            len2--;
        }
        
        while(headA != null && headB != null){
            
            if (headA == headB){
                return headA;
            }
            
            headA = headA.next;
            headB = headB.next;
            
        }
        
        return null;
    }
}
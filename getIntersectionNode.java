// Time Complexity : O(n), where n is the number of nodes in the list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Find the length of both the lists.
 * 2. Move the pointer of the longer list by the difference of the lengths of the two lists.
 * 3. Move both the pointers until they meet.
 * 4. Return the node where they meet.
 */

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmp1 = headA,tmp2=headB;
        
        int lengthA = 0;
        while(tmp1!=null){
            lengthA++;
            tmp1 = tmp1.next;
        }
        
        int lengthB = 0;
        while(tmp2!=null){
            lengthB++;
            tmp2 = tmp2.next;
        }
        
        
        tmp1 = headA;tmp2=headB;
        if(lengthA>=lengthB){
            for(int i=0;i<(lengthA-lengthB);i++){
                tmp1 = tmp1.next;
            }
        }else{
            for(int i=0;i<(lengthB-lengthA);i++){
                tmp2 = tmp2.next;
            }
        }
        
        while(tmp1!=null && tmp2!=null){
            if(tmp1==tmp2){
                return tmp1;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        
        return null; 
    }
}
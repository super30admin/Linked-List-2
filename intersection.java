// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la=0;
        int lb=0;
        ListNode lista=headA;
        ListNode listb=headB;
        
        while(lista!=null){
            lista=lista.next;
            la++;
        }
        
        while(listb!=null){
            listb=listb.next;
            lb++;
        }
        
        while(la>lb){
            headA=headA.next;
            la--;
        }
        while(lb>la){
            headB=headB.next;
            lb--;
        }
        
        while(headA!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
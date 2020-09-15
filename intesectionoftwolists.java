// Time Complexity :O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        int sizeA = 0;
        int sizeB = 0;
        while(a != null ){
            sizeA++;
            a=a.next;
        }
        
        while(b != null ){
            sizeB++;
            b=b.next;
        }
        a = headA;
        b = headB;
        int diff = Math.abs(sizeA - sizeB);
        
        if(sizeA > sizeB){
            while(diff -- > 0){
                a=a.next;
            }
        }else if (sizeA < sizeB) {
            while(diff -- >0){
                b = b.next;
            }
        }
        
        while(a != null){
            if(a == b) {
                return b;
            }
            a=a.next;
            b=b.next;
        }
        return null;
    }
}

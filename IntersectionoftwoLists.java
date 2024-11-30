// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //ListNode res = 
        int lenA = getSize(headA);
        int lenB = getSize(headB);
        
        for(int i=0;i<Math.abs(lenA-lenB);i++){
            if(lenA > lenB){
                headA = headA.next;
            }
            else
            {
                headB = headB.next;
            }
        }
        while(headA !=null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    private int getSize(ListNode node){
        int cnt = 0;
        ListNode head = node;
        while(head  != null){
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}
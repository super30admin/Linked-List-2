package LinkedList2;
// Time Complexity : O(max(m, n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


import LinkedList1.ListNode;

// Your code here along with comments explaining your approach
class InterectionOf2LL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;
        ListNode curr = headA;
        while(curr != null){
            l1++;
            curr = curr.next;
        }
        curr = headB;
        while(curr != null){
            l2++;
            curr = curr.next;
        }
        int count = 0;
        if(l1 > l2){
            while(count < Math.abs(l1-l2)){
                headA = headA.next;
                count++;
            }
        } else {
            while(count < Math.abs(l1-l2)){
                headB = headB.next;
                count++;
            }
        }
        while(headA != null && headB != null){
            if(headA==headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
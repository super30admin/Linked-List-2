// Problem 160. Intersection of Two Linked Lists
// Time Complexity : O(n+m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        ListNode curr = headA;
        while(curr != null){
            curr = curr.next;
            l1++;
        }
        int l2 = 0;
        curr = headB;
        while(curr != null){
            curr = curr.next;
            l2++;
        }
        while(l1>l2){
            headA = headA.next;
            l1--;
        }
        while(l2>l1){
            headB = headB.next;
            l2--;
        }
        // move both by 1x speed;
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

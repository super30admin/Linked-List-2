// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
public class intersectionOfLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currNode = headA;
        int headALength = 0;
        while(currNode.next != null){
            currNode = currNode.next;
            headALength++;
        }
        currNode = headB;
        int headBLength = 0;
        while(currNode.next != null){
            currNode = currNode.next;
            headBLength++;
        }
        while(headBLength > headALength){
            headB = headB.next;
            headBLength--;
        }
        while(headALength > headBLength){
            headA = headA.next;
            headALength--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

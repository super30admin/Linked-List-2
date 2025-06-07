// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        int aL = 0;
        int bL= 0;
        while(node1 != null){
            node1 = node1.next;
            aL++;
        }
        ListNode node2 = headB;
        while(node2 != null){
            node2 = node2.next;
            bL++;
        }
        int count = 0;
        node1 = headA;
        node2 = headB;
        while(aL > bL){
            node1 = node1.next;
            aL--;
        }
        while(bL > aL){
            node2 = node2.next;
            bL--;
        }
        while(node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }
}

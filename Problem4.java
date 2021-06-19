
// Time Complexity - O(N + M)
// Space Complexity - O(N)


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> hashSet = new HashSet<ListNode>();


        while(headB != null) {

            hashSet.add(headB);
            headB = headB.next;
        }

        while(headA != null) {

            if(hashSet.contains(headA)) {

                return headA;

            }

            headA = headA.next;

        }


        return null;

    }
}
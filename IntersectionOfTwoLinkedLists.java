// Time complexity: O(N)
// Space complexity: O(1)

// Approach: calculate the length of each list. Then bring the two pointers of each list together such that they are both equidistant from the intersection point. If list A length is 10 and list B length is 12, then bring the pointer of list B two steps ahead such that they both start from the same point

// Brute force: a brute force for this would be to use a hashset. Add all nodes of list A to hashset. Then using a pointer iterate list b and if you find a node in the hashset, that is the intersection point. This will use O(N) space.

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // find length of first list
        ListNode curr = headA;
        int lengthA = 0;
        while (curr != null) {
            lengthA++;
            curr = curr.next;
        }
        int lengthB = 0;
        curr = headB;
        while (curr != null) {
            lengthB++;
            curr = curr.next;
        }
        int diff = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            while (diff != 0) {
                diff--;
                headA = headA.next;
            }
        }
        else {
            while (diff != 0) {
                diff--;
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}
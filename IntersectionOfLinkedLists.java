// Brute force using Set O(n) time, O(n) space
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         Set<ListNode> set = new HashSet<>();

//         while (headA != null) {
//             set.add(headA);
//             headA = headA.next;
//         }

//         while (headB != null) {
//             if (set.contains(headB)) {
//                 return headB;
//             }
//             headB = headB.next;
//         }
//         return null;
//     }
// }

// O(n) time, O(1) space
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        int lenA = 0;
        int lenB = 0;

        while (currA != null) {
            currA = currA.next;
            lenA++;
        }

        while (currB != null) {
            currB = currB.next;
            lenB++;
        }

        currA = headA; // reset back to traverse again
        currB = headB; // reset back to traverse again

        while (lenA > lenB) {
            currA = currA.next;
            lenA--;
        }

        while (lenB > lenA) {
            currB = currB.next;
            lenB--;
        }

        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}
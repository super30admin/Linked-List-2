//Brute Force
// Time Complexity: O(m + n)
// Space Complexity: O(m + n)
 public class Solution {
     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         HashSet<ListNode> set = new HashSet<>();


         while(headA!=null && headB != null) {
             if(headA!=null) {
                 if(set.contains(headA)) {
                     return headA;
                 }
                 set.add(headA);
                 headA = headA.next;
             }

             if(headB!=null) {
                 if(set.contains(headB)){
                     return headB;
                 }
                 set.add(headB);
                 headB = headB.next;
             }
         }
     return null;
     }
 }

// Time Complexity: O(m+n)
// Space Complexity: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA, l2 = headB;

        while(l1 != null || l2 != null) {
            if(l1 == l2) {
                return l1;
            }

            if(l1 == null) {
                l1 = headA;
                continue;
            }

            if(l2 == null) {
                l2 = headB;
                continue;
            }

            l1 = l1.next;
            l2 = l2.next;

        }

        return null;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class intersection_ll {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        while(curr1!=null){
            set.add(curr1);
            curr1 = curr1.next;
        }
        while(curr2!=null){
            if(set.contains(curr2)){
                return curr2;
            }
            curr2=curr2.next;
        }
        return null;
    }
}

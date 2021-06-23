import java.util.HashMap;

/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;;
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode ptrA=headA,ptrB=headB;
        while(ptrA!=null){
            map.put(ptrA,ptrA.val);
            ptrA=ptrA.next;
        }
        while(ptrB!=null){
            if(map.containsKey(ptrB)) return ptrB;
            ptrB=ptrB.next;
        }
        return null;


    }
}

TC: O(m+n)
SC: O(m) or O(n)

Runtime: 8 ms, faster than 13.92% of Java online submissions for Intersection of Two Linked Lists.
Memory Usage: 39.2 MB, less than 25.00% of Java online submissions for Intersection of Two Linked Lists.




public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> list = new HashSet<>();
        while(headA!= null){
            list.add(headA);
            headA = headA.next;
        }
        
        while(headB!=null){
            if(list.contains(headB)){
            return headB;
            }
            headB = headB.next;
        }
        
      return null;  
    }
}



// O(n+m) time || O(m) space
// where n is the number of nodes in linkedlist headA , and m is the size of the hashtable
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        Set<ListNode> set = new HashSet<ListNode>();
        
        while(headB!=null){
           
            set.add(headB);
            headB=headB.next;
            
        }
        
        
        while(headA!=null){
            if(set.contains(headA)){
            return headA;
            }
            
            headA=headA.next;
        }
        
        return null;
    }
}

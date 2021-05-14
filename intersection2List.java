// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class intersection2List {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA==null || headB==null)
            return null;
        
        ListNode pointer_a=headA;
        ListNode pointer_b=headB;
        
        while(pointer_a!=pointer_b){
            
            if(pointer_b!=null){
                pointer_b=pointer_b.next;
            }else{
                pointer_b=headA;
            }
            
            if(pointer_a!=null){
                pointer_a=pointer_a.next;
            }else{
                pointer_a=headB;
            }
        }
        return pointer_b;
        
    }
    
}

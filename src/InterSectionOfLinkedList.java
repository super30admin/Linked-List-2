// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * Two pointers, traverse both lists till end, find difference between their length, traverse larger list by that length
 * now start traversing both pointers one step at time and check for similarity of the nodes
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 */
public class InterSectionOfLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	       
        int cnt1 = 0, cnt2 = 0;
        
        ListNode currNode = headA;
        
        while(currNode != null) {
            cnt1++;
            currNode = currNode.next;
        }
        
        currNode = headB;
        
        while(currNode != null) {
            cnt2++;
            currNode = currNode.next;
        }
        
        ListNode currA = headA, currB = headB;
        if(cnt1 > cnt2) {
            int diff = cnt1 - cnt2;
            
            while(diff > 0) {
                currA = currA.next;
                diff--;
            }
        }else if(cnt2 > cnt1){
            int diff = cnt2 - cnt1;
            
            while(diff > 0) {
                currB = currB.next;
                diff--;
            }
        }
        
        while(currA != null && currB != null){
            if(currA == currB) return currA;
            
            currA = currA.next;
            currB = currB.next;
        }
        
        return null;
    }
}

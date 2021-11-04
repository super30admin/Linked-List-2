// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class NodeIntesection {
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        int len1=0;
	        int len2=0;
	        ListNode currA=headA;
	        ListNode currB=headB;
	        while(currA!=null){
	            currA=currA.next;
	            len1++;
	        }
	        
	        while(currB!=null){
	            currB=currB.next;
	            len2++;
	        }
	        int diff=0;
	        while(len1>len2){
	            headA=headA.next;
	            len1--;
	        }
	        
	        while(len2>len1){
	            headB=headB.next;
	            len2--;
	        }
	        
	        while(headA!=null && headB!=null){
	            if(headA==headB){
	                return headA;
	            }
	            headA=headA.next;
	            headB=headB.next;
	        }
	        
	        return null;
	  }
	 
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}

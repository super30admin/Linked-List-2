// Time Complexity : O(nm)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import com.util.customlist.ListNode;

public class IntersectionOfTwoLinkedlists {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0; int lenB = 0;
       // if(headA == null || headB == null) return null;
        
        ListNode curr = headA;
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;
        }
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
	
	public static void main(String[] args) {
		ListNode oneA = new ListNode(4);
		ListNode twoA = new ListNode(1);
		ListNode threeA = new ListNode(8);
		ListNode fourA = new ListNode(4);
		ListNode fiveA = new ListNode(5);
		oneA.next = twoA;
		twoA.next = threeA;
		threeA.next = fourA;
		fourA.next = fiveA;
		
		ListNode oneB = new ListNode(5);
		ListNode twoB = new ListNode(6);
		ListNode threeB = new ListNode(1);
		ListNode fourB = new ListNode(8);
		ListNode fiveB = new ListNode(4);
		ListNode sixB = new ListNode(5);
		oneB.next = twoB;
		twoB.next = threeB;
		threeB.next = fourB;
		fourB.next = fiveB;
		fiveB.next = sixB;
		
		System.out.println(IntersectionOfTwoLinkedlists.getIntersectionNode(oneA, oneB));
		
	}
	
}

// TC: O(M+N) where M represents the nodes of headA and N represents nodes in headB
// SC: O(1) since we are using constant space.


// We are checking for the reference of the 2 objects, if the references are not equal, we move ahead in the list, . If we reach, we change the references to another node
// and if another node reaches null, we assign that to another.  We check in similar way until we find our intersection
public class IntersectionLL {

	public ListNode Intersect(ListNode headA, ListNode headB) {
		
		ListNode a = headA;
		ListNode b = headB;
		
		if(headA==null || headB == null)
			return null;
		
		while(a!=b) {
		
			a = a==null? headB : a.next;
			b = b==null? headA : b.next;
		}
		return a;
	}
	
	public static void main(String[] args) {
		
		IntersectionLL inll = new IntersectionLL();
		ListNode headA = new ListNode(1);
		ListNode headB = new ListNode(2);
		headA.next = new ListNode(3);
		headB.next = new ListNode(4);
	}
}

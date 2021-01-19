// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on GFG : Yes
// Any problem you faced while coding this : No

import com.util.customlist.ListNode;

public class DeleteWithoutHeadPointer {
	public static ListNode deleteNode(ListNode node)
    {
		//List<ListNode> ln = new ArrayList<>();
         // Your code here
         node.val = node.next.val;
         //node.next = node;
         node.next = node.next.next;
		return node;
    }
	
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		one.next = two;
		
		System.out.println(DeleteWithoutHeadPointer.deleteNode(one).val);
	}
	
}

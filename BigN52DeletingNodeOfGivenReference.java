//Time complexity is O(1) as we are just swaping and deleting between two nodes
//space complexity is O(1) as we are not using any extra space.
//This solution is submitted on GeekforGeek

public class BigN52DeletingNodeOfGivenReference {
	
	public void deleteNode(ListNode node)
    {
        node.val = node.next.val;
        node.next = node.next.next;
   }
}

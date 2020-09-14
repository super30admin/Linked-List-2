class DeleteWithoutHead
{
	// Time Complexity: O(1)  - node is already given
	// Space Complexity: O(1)
    void deleteNode(Node node)
    {
    	//	Copying the contents of next node(3) to the given node(2) and delete the next(3)
    	//		1 -> 2 -> 3 -> 4
    	//		1 -> 3 -> 3 -> 4
    	// 		1 -> 3 -> 4
         if(node.next != null){
             node.data = node.next.data;
             node.next = node.next.next;
         } else 
            node = null;
    }
}

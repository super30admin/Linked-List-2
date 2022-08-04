// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


func deleteNode(node *Node){
	node.next.data = node.data
	node.next = node.next.next
}

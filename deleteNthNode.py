
#Time Complexity - O(1) as we reach the node directly
#Space complexity - O(1) as we do not store or use other data structure


class DeleteNodeWithoutHead:
	deleteNode(node):
		if node != None:
			next = node.next
			if next != None:
				node.data = next.data
				node.next = next.next
			else:
				node = None
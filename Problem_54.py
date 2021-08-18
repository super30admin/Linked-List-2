class Solution(object):

	def deleteNodeGivenNode(self, node):
		node.val = node.next.val
		node.next = node.next.next

%TC: O(1)
%SC: O(1)
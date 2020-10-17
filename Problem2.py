# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
	def deleteNodeGivenNode(self, node):
		# Time complexity : constant time
		# Space complexity : constant space. Actually no space used
		# make the value of current node as value of the next node and make current node point to the next of the next node
		node.val = node.next.val
		node.next = node.next.next
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
	def reorderList(self, head):
		# Time Complexity : O(n) where n is the number of elements in the list
		if head == None or head.next == None:
			return
		fast = head.next
		slow = head
		# finding the mid point of the list
		while fast != None and fast.next != None:
			fast = fast.next.next
			slow = slow.next
		head2 = slow.next # second half of the list
		slow.next = None # Point the last element of the list to None

		# Reverse the second half of the list
		old = new = None
		cur = head2
		while cur != None:
			new = cur.next
			cur.next = old
			old = cur
			cur = new
		head2 = old

		# combine both the lists
		while head2 != None:
			temp = head.next
			temp2 = head2.next
			head.next = head2
			head2.next = temp
			head = temp
			head2 = temp2
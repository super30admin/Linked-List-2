class Solution(object):

	def reorderList(self, head):

		if head == None or head.next == None:

			return

		fast = head.next

		slow = head

		while fast != None and fast.next != None:

			fast = fast.next.next
			slow = slow.next

		head2 = slow.next 

		slow.next = None 

		old = new = None

		cur = head2

		while cur != None:

			new = cur.next

			cur.next = old

			old = cur

			cur = new

		head2 = old

		while head2 != None:

			temp = head.next

			temp2 = head2.next

			head.next = head2

			head2.next = temp

			head = temp

			head2 = temp2

%TC : O(n)
%SC : O(1)
# Time: O(n)
# Space: O(1)

# calculate the middle of the linked list (let the slow pointer be on a node before the mid)
# Have a variable to store the head of the second half and break the two halves by setting the slow.next to None
# Then reverse the second half
# Now we will have to merge the first and second half so have two heads for each linked list
# and then keep on manipulating the nodes accordingly
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # Calculate the middle
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        # To have the head for the second half and break the two halfs
        second_half_head = slow.next
        slow.next = None
        
        # Reverse the second half
        prev = None
        curr = second_half_head
        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        # merging the two halfs (which were 2 different linked lists)
        head2 = prev
        head1 = head
        while head2 != None:
            temp1 = head1.next
            head1.next = head2

            temp2 = head2.next
            head2.next = temp1

            head1 = temp1
            head2 = temp2
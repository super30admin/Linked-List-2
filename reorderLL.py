# Approach: Here we first split the linked list into to finding the mid point
# Then we reverse the second linked list 
# Reorder list by updating the pointers

# Time: O(N)
# Space: O(1) in place modification



# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:

        # null checks
        if head == None or head.next == None or head.next.next == None:
            return

        # To find mid point of Linked List

        slow = head
        fast = head

        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        # here we get slow as the mid point


        # Now reverse LL from next node from slow (ie slow.next) and reset fast to this reversed LL's head
        fast = self.reverse(slow.next)

        # Now break off connection from LL1 to LL2, and reset slow to head of LL1
        slow.next = None
        slow = head

        # Re order LL

        while fast != None:

            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverse(self, head):
        prev = None
        current = head
        fast = current.next

        while fast != None:

            current.next = prev
            prev = current
            current = fast
            fast = fast.next

        current.next = prev
        return current




        
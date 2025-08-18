# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
#time - o(n/2) + o(n/2) + 0(n)
#space - o(1)


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        if head == None:
            return None

        s = head
        f = head

        while f.next != None and f.next.next != None:
            s = s.next
            f = f.next.next

        fast = self.reverseLinklist(s.next)
        s.next = None

        slow = head
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverseLinklist(self, head: Optional[ListNode]) -> ListNode:

        if head == None:
            return None

        prev = None
        current = head
        fast = head.next

        while fast != None:
            current.next = prev
            prev = current
            current = fast
            fast = fast.next

        current.next = prev

        return current
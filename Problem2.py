# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow, fast = head, head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        #mid = slow. reverse from mid to end
        f = None
        s = slow.next
        slow.next = None
        while s:
            #f will be head
            temp = s.next
            s.next = f
            f = s
            s = temp
        head2 = f
        # print(head, "\n\n")
        # print(head2)
        headd = head
        while head2:
            temp = headd.next
            headd.next = head2
            temp2 = head2.next
            head2.next = temp
            headd =temp
            head2 = temp2
        



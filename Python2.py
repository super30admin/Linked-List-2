# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Reorder List

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

        second_half = self.reverse(slow.next)
        slow.next = None  

        first_half = head
        while second_half:
            temp1 = first_half.next
            temp2 = second_half.next

            first_half.next = second_half
            second_half.next = temp1

            first_half = temp1
            second_half = temp2

    def reverse(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev, curr = None, head
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev


    # ------------ -------------
    #     slow = head
    #     fast = head

    #     while fast != None and fast.next != None:
    #         slow = slow.next
    #         fast = fast.next.next

    #     fast = self.reverse(slow.next)
    #     slow.next = None
    #     slow = head
    #     while fast != None:
    #         temp = slow.next
    #         slow.next = fast
    #         fast = fast.next
    #         slow.next.next = temp
    #         slow = temp

    # def reverse(self, head):
    #     prev = None
    #     curr = head

    #     while curr != None:
    #         temp = curr.next
    #         curr.next = prev
    #         prev = curr
    #         curr = temp

    #     return prev
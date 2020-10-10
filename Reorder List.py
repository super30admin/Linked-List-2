# TC: O(N)
# SC: O(1)
# Yes, it ran on Leetcode
# Problems: Solved this afer attending the lecture, was not able to solve at first.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head):
        if not head:
            return None
        # 1. Find mid point
        # in 1->2->3->4->5->6 find 4
        slow = head
        fast = head
        while fast and fast.next:   # This works for even as well as odd LL
            slow = slow.next
            fast = fast.next.next
        sec = slow.next
        slow.next = None        # Important
        
        # 2. Reverse the second LL
        second = self.reverse(sec)
        
        # 3. Connect the two LL
        p1 = head
        p2 = second
        while p2:   # because 2nd LL is short       
            forw_p1 = p1.next
            forw_p2 = p2.next
            p1.next = p2
            p2.next = forw_p1
            p1 = forw_p1
            p2 = forw_p2
        # while second.next:        # elegant way
        #     first.next, first = second, first.next
        #     second.next, second = first, second.next
        return head
        
        
    def reverse(self, curr):
        prev = None
        while curr:
            forw = curr.next
            curr.next = prev
            prev = curr
            curr = forw
        return prev
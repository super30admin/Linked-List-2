# Time Complexity :  O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

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
        if head == None or head.next == None:
            return
        count = 0
        firstHalf = head
        while(firstHalf != None):
            firstHalf = firstHalf.next
            count += 1
        i = 0
        firstHalf = head
        while(i < count//2):
            firstHalf = firstHalf.next
            i += 1
        secondHalf = firstHalf.next
        firstHalf.next = None

        cur = secondHalf
        prev = None
        while(cur != None):
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp

        firstHalf = head
        secondHalf = prev
        while(secondHalf != None):
            temp = firstHalf.next
            firstHalf.next = secondHalf
            secondHalf = secondHalf.next
            firstHalf.next.next = temp
            firstHalf = temp


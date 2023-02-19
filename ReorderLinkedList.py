# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#All TC on leetcode passed

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        #Here we divide the L.L. into halves. We reverse the 2nd half of the L.L. 
        #Then we merge the 2 lists with alternating elements.
        #Time complexity - O(n)
        #Space complexity - O(1)

        slow = head
        fast = head

        #find mid
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        start = slow.next #start point of list to be reversed
        slow.next = None #last node of list before mid should point to null

        #Reversing the second half of list
        prev = None
        cur = start
        while cur:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp

        #merging the 2 lists
        first = head
        second = prev
        while second:
            temp1 = first.next
            temp2 = second.next
            first.next = second
            second.next = temp1
            first = temp1
            second = temp2
        
        return head
        
        
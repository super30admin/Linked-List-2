# Time Complexity: O(n)
# Space Complexity: O(1)

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        # Find mid using 2 pointers
        slow, fast = head, head

        while fast.next!=None and fast.next.next!=None: 
            slow=slow.next # 1x speed
            fast=fast.next.next # 2x speed

        #2. Reverse the 2nd half
        def reverseLL(head):
            if head==None or head.next==None:
                return head
            prev = None
            curr, fast = head, head.next
            while fast:
                curr.next = prev
                prev = curr
                curr = fast
                fast =  fast.next
            curr.next = prev
            return curr

        fast=reverseLL(slow.next) #reverse the 2nd half of LL
        slow.next=None #seperates the first half from 2nd half
        slow=head # resets head for first half

        #3. Join the 2 parts of LL
        while slow and fast:
            temp=slow.next
            slow.next=fast
            fast=fast.next
            slow.next.next=temp
            slow=temp

        return head

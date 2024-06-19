# Time Complexity :
# O(N)

# Space Complexity :  
# O(1)  



# Approach:
# This is combination of threee subproblems.
# 1. Find middle of linked list( using "slow" and "fast" pointers)
#    Break the slow node's next connection, and Reset the slow pointer to head
# 2. Reverse the linked list(from the middle's next, i.e slow's next)
#    Use the fast pointer to point to this reversed Linked list
# 3. Merge the linkedlists, pointed to by "slow" and "fast"

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
        if not head or not head.next:
            return

        # 1. Find the middle of LL
        slow = head
        fast = head
        while(fast.next and fast.next.next):
            slow = slow.next
            fast = fast.next.next
        print("Now, Middle of LL: ", slow.val)
        print("Now, Fast of LL: ", fast.val)

        # 2. Reverse LL from slow's next
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head

        # 3. Merge LL pointed by slow and fast
        while(fast):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp



        return head

    
    def reverse(self, head):
        if not head or not head.next:
            return head
        
        prev = None
        curr = head
        nextNode = curr.next

        while(nextNode):
            curr.next = prev
            prev = curr
            curr = nextNode
            nextNode = nextNode.next
        
        curr.next = prev
        return curr
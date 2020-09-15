"""
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

Time = O(n)
space : O(1)
Successfully excecuted on leetcode


Approach --
1. Iterate through the linked list till we reach the middle node.
2. After we have middle element, arrange mid to last node in reverse form
3. Merge the first half with second reversed half


"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Reorder:
    
    def reverse(self,head):
        prev = None
        curr_node = head
        while curr_node:
            next_node = curr_node.next
            curr_node.next = prev
            prev = curr_node
            curr_node = next_node
        return prev
    
    def merge(self,h1,h2):
        while h1:
            h1_next = h1.next
            h2_next = h2.next
            h1.next = h2
            if h1_next == None:
                break
            h2.next = h1_next
            h1 = h1_next
            h2 = h2_next
    
    def reorderList(self,head):
        if head and head.next is None:
            return head
        
        l1_head = slow = fast = head
        prev = 0
        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        
        if prev:
            prev.next = None
        l2_head = self.reverse(slow)
        self.merge(l1_head,l2_head)
        
        
        
        
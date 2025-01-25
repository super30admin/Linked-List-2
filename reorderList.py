# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    # TC : O(n)
    # SC : O(1)
    def reverse(self,head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        prev,cur,fast = None,head,head.next
        while fast != None:
            cur.next = prev
            prev = cur
            cur = fast
            fast = fast.next
        cur.next = prev
        return cur
    
    def merge(self,list1,list2):
            while list2:
                nextNode = list1.next
                list1.next = list2
                list1 = list2
                list2 = nextNode

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
            return head
        # 1. split list into 2 parts
        slow,fast = head,head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        # 2. reverse second half of list
        revp = self.reverse(slow.next)
        slow.next = None
        
        # 3. merge the 2 lists
        cur = head
        self.merge(cur,revp)
         
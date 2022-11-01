# Time Complexity - O(m + n)
# Space Complexity - O(1)
#Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        temp = headA
        
        while temp.next is not None:
            temp = temp.next

        temp.next = headA
        
        slow = fast = headB
        
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
            if fast == slow:
                break
         
        if fast == None or fast.next == None:
            temp.next = None
            return None
        
        slow = headB
        
        while fast != slow:
            slow = slow.next
            fast = fast.next
        temp.next = None
        return fast
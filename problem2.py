'''
143. Reorder List

TIME COMPLEXITY
1. split: O(N)
2. reverse: O(N)
3. merge: O(N)

SPACE COMPLEXITY
1. split: O(1)
2. reverse: O(1)
3. merge: O(1)

LEETCODE: Yes
DIFFICULTY: Nope, although I solved it after the class
'''

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
        if head.next == None or head.next.next == None:
            return head
        
        def split_list(head):
            
            slow = head
            tmp = slow
            fast = head.next
            
            while fast != None and fast.next != None:
                slow = slow.next
                fast = fast.next.next
            
            tmp2 = slow.next
            slow.next = None
            return tmp, tmp2
            
        
        def reverse(tmp):
            tmp2 = None
            p1 = tmp
            p2 = tmp.next
            
            while p2 != None:
                p1.next = tmp2
                tmp2 = p1
                p1 = p2
                p2 = p2.next
            
            p1.next = tmp2
            return p1          
            
        
        def merge(first, last):
            p1 = first
            tmp = first
            p3 = p1.next
            p2 = last
            
            while p3 != None:
                p1.next = p2
                p2 = p2.next
                p1.next.next = p3
                p1 = p3
                p3 = p3.next
            
            p1.next = p2
            # p1.next.next = p3
            
            return tmp
        
        # travel to mid and break into two lists
        first, last = split_list(head)
        
        # reverse the other half
        last = reverse(last)
        
        
        # stitch the both 
        head = merge(first, last)
        

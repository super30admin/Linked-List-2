# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#find length for listA and listB
#Iterate the longer list till both becomes equal
#iterate both in parallel, compare heads if they are equal or return None

#Space: O(1)
#Time:O(m+n)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        
        def length_list(root):
            count=0
            while(root):
                count+=1
                root=root.next
            return count
        
        len_a = length_list(headA)
        len_b = length_list(headB)
        if len_a>len_b:
            while(headA and len_a>len_b):
                headA=headA.next
                len_a-=1
        if len_b>len_a:
            while(headB and len_b>len_a):
                headB=headB.next
                len_b-=1
        while(headA and headB):
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next
        return None
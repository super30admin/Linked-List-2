# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# take elements in array
# go from right to left and stop when 2 elements are dissimilar
# return the first intersection (current l's or r's next val)
# TC and SC = O(n) and O(n)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        a, b = [], []
        curr = headA
        while curr:
            a.append(curr)
            curr = curr.next
        curr = headB
        while curr:
            b.append(curr)
            curr = curr.next
        i = len(a)-1
        j = len(b)-1
        inter = None
        if i == 0:
            if a[i] == b[j]:
                return a[i] 
            else:
                return None

        if j == 0:
            if a[i] == b[j]:
                return b[j] 
            else:
                return None

        while a[i] == b[j]:
            i -= 1
            j -= 1
            if i == -1:
                return a[i+1]
            if j == -1:
                return a[i+1]
                
        inter = a[i].next
        return inter
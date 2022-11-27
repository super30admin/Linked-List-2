# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

'''
Time Complexity -->
O(m+n) since we are travesring and checking the length of the List A and List B

Space Compelxity -->
O(1)
'''

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lena = 0
        lenb = 0
        curr1 = headA
        curr2 = headB
        while curr1:
            lena+=1
            curr1 = curr1.next
        while curr2:
            lenb+=1
            curr2 = curr2.next
        curr1 = headA
        curr2 = headB
        if lena>lenb:
            while lena!=lenb:
                curr1 = curr1.next
                lena-=1
        if lenb>lena:
            while lenb!=lena:
                curr2 = curr2.next
                lenb-=1
        
        while curr1 and curr2:
            if curr1 == curr2:
                return curr1
            curr1=curr1.next
            curr2=curr2.next
        return None
                
            
        
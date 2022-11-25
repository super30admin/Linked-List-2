# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# TC : O(max(len(headA), len(headB)))
# SC : O(min(len(headA), len(headB)))
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        dummyA = headA
        dummyB = headB
        d_a = []
        d_b = []
        while dummyA:
            d_a.append(dummyA.val)
            dummyA = dummyA.next
        while dummyB:
            d_b.append(dummyB.val)
            dummyB = dummyB.next
        # print(d_a, d_b)
        i = len(d_a) - 1
        j = len(d_b) - 1
        k = []
        # intersection of values are obtained in the list
        while (i>=0 and j>=0) and d_a[i]==d_b[j]:
            k.insert(0, d_a[i])
            i -= 1
            j -= 1
        l_a = len(d_a)
        l_b = len(d_b)
        kk = len(k)
        
        if kk==0:
            return None
        # reach till same value
        dupe_A = headA
        while l_a>kk:
            dupe_A = dupe_A.next
            l_a = l_a - 1
        dupe_B = headB
        while l_b>kk:
            dupe_B = dupe_B.next
            l_b = l_b - 1
        # print(dupe_B.val, dupe_A.val)
        # searching inside the intersect lists
        while dupe_A != dupe_B:
            dupe_A = dupe_A.next
            dupe_B = dupe_B.next
        return dupe_A

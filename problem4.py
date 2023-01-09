#time complexity: O(n)
#space complexity: O(1)
#ran on leetcode: Yes
#Traverse through both the linked list by using 2 pointers and note down the number of nodes in each. Difference between these 2 would give the number of nodes by which one linked list is lengthier than the other. So traverse through the lengthier linked list by m-n(difference) times. Then traverse both the linked list till both the pointers point to the same node. 
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        first=headA
        m=0
        second=headB
        n=0
        while(first):
            first=first.next
            m+=1
        while(second):
            second=second.next
            n+=1
        if(m>n):
            first=headA
            second=headB
        else:
            first=headB
            second=headA
        count=abs(m-n)
        while(count>0):
            first=first.next
            count-=1
        while(second!=first and first and second ):
            first=first.next
            second=second.next
        return first



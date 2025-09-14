# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
'''
Move the head of the list with larger size upto difference of their sizes. Then 
Start iterating both list together, if they are same at any point, that is the
intersection head.
Time Complexity: O(N1 + N2). N1 = size of list 1, N2 = size of list 2
Space Complexity: O(1)
'''
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1_size = self.__getListSize(headA) # get size of the list1
        l2_size = self.__getListSize(headB) # get size of list2

        # Move the head of the list with larger size for difference of their sizes
        if l1_size>=l2_size:
            diff = l1_size-l2_size
            for steps in range(diff):
                headA=headA.next
        else:
            diff = l2_size-l1_size
            for steps in range(diff):
                headB=headB.next
        
        while headA!=None:
            if headA==headB:
                return headA
            headA=headA.next
            headB=headB.next
        
        return None
    
    def __getListSize(self,head):
        size = 0
        while head!=None:
            head=head.next
            size+=1
            
        return size
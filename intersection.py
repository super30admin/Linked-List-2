# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # brute force approach
        # Tc - O(n) for first iteration to add nodes of A in set + O(n) for second iteration of list b and check if in set --> O(n) 
        # SC - O(n) --> to store in set
        # nodeSet = set()
        # a = headA
        # while a!= None:
        #     nodeSet.add(a)
        #     a = a.next
        # b = headB
        # while b!= None:
        #     if b in nodeSet:
        #         return b
        #     b = b.next
        # return None   

        # optimized method
        # TC - O(n)
        # Sc - O(1)
        ## Takeaways -> for no intersection eventually both will point to None so we will come out of while and return a which is None
        ## check a == None and b == None and not a.next == None and b.next as the codition of no intersection would not be handled with later condition so have a == None and b== None condition for checking
        
        a , b = headA, headB
        while a!=b:
            a = headB if a == None else a.next
            b = headA if b == None else b.next
        return a   



       

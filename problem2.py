#Time Complexity O(N)
#Space Complexity O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse_list(self, head):
        previous = None
        current = head
        while current is not None:
            next_node = current.next
            current.next = previous
            previous = current
            current = next_node
        return previous
    def getMid(self,head):
        sl = head
        fs = head
        counter = 0
        while fs.next !=None and fs.next.next!=None:
            sl = sl.next
            fs = fs.next.next
            counter+=1
        return sl,counter
    # def getreversedsecond(self,head):
    #     sl = head
    #     fs = head
    #     while fs.next !=None and fs.next.next!=None:
    #         sl = sl.next
    #         fs = fs.next.next
    #     return sl
    
    def reorderList(self, head: Optional[ListNode]) -> None:
        sl = head
        fs = head
        while fs.next !=None and fs.next.next!=None:
            sl = sl.next
            fs = fs.next.next
        
        fs = self.reverse_list(sl.next)
        sl.next = None
        sl =head
        temp = None
        while fs!=None:
            temp = sl.next
            sl.next = fs
            fs=fs.next
            sl.next.next = temp
            sl = temp
        sl= head
        
            
            
            
        
        return None
#         res = []
#         temp = head
#         while temp!=None:
#             res.append(ListNode(temp.val))
#             temp = temp.next
        
        
#         test = ListNode(0)
#         val =res.pop(0)
#         test.next = res.pop()
#         temp = test.next
#         for x in res:
#             temp.next = x
#             temp = temp.next
            
#         head.next = test.next
        
        
        
        
        
        
        
        
        
        
        

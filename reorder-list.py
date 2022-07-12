# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :no



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
        
        slow,fast=head,head.next  
       
        # find the middle
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next   
            
        #reverse second half      
        curr=slow.next
        prev=None
        slow.next=None

        
        while curr:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp       
#         print(prev)
       
    
#     To merge two halfs
        first=head
        end=prev
        
        
        while end:
            temp1=first.next
            temp2=end.next
            first.next=end
            end.next=temp1
            first=temp1
            end=temp2
            
        return head
# Leetcode Execution :YES
# Time Complexity:O(n)
# Space Complexity: O(n)
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
        if head.next==None:
            return head
        forward=[]
        temp=head
        
        # we first put everything in a an array and make each nodes next to None to avoid cycle
        while(temp!=None):
            forward.append(temp)
            curr=temp.next
            temp.next=None
            temp=curr
        # print(forward)
        low=0
        high=len(forward)-1
        curr=None
        head=forward[low]
        
        # we then take two pointers and make connecttion by taking one node from front adn one node from right end 
        while(low<high):
            if curr==None:
                curr=forward[low]
                
            else:
                curr.next=forward[low]
                curr=forward[low]
            curr.next=forward[high]
            curr=forward[high]
            high-=1
            low+=1
        # print(head)
        if len(forward)%2!=0:
            curr.next=forward[low]
        return head
            
        
                
                
            
             
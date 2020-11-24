#timecomlexity O(n)
#SapceComplexity O(n)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        #Brute force
        # creating a list of the all the val in the list 
        # using two pointer approach to create a new list
        l=[]
        temp=head
        while temp!=None:
            l.append(temp.val)
            temp=temp.next
        print(l)
        i=0
        j=len(l)-1
        while(i<=j):
            if i==j:
                head.val=l[i]
                head.next=None
                i+=1
            else:
                head.val=l[i]
                i+=1
                head=head.next
                head.val=l[j]
                j-=1
                head=head.next
            
        
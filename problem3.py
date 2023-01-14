# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        first=head
        list1=[]
        final=[]
        while first:
            list1.append(first.val)
            first=first.next
        list3=list1
        list2=list1[::-1]
        for i,j,k,l in zip(list3,list2,range(0,len(list2)),range(0,len(list2))):
            if k==len(list2)//2 :
                if len(list2)%2==1:
                    final.append(i)
                    break
                else:
                    break
            final.append(i)
            final.append(j)
        # print(final)
        for i in final:
            head.val=i
            head=head.next
            
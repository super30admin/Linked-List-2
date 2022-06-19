"""Approach 0: Brute force, for each node in list one, iterate over list 2 and find the TreeNode
That is same in both.
TC O(N*M) solution
SC O(1)"""
"""Approach 0.5: Iterate over list 1 and add each node to hashmap and then iterate
over list 2 to find which node from list 2 is already in hashmap and that is our answer.
Trade space for time. 
TC O(M+N)
SC O(M+N) in worst case if there is no intersection, we add all nodes of each node to the map"""
"""
Approach1:
Find len of linked lists, each of the two
then move the longer linked list pointer to be same distance from end of the list
as the short list would be.
Move each of them 1 step at a time. When they meet, return that node.
TC O(N+M)
SC O(1) 

But code here is elaborate. We can simplify it."""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # find len of listA
        currA = headA
        countA = 0
        while currA:
            currA = currA.next
            countA += 1
        # find len of listB
        currB = headB
        countB = 0
        while currB:
            currB = currB.next
            countB += 1

        currA = headA
        while countA > countB:
            currA = currA.next
            countA -= 1
        
        currB = headB
        while countB > countA:
            currB = currB.next
            countB -= 1

        while currA != currB:
            currA = currA.next
            currB = currB.next
                
        return currA

"""Approach2: Here we just keep traversing through both lists
to find the intersection node.
Algo:
start both at their headA and headB
whichever reaches end first, move it to head of other list, and vice versa.
On next iteration they will intersect.
e.g. 
for input:8
[4,1,8,4,5]
[5,6,1,8,4,5]
2
3
Traversal will be like:
4 5
1 6
8 1
4 8
5 4
None 5
5 None
6 4
1 1

"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        currA = headA
        currB = headB
        while currA != currB: 
            currA = headB if currA is None else currA.next 
            currB = headA if currB is None else currB.next
        
        return currA

        
        

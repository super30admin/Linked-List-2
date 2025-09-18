## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

# Method1: Using Hashing
# Time Complexity : O(m + n)
# Space Complexity : O(min(m, n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we use hashing to find if there is a intersection node that exists. We find length of both the lists. Out of them we put nodes(references) of 
# the list with min length into a hash set. Then we iterate over the other list and check if a common node exists. 


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def getListSet(self, head, listSet):
        # create hash set for the linked list
        curr = head
        while(curr):
            listSet.add(curr)
            curr = curr.next
        
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        countA = 0
        countB = 0

        currA = headA
        while(currA):
            countA += 1
            currA = currA.next
        
        currB = headB
        while(currB):
            countB += 1
            currB = currB.next

        listSet = set()
        if(countA <= countB):
            self.getListSet(headA, listSet)
            currB = headB
            # iterate through the other list and check if any node exists in the set
            while(currB):
                if(currB in listSet):
                    # intersetion found
                    return currB
                currB = currB.next
        else:
            self.getListSet(headB, listSet)
            currA = headA
            # iterate through the other list and check if any node exists in the set
            while(currA):
                if(currA in listSet):
                    # intersetion found
                    return currA
                currA = currA.next

        return None

def printLinkedList(root):
    curr = root
    while(curr):
        print(curr.val, end=" -> ")
        curr = curr.next
    print()


print("Method1: Hashing")
l1node1 = ListNode(1)
l1node4 = ListNode(4)
l2node1 = ListNode(1)
l2node5 = ListNode(5)
l2node6 = ListNode(6)
commNode8 = ListNode(8)
commNode4 = ListNode(4)
commNode5 = ListNode(5)
l1node4.next = l1node1
l1node1.next = commNode8
commNode8.next = commNode4
commNode4.next = commNode5
l2node5.next = l2node6
l2node6.next = l2node1
l2node1.next = commNode8
headA = l1node4
headB = l2node5
sol = Solution()
print("eg:1")
print(sol.getIntersectionNode(headA, headB) == commNode8)
print(sol.getIntersectionNode(headA, headB) == commNode4)

secL1Node2 = ListNode(2)
secL1Node6 = ListNode(6)
secL1Node4 = ListNode(6)

secL2Node1 = ListNode(1)
secL2Node5 = ListNode(5)

headA = secL1Node2
headB = secL2Node1
sol = Solution()
print("eg:2")
print(sol.getIntersectionNode(headA, headB) == None)
print(sol.getIntersectionNode(headA, headB) == commNode8)


# Method2: Using two pointers on Linked List
# Time Complexity : O(m + n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we find length of both the linked lists. For the shorter linked list we start the pointer at its head. For the longer linked list
# we move the pointer to the node that is away from the head at a distance = difference between lengths of linked lists. Then we move both the 
# pointers simultaneously to check if they meet at a certain node.

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
        
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        countA = 0
        countB = 0

        currA = headA
        while(currA):
            countA += 1
            currA = currA.next
        
        currB = headB
        while(currB):
            countB += 1
            currB = currB.next

        currA = headA
        currB = headB

        # if countA > countB
        while(countA > countB):
            # list A is larger
            currA = currA.next
            countA -= 1

        # if countB > countA
        while(countB > countA):
            # list B is larger
            currB = currB.next
            countB -= 1

        # now we can move the pointers simultaneously
        while(currA != currB):
            # they can be equal is some node or they would equal when they reach null
            currA = currA.next
            currB = currB.next

        return currA

print("Method2: Using two pointers on Linked List")
l1node1 = ListNode(1)
l1node4 = ListNode(4)
l2node1 = ListNode(1)
l2node5 = ListNode(5)
l2node6 = ListNode(6)
commNode8 = ListNode(8)
commNode4 = ListNode(4)
commNode5 = ListNode(5)
l1node4.next = l1node1
l1node1.next = commNode8
commNode8.next = commNode4
commNode4.next = commNode5
l2node5.next = l2node6
l2node6.next = l2node1
l2node1.next = commNode8
headA = l1node4
headB = l2node5
sol = Solution()
print("eg:1")
print(sol.getIntersectionNode(headA, headB) == commNode8)
print(sol.getIntersectionNode(headA, headB) == commNode4)

secL1Node2 = ListNode(2)
secL1Node6 = ListNode(6)
secL1Node4 = ListNode(6)

secL2Node1 = ListNode(1)
secL2Node5 = ListNode(5)

headA = secL1Node2
headB = secL2Node1
sol = Solution()
print("eg:2")
print(sol.getIntersectionNode(headA, headB) == None)
print(sol.getIntersectionNode(headA, headB) == commNode8)
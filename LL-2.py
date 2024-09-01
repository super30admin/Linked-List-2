# Linked-List-2

## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):

        self.stack = []
        self.dfs(root)

    def dfs(self, root: Optional[TreeNode]) -> None:

        while root != None:
            self.stack.append(root)
            root = root.left


    def next(self) -> int:
        popped = self.stack.pop()
        self.dfs(popped.right)
        return popped.val



    def hasNext(self) -> bool:
        return(len(self.stack) > 0)
        
# TC = O(1) , SC = O(h)

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

## Problem2 (https://leetcode.com/problems/reorder-list/)

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
        if head == None or head.next == None :
            return head

        #1. finding middle element
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        #2. reverse 2nd half of LL
        fast = self.reverse(slow.next)
        slow.next = None

        #3. merge 2 LL
        slow = head
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp



    def reverse(self, head: Optional[ListNode]) -> ListNode:
        if head == None or head.next == None :
            return head

        prev = None
        curr = head
        fast = head.next
        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev

        return curr
# TC = O(1) , SC = O(h)

## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def delete_node(del_node):
    # Copy the data from the next node to the current node
    del_node.data = del_node.next.data
    # Point the current node's next to the next node's next
    del_node.next = del_node.next.next

# Helper function to print the linked list
def print_list(head):
    current = head
    while current:
        print(current.data, end=" -> " if current.next else "")
        current = current.next
    print()

# Example usage:
# Creating a linked list 10 -> 20 -> 4 -> 30
head = Node(10)
second = Node(20)
third = Node(4)
fourth = Node(30)
head.next = second
second.next = third
third.next = fourth

print("Original Linked List:")
print_list(head)

# Deleting node with value 20 (second node)
delete_node(second)

print("\nLinked List after deleting node with value 20:")
print_list(head)

## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA == None or headB == None:
            return None

        lenA = 0
        curr = headA
        while curr != None:
            lenA = lenA + 1
            curr = curr.next 

        lenB = 0
        curr = headB
        while curr != None:
            lenB = lenB + 1
            curr = curr.next 


        while lenA > lenB:
            headA = headA.next
            lenA = lenA - 1

        while lenB > lenA:
            headB = headB.next
            lenB = lenB - 1

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA
#TC = O(m+n), SC = O(1)
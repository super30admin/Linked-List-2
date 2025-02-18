'''
// Time Complexity :
Problem 1: O(1) best case - O(h) worst case - when we parse all elements in the left subtree
Problem 2: O(n) as we operate on the entire linked list
Problem 3: O(1) as we operate on one value
Problem 4: O(m+n) m & n are lengths of both linked lists
// Space Complexity :
Problem 1: O(h) - based on the subtrees
Problem 2: O(1) as we reverse and link one element in the same linked list
Problem 3: O(1) as we perform this on the current element
Problem 4: O(m+n) as we parse both the lists
// Did this code successfully run on Leetcode :
Yes the code ran successfully.
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
'''
## Problem 1 - BST Iterator
# Append the root first and then the left elements.
# The next() method should always return the next minimum element in the BST. 
# Whenever an element is popped from the stack that is used, push that node's right element and then 
# all its left elements till the last left element.

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: Optional[TreeNode]
        """
        self.stack = []
        if root != None:
            self.stack.append(root)
            self.dfs(root)

    def dfs(self,root):
        while root.left != None:
            self.stack.append(root.left)
            root = root.left
        return        

    def next(self):
        """
        :rtype: int
        """
        if not (self.hasNext()):
            return -1
        
        resultNode = self.stack.pop()
        if (resultNode.right != None):
            self.stack.append(resultNode.right)
            self.dfs(resultNode.right)
        return resultNode.val
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return (len(self.stack) > 0)  

## Problem 2 - Reorder list
# Create a function to reverse the linked list nodes, we take current, previous and next nodes. Assign 
# the next node with previous where previous is initialized as 'None'. Assign the previous as current
# and the current node as next which reverses the direction.
# We make the next node as next of next node and current as previous node for the next iteration.
# Find the mid element by using slow and fast pointers. Approach to the last element and link the 
# first element to the last. The element is found by checking the fast pointer with 'Null'.
# We recursively do this by assigning elements of the 1st half to the elements of reversed second half
# of the linked list.

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution(object):
    
    def reverse(self, head):
        prevNode = None
        currNode = head
        nextNode = head.next

        while (nextNode != None):
            currNode.next = prevNode
            prevNode = currNode
            currNode = nextNode
            nextNode = nextNode.next

        currNode.next = prevNode
        return currNode
        
    def reorderList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: None Do not return anything, modify head in-place instead.
        """
        ## Find the middle element
        slow = head
        fast = head.next
        while (fast != None and fast.next != None):
            slow = slow.next
            fast = fast.next.next
        ## Slow at proverbial mid
        ## Reverse the second half of the linked list
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        ## Merge the list
        while fast != None:
            temp = slow.next
            slow.next = fast
            slow = temp
            temp = fast.next
            fast.next = slow
            fast = temp
        return

## Problem 3 - Delete without head pointer
# Get the current nodes next value and store it in the current node
# Make the current node's next value as None - essentially deleting it
'''
	{
		# Node Class
		class Node:
		    def __init__(self, data):   # data -> value stored in node
		        self.data = data
		        self.next = None
	}
'''
class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        if node == None or node.next == None: return None
        node.data = node.next.data
        node.next = node.next.next
        return

## Problem 4 - Intersection of two linked list
# We find the lengths of both the linked lists and check for the greater list
# Find the intersection and based on the larger length we move the head of A or B
# When both the heads are at the same intersection point we will return the node.

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
        lA = 0
        lB = 0
        curr = headA
        while(curr != None):
            curr = curr.next
            lA += 1
        curr = headB
        while(curr != None):
            curr = curr.next
            lB += 1
        # Find the intersection and based on the larger length we move the head of A or B    
        while(lA > lB):
            headA = headA.next
            lA -= 1
        while(lB > lA):
            headB = headB.next
            lB -= 1
        # Until the heads match we will keep incrementing the head
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

# Linked-List-2

## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
# // Time Complexity : o(N)
# // Space Complexity : o(N)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
# // Your code here along with comments explaining your approach
we can use the recursion 
1) Initialize an stack  which will be used for inorder traversal for our binary search tree. 
2)we can call the  helper function, called _inorder_left, it will add all the nodes in the leftmost branch of the tree rooted at the given node root to the stack 
and it will keep on doing so until there is no left child of the root node. It will run in inorder traversal
3)next() function is called, the smallest element of the BST has to be returned and then we have to move to the next element.
we can implement the hasNext() function since all we need to check is if the stack is empty or not. 
we have the pop off the node of the stack and return its value.
if we have right child no need to check we already added left subtree on to the stack.
again call for next and return the next smallest element in the BST from the top of the stack.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):

        self.stack = []
        self._leftmost_inorder(root)

    def _leftmost_inorder(self, root):

        # For a given node, add all the elements in the leftmost branch of the tree
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        # return the next smallest number and Node at the top of the stack is the next smallest element
        topmost_node = self.stack.pop()

        # Need to maintain the invariant. If the node has a right child, call the helper function for the right child
        if topmost_node.right:
            self._leftmost_inorder(topmost_node.right)
        return topmost_node.val

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()




## Problem2 (https://leetcode.com/problems/reorder-list/)
# // Time Complexity : o(n)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
# // Your code here along with comments explaining your approach
# three steps we have to do 1) find the middle of the linked list, 2) reverse the linked list 3)Merge both the linked list
# 1) Middle of the Linked List
# use two pointers slow and fast, slow pointer moves one steps and fast pointers moves two steps forward.
# When the fast pointer reaches the end of the list, the slow pointer should be in the middle.
# 2)reverse the second half of the ll
# here the midlle node is the slow pointer and previous pointer is null 
# For each current node, save its neighbors: the previous node prev and the next node tmp = curr.next.
# While moving change the node's next pointer to point to the previous node: curr.next = prev, 
# and shift the current node to the right for the next iteration: prev = curr, curr = tmp.
# 3)# merge two sorted linked lists
# take first node of each list, 1st linked list head as slow and 2nd linked list as fast to the head of the linked list


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
        if not head:
            return 

        slow = head
        fast = head
        # Middle of the Linked List
        while (fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next

        # reverse the second half of the ll
        prev = None
        curr = slow.next
        while (curr != None):
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        fast = prev
        slow.next = None

        ## merge two sorted linked lists
        slow = head
        while fast:
            temp = slow.next
            slow.next = fast
            fast= fast.next
            slow.next.next = temp
            slow = temp


## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
# // Time Complexity : o(1)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : No
# // Any problem you faced while coding this : no
# // Your code here along with comments explaining your approach
# First Check whether the pointer to the next node is null.
# copy the data of the next node to update the current node value to be deleted 
# move the pointer of the current node to its next node and return the current node

# delete without head pointer
class LinkNode :
	def __init__(self, data) :
		self.data = data
		self.next = None
	

class SingleLL :
	def __init__(self) :
		self.head = None
	
	#  Add new node at the end of linked list
	def addNode(self, value) :
		#  Create  node
		node = LinkNode(value)
		if (self.head == None) :
			self.head = node
		else :
			temp = self.head
			#  Find the last node
			while (temp.next != None) :
				#  Visit to next node
				temp = temp.next
			
			#  Add node at last position
			temp.next = node
	
	#  Delete a node in linked list
	def deleteNode(self, node) :
		if (node == None) :
			return
		
		if (node.next == None) :
			print("\n Not delete last node")
		else :
			#  Change data value to next node
			node.data = node.next.data
			#  Change link
			node.next = node.next.next
		
		
	#  Display all Linked List elements
	def display(self) :
		if (self.head != None) :
			temp = self.head
			while (temp != None) :
				#  Display node value
				print(" ", temp.data, end = "->")
				temp = temp.next
			
		else :
			print("Linked list is empty")


## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
# // Time Complexity : 0(m + n)
# // Space Complexity : 0(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
# // Your code here along with comments explaining your approach
# we have to approach by two pointers
# we have to find the length of both the linked list headA and headB
# take the difference from both the linked list
# whichever is having bigger length move the pointer by the difference of the Node
# then move headA and headB pointer by 1x till it intersects.
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        lenB = 0
        curr = headA
        while(curr != None):
            lenA += 1
            curr = curr.next
        
        curr = headB
        while(curr != None):
            lenB += 1
            curr = curr.next
        
        while(lenA > lenB):
            headA = headA.next
            lenA -= 1
        
        while(lenB > lenA):
            headB = headB.next
            lenB -= 1

        while(headA != headB):
            headA = headA.next
            headB = headB.next

        return headB
        



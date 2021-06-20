'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 142. Linked List Cycle II
# Implement the BSTIterator class that represents an iterator over 
# the in-order traversal of a binary search tree (BST):

# BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. 
# The root of the BST is given as part of the constructor. The pointer should be 
# initialized to a non-existent number smaller than any element in the BST.
# boolean hasNext() Returns true if there exists a number in the traversal to the 
# right of the pointer, otherwise returns false.
# int next() Moves the pointer to the right, then returns the number at the pointer.
# Notice that by initializing the pointer to a non-existent smallest number, the 
# first call to next() will return the smallest element in the BST.

# You may assume that next() calls will always be valid. That is, there will be 
# at least a next number in the in-order traversal when next() is called.

#-----------------
# Time Complexity: 
#-----------------
# __init__ : O(N): Need to iterate over entire tree once to construct inorder LL
# next()   : O(1): Simple addition and O(1) lookup for len
# hasNext(): O(1)

#------------------
# Space Complexity: 
#------------------
# O(h): Need auxiliary stack tracing recursion of max size = height of tree 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
        
class BSTIterator:

    def __init__(self, root: TreeNode):
        
        self.inorder_ll = []
        self.construct_inorder(root)
        self.current = -1
            
    def construct_inorder(self, root:TreeNode) -> None:
        if root is None:
            return
        else:
            self.construct_inorder(root.left)
            
            self.inorder_ll.append(root.val)
            
            self.construct_inorder(root.right)            
                

    def next(self) -> int:
        self.current += 1
        if self.current <= (len(self.inorder_ll)-1):
            return self.inorder_ll[self.current]
        else:
            return None
        

    def hasNext(self) -> bool:
        return ((self.current+1) <= len(self.inorder_ll)-1)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
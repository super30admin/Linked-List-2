'''
173. Binary Search Tree Iterator
Problem Link: https://leetcode.com/problems/binary-search-tree-iterator/
'''

# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this :

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        """
        Initialize the iterator with the root of the BST.
        """
        self.stack = [] # yeh stack BST ke nodes ko store karega (this stack will store the nodes of the BST)
        self._push_left(root) # yeh function left subtree ke sabhi nodes ko stack me push karega (this function will push all left children of the root onto the stack)
        # Push all left children of the root onto the stack

    def _push_left(self, node: Optional[TreeNode]):
        while node: # jab tak node None nahi ho jata (while node is not None)
            self.stack.append(node) # Stack me node ko push karte hain (push the node onto the stack)
            node = node.left  # Move to the left child    
        

    def next(self) -> int:
        """
        Return the next smallest number in the BST.
        """
        if not self.stack: # agar stack khali hai to next element nahi hai (if the stack is empty, there is no next element)
            return None # raise Exception("No more elements in the BST")  # Raise an exception if there are no more elements to iterate over
        node = self.stack.pop()  # Pop the top node from the stack
        self._push_left(node.right)  # Push all left children of the right subtree onto the stack
        return node.val  # Return the value of the popped node

    def hasNext(self) -> bool: 
        """
        Return whether there is a next smallest number in the BST.
        """
        return len(self.stack) > 0  # Check if the stack is not empty to determine if there are more elements to iterate over
        # isse hum dono halves ko merge karte hain (this merges both halves)
        # Linked list ab reorder ho chuka hai (the linked list is now reordered)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
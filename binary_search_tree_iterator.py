# Time Complexity:- O(1) -> for hasnext O(1) -> for next(average)
# Space Complexity:- O(h) -> height of the tree
# Approach:- The smallest element would be always on the left of a node(If it exists) otherwise it would 
# be the next right node or it would lie on the left of the next right node.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack=[]
        while(root):
            # the element smaller than the root element will lie on the left of a BST
            self.stack.append(root)
            root=root.left
            
        

    def next(self) -> int:
        """
        @return the next smallest number
        """
        if self.hasNext():
            ret=self.stack.pop()
            # appending the next smallest number on the stack
            if ret.right:
                # check the right element and then check the left elements of the this next right element
                node=ret.right
                while(node):
                    self.stack.append(node)
                    node=node.left
        return ret.val
                    
                
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        # if the stack is empty we dont have any other elements
        return len(self.stack)>0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
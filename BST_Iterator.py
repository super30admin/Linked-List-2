  ----------------------BST Iterator-------------------------------------   
# Time Complexity : O(N) N is the number of Nodes in a tree.
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I have used inorder traversal approach. We know that left most node is the smallest node of all the nodes in binary search tree, 
#Whenever next is called, we will try to append the left nodes of the node into stack and the top most node will be the smallest one.
#If the node has the right node, then we again do the same procedure so that top of the stack will be smallest.

# To check hasnext() we will check the length of the stack.


class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)
    
    def dfs(self,root):
        while root!=None:
            self.stack.append(root)
            root = root.left


    def next(self) -> int:
        """
        @return the next smallest number
        """
        top = self.stack.pop()
        
        if top.right:
            self.dfs(top.right)
        
        return top.val
        
        
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack)>0
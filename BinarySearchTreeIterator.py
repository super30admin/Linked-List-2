# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''Time Complexity: O(1)
Space Complexity: O(1)'''
class BSTIterator(object):
    
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        #Stack for teh nodes
        self.stack=deque()
        #To push the left nodes into the stack
        self.__dfs(root)
        
    def __dfs(self,root):
        while root is not None:
            self.stack.append(root)
            root=root.left 

    def next(self):
        """
        :rtype: int
        """
        #Take out the top of the stack
        currtop=self.stack.pop()
        temp=currtop.val
        self.__dfs(currtop.right)
        return temp
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stack)!=0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

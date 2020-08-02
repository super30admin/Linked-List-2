#Time complexity: O(n) , Amortised - O(1)
#Space complexity: O(h) where h is the height of the BST
# Works on leetcode: yes 
#Approach: While initiating the iterator, we add all the left most elements in the stack. When the next() is called, we pop a
#node from stack and before returning it, we add all the left nodes of the right node of popped node to the stack.
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left
        
    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        node = self.stack.pop()
        x = node.right
        while x:
            self.stack.append(x)
            x = x.left
        return node.val
        
        
    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        return len(self.stack) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
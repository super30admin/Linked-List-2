# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):

    # binary search tree : given the values shoudl be represent in in-order so left root right 
    # brust force : do inorder traversal once save in a queue fifo, so we can call next founction and return the first left value and so on 
    # for hasnext we can check if there are still elemenst in the queue. 
    # optimal approach : lazy loading intially add just root and when called the next will add the right tree of the node 
    # benifits of this approach is 1. i don't need to add all the elements in the list, until next is called i don't need to add other elemenst in the tree svaing the space complexity
    # 2. if later any new element is added in the tree or if anything is removed also we can check accordingly at that instance instead of iterating in the begining

    # tc : O(1) armotized 
    # sc : O(h)

    def __init__(self, root):
        """
        :type root: Optional[TreeNode]
        """
        self.st = []
        self.inorder(root)
        
    
    def inorder(self,root):
        while root:
            self.st.append(root)
            root = root.left

    def next(self):
        """
        :rtype: int
        """
        node = self.st.pop()
        self.inorder(node.right)

        return node.val
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.st) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
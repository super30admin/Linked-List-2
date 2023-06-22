#Time complexity is: O(1)
#Space complexity is: O(n) 
#Code ran successfully on leet code
#Faced no issues while coding this problem

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        #creating a stack to store elements in it
        self.st=[]
        #Calling dfs fuction by sending root
        self.dfs(root)
    
    def dfs(self,root):
        #We will going towards the left direction
        while(root!=None):
            #We will be appending values into the stack
            self.st.append(root)
            #Moving towards the left side
            root=root.left

    def next(self):
        """
        :rtype: int
        """
        #Poppsing the top value from the stack and again performing inorder traversal
        self.popped=self.st.pop()
        self.dfs(self.popped.right)
        #returning value at popped element
        return self.popped.val

    def hasNext(self):
        """
        :rtype: bool
        """
        #If the stack is not empty, we will return True else False 
        if(len(self.st)>0):
            return True
        return False
     
# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
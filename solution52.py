#Time Complexity:O(n)
#Space Complexity:O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    global s                                #declaring a stack
    def __init__(self, root: TreeNode):
        self.s=[]                           #initializing it
        self.dfs(root)                      #calling the dfs function

    def next(self) -> int:                  
        result=TreeNode()                   #create a tree node
        result=self.s.pop()                 #that holds the poped element from the stack
        self.dfs(result.right)              #call dfs on the right subtree since left is iterated
        return result.val                   #return the value at the result node

    def hasNext(self) -> bool:
        if len(self.s)>0:                   #if stack consist of node return true
            return True                     #else return false
        return False
    
    def dfs(self,root:TreeNode):
        while(root):                        #while the root is not null
            self.s.append(root)             #push the current node to the stack
            root=root.left                  #move towards the left node of current node

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
"""
FAANMG Problem #56 {Medium}

173. Binary Search Tree Iterator

Time Complexity : O(1)


Space Complexity : O(h)


Did this code successfully run on Leetcode : Yes
  

We will copy the data of the next node to the current node 
Then link the node after the next node to the curr node


@name: Rahul Govindkumar_RN27JUL2022
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    
    # Define an empty stack and call the dfs function with the root 
    def __init__(self, root: Optional[TreeNode]):
        self.st = collections.deque()
        self.dfs(root)
    
        
     # We interate the root until there is no left node left or left node is null and push that element onto the stack
    def dfs(self, root):
        
        while root:
            self.st.append(root)
            root = root.left
            
    # next function pops the top element of the stack and returns it, while also calls thd dfs function on the right side of the popped values
    # so any root value will come only once in the iteration
    # This iteration is dynamic as we store the root or node itself and not just its value as reference can dynamically change
    
    
    def next(self) -> int: 
        node = self.st.pop()
        self.dfs(node.right)
        return node.val
        
    # This function checks if the stack is empty or not, which means that we have another node to iterate over or not
    def hasNext(self) -> bool:
        return len(self.st)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
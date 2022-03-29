#Time Complexity : O(N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    
    def __init__(self, root: Optional[TreeNode]):
        self.iterator = root
        self.li = []
        self.flag = True
        #storing the elements in inorder way in list
        def recursive(root,listt):
            if root == None:
                return
            
            recursive(root.left,listt)
            listt.append(root.val)
            recursive(root.right,listt)
            
            return listt
        
        self.li = recursive(root,[])
            
            
    def next(self) -> int:
        #using list as stack over here 
        curr = self.li.pop(0)
        if curr!=None:
            return curr

    def hasNext(self) -> bool:
        #checking lenght of string if it is greater than 0
        if len(self.li) > 0:
            return True
        return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
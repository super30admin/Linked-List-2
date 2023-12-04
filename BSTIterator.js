//Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
//Accepted in Leetcode
//TC is O(n) and SC is O(1)

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 */
var BSTIterator = function(root) {

    // creating stack to control recurssion

    this.stack = [];
    this.init(root);

};
BSTIterator.prototype.init=function(root){

        while(root!= null){
            this.stack.push(root);
            root = root.left;
        }

    }



/**
 * @return {number}
 */
BSTIterator.prototype.next = function() {

    let temp = this.stack.pop();
    if(temp.right != null){
        this.init(temp.right);
    }
    return temp.val;
};

/**
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function() {
    return this.stack.length>0; 
};

/** 
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
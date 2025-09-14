/*
class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

let head;

*/
// Time complexity - O(1)
// Space complexity - O(1)
class Solution {
	deleteNode(del_node) {
		if (del_node === null) return;

		if (del_node.next === null) {
			del_node = null;
			return;
		}

		let temp = del_node.next;
		del_node.data = temp.data;
		del_node.next = temp.next;
		temp = null;
	}
}

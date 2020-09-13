//T: O(n)
//S :O(1)
class Solution {
public:
    void reorderList(ListNode* head) {
        vector<int> store;
        ListNode* curr = head;
        ListNode* re = new ListNode();
        while(curr){
            store.push_back(curr->val);
            curr = curr->next;
        }
        int x = 0;
        int y = store.size()-1;
        ListNode* res = new ListNode();
        ListNode* rs = res;
        while(x<y && res){
            //cout<<store[x]<<" "<<store[y]<<endl;
            res->next = new ListNode(store[x]);
            res = res->next;
            res->next = new ListNode(store[y]);
            res = res->next;
            //cout<<rs->val<<" ";
            x++;
            y--;
        }
        if(x==y) {res->next = new ListNode(store[x]);}
        // while(rs){
        //     cout<<rs->val<<" ";
        //     rs = rs->next;
        // }
        if(rs && rs->next && rs->next->next)
            head->next = rs->next->next;
      //  return res->next;
    }
};
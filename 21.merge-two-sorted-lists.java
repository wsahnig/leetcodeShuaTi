class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = null;
        if(l1 == null && l2 == null)
              return l;
        l=new ListNode(0);
        ListNode p = l;
        while(l1 != null || l2 != null){
            if( l1 != null && (l2 == null || l1.val <= l2.val) ){
                p.val = l1.val;
                l1=l1.next;           
            }
            else if( l2 != null && (l1 == null || l1.val > l2.val) ){
                p.val = l2.val;
                l2=l2.next;   
            }
            if(l1 != null || l2 != null){
                p.next = new ListNode(0);
            }
            p=p.next;  
        }
        return l; 
    }
}


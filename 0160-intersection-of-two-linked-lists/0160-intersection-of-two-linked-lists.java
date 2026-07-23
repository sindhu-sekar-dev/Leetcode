/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengA = 0;
        int lengB = 0;
        for(ListNode temp = headA ; temp != null ; temp = temp.next){
            lengA++;
        }
        for(ListNode temp = headB ; temp != null ; temp = temp.next){
            lengB++;
        }
        ListNode a = headA;
        ListNode b = headB;
        if(lengA > lengB){
            int diff = lengA - lengB;
            while(diff-- >0){
                a = a.next;
            }
        }else{
            int diff = lengB - lengA;
            while(diff-- >0){
                b = b.next;
            }
        }
        while(a != null && b != null){
            if(a == b){
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}
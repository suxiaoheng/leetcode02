/**
 * Created by Suxiaoheng517 on 2016/2/23.
 */
public class Solution {

    /*
    * 实际上，本题考查的是数据结构
    *difficulty:
    * 1.建立链表数据结构
    * 2.当两条链表长度不一样的时候，先将相同的取出来，剩下的再分情况考虑
    * ideas:
    * 1.建立数据结构
    * 2.以l1为基础，l1与l2相等部分
    * 3.若是l2结束了，则返回l1
    * 4.若是l1结束了，将l2的剩下的拿过来接在l1后面，返回l1
    *
    * principle:
    * 0.控制最初的情况（易忘记）
    * 1.学会调整，使代码具有一般性（很重要）
    * 2.如果是线性时间，就不要改成n2
    * 3.在链表操作的过程中如果next=null，并不是说将null=new Node（）即可的，那么并没有将链表链接起来（超级重要）
    * */


    //链表
    static class ListNode
    {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    //解决方法
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        //第一件事，就是定义结果
        ListNode result=l1;
        //用一个链表只是进度
        ListNode nowNode=l1;
        //以l1为标准，若是有和，就修改l1
        while(l1!=null&&l2!=null)
        {
            int value1=l1.value;
            int value2=l2.value;
            int median=value1+value2;
            l1.value=median%10;
            //用一个结点表示接下来的改进
            ListNode move=nowNode;
            int mark=median/10;
            //若是有进位，不断修改l1的后继结点
            while(mark>0)
            {

                if(move.next==null)
                {
                    move.next=new ListNode(mark);
                    break;
                }
                int meidian1=move.next.value+mark;
                move.next.value=meidian1%10;
                mark/=10;
                move=move.next;

            }

            //通过上面的修改后，继续前进
            l1=l1.next;
            l2=l2.next;
            nowNode=nowNode.next;

         }
        if(l2==null)
            return result;
        else
        {
            nowNode=l2;
            return result;
        }


    }

    public static void main(String[]args)
    {
        ListNode l1=new ListNode(0);
       /* ListNode l12=new ListNode(4);*/
       /* ListNode l13=new ListNode(3);*/
       /* l1.next=l12;*/
       /* l12.next=l13;*/

        ListNode l2=new ListNode(0);
       /* ListNode l22=new ListNode(6);
        ListNode l23=new ListNode(4);
        l2.next=l22;
        l22.next=l23;*/

       ListNode result=addTwoNumbers(l1,l2);
        while(result!=null)
        {
            System.out.printf("%d->",result.value);
            result=result.next;
        }
		//纯属测试git，忽略这行代码吧，哈哈
		

    }

}


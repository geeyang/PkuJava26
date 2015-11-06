import java.util.Stack;
class MyQueue {
    Stack<Integer> in= new Stack<Integer>();//���п�����Ϊǰ���������ջ
    Stack<Integer> out= new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) 
    {
        in.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() 
    {
        if (out.empty())  
        {  
            while(!in.empty())  //��in��ȡ����out��
            {  
                int x = in.pop();  
                out.push(x);  
            }    
        }  
        if (!out.empty())  
        {  
            out.pop();  
        } 
    }

    // Get the front element.
    public int peek() 
    {
        int result=0;
        if (out.empty())  
        {  
            while(!in.empty())  
            {  
                int x = in.pop();  
                out.push(x);  
            }  
        }  
        if (!out.empty())  
        {  
            result=out.peek();  
        }  
        return result;
    }  
   

    // Return whether the queue is empty.
    public boolean empty() {
        boolean r=(in.empty())&&(out.empty());
        return r;
        
    }
    

}
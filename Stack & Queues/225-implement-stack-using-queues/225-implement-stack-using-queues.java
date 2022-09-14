class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> q1 ,q2;
    public MyStack() {
       this.q1 = new LinkedList();
       this.q2 = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
       q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {


     while(q1.size() != 1){
         q2.add(q1.peek());
         q1.remove(q1.peek());
     }
     int temp = q1.peek();
      q1.remove();

      //swap q1 and q2
        Queue q = q1;
        q1 = q2;
        q2 = q;

        return temp;
    }

    /** Get the top element. */
    public int top() {
        if(q1.size() == 0){
            return -1;
        }
      while(q1.size() !=1){
          q2.add(q1.peek());
          q1.remove(q1.peek());
      }
        int temp = q1.peek();
        q1.remove();
         q2.add(temp);

        Queue q = q1;
        q1 = q2;
        q2 = q;

        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
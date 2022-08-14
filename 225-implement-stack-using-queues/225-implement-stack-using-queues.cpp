class MyStack {
public:
    
    queue<int> q1;
    queue<int> q2;
    MyStack() {
    }
    
    void push(int x) {
        
        q2.push(x);
 
        // Push all the remaining
        // elements in q1 to q2.
        while (!q1.empty()) {
            q2.push(q1.front());
            q1.pop();
        }
 
        // swap the names of two queues
        queue<int> q = q1;
        q1 = q2;
        q2 = q;
        
    }
    
    int pop() {
        
        if (q1.empty())
            return 0;
        int x=q1.front();
        q1.pop();
        return x;
        
    }
    
    int top() {
               return q1.front();

    }
    
    bool empty() {
        return q1.empty();
    }
};
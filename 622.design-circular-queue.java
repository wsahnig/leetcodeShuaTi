/*
 * @lc app=leetcode id=622 lang=java
 *
 * [622] Design Circular Queue
 */

// @lc code=start
class MyCircularQueue {
    private int size;
    private int front;
    private int rear;
    private int[] queue = new int[1001];
    
    public MyCircularQueue(int k) {
        size = k+1;
        front = 0;
        rear = 0;
    }
    
    public boolean enQueue(int value) {
        
        if(!isFull()){
            int tmp = (rear+1) % size;
            queue[rear] = value;
            rear = tmp;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty())
        {
            front = (front + 1) % size;
            return true;
            
        }
        return false;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return queue[((rear-1)+size)%size];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return (rear+1) % size == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end


public class Queue {
    private int[] data;
    private int rear;

    public Queue(int capacity) {
        data = new int[capacity];
        this.rear = -1;
    }

    public void offer(int val) {
        if(rear + 1 == data.length) {
            System.out.println("queue is full");
        } 

        data[++rear] = val;
    }

    public Integer poll() {
        if (rear == -1) {
            return null;
        }

        int ans = data[0];

        for(int i = 0; i < rear; i++){
            data[i] = data[i + 1];
        }
        rear--;

        return ans;
    }

    public Integer pick() {
        if (rear == -1) {
            return null;
        }

        return data[0];
    }
}

import java.util.*;

public class queueWork {

    public static class QueueImp{
        int[] data;
        int size;
        int front;
        QueueImp(int cap){
            this.data = new int[cap];
            this.front = 0;
            this.size = 0;
        }

        public int size(){
            return this.size;
        }

        public void add(int val){
            
            if(this.size == this.data.length){
                System.out.println("Queue Overflow");
                return;
            }
            else{
                int tail = (this.front + this.size) % this.data.length;
                this.data[tail] = val;
                this.size++;
            }
        }

        public int remove(){
            if(this.size == 0){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                int t = this.data[this.front];
                this.front =  (this.front + 1) % this.data.length;
                this.size--;
                return t;
            }
            
        }

        public void display(){

            int count = 0;
            for(int i =  front; i < data.length; i++){
                if(count != size){
                    System.out.print(data[i] + " ");
                    count++;
                }
            }

            if(count != size){
                for(int i = 0; i < data.length; i++){
                    if(count != size){
                        System.out.print(data[i] + " ");
                        count++;
                    }
                }
            }
            System.out.println();
            
        }

        public int peek(){
            if(this.size == 0){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                return this.data[this.front];
            }
        }

    }

    public static void main(String[] args){
//        Scanner scn = new Scanner(System.in);
          QueueImp q1 = new QueueImp(5); 
          q1.add(10);
          q1.add(20);
          q1.add(30);
          q1.add(40);
          q1.add(50);
          q1.display();
          System.out.println(q1.remove());
          System.out.println(q1.peek());
          System.out.println(q1.remove());
          q1.add(60);
          q1.add(70);
          q1.add(80);
          q1.display();
    }  
    
}

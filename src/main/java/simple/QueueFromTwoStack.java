package main.java.simple;

import java.io.*;
import java.util.*;

public class QueueFromTwoStack {

//    A queue is an abstract data type that maintains the order in which elements were added to it,
//    allowing the oldest elements to be removed from the front and new elements to be added to the rear.
//    This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue
//    (i.e., the one that has been waiting the longest) is always the first one to be removed.
//
//    A basic queue has the following operations:
//
//    Enqueue: add a new element to the end of the queue.
//            Dequeue: remove the element from the front of the queue and return it.
//            In this challenge, you must first implement a queue using two stacks. Then process  queries,
//            where each query is one of the following  types:
//
//            1 x: Enqueue element  into the end of the queue.
//            2: Dequeue the element at the front of the queue.
//            3: Print the element at the front of the queue.
//
//                    STDIN   Function
//            -----   --------
//            10      q = 10 (number of queries)
//            1 42    1st query, enqueue 42
//            2       dequeue front element
//            1 14    enqueue 42
//            3       print the front element
//            1 28    enqueue 28
//            3       print the front element
//            1 60    enqueue 60
//            1 78    enqueue 78
//            2       dequeue front element
//            2       dequeue front element

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(reader.readLine());

        QueueFromTwoStack.OurQueue queqe = new QueueFromTwoStack().new OurQueue();
        String input;

        for(; q > 0; q--){
            input = reader.readLine().trim();
            if(input.charAt(0) == '1'){
                String[] inputArr = input.split(" ");
                queqe.push(inputArr[1]);
            } else if(input.equals("2")){
                queqe.pop();
            } else if(input.equals("3")){
                queqe.print();
            }
        }
    }

    class OurQueue{
        Stack<String> input;
        Stack<String> output;

        public OurQueue(){
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(String value){
            input.push(value);
        }

        public String pop(){
            if(output.isEmpty()){
                while(!input.isEmpty()){
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        public void print(){
            if(output.isEmpty()){
                while(!input.isEmpty()){
                    output.push(input.pop());
                }
            }
            System.out.println(output.peek());
        }
    }
}

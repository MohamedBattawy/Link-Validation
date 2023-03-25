/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadsTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 
public class TestThreads {
    
    public static void main(String[] args) throws InterruptedException {
        PrintChar t1 =new PrintChar('A');
        PrintNumber t2=new PrintNumber();
        PrintChar t3 =new PrintChar('B');
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        t3.start();
        ExecutorService e=Executors.newFixedThreadPool(2);
        e.execute(t1);
        e.execute(t2);
        e.execute(t3);
        
        
    }
    
}

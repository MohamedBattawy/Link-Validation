/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadsTest;

import java.util.logging.Level;
import java.util.logging.Logger;

 
public class PrintNumber extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <=20; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintNumber.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

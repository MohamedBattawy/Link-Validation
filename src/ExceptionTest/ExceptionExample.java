package ExceptionTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class ExceptionExample {
    public static void main(String[] args) {
        
        int x=4;
        int y=0;
        int z;
        try 
        {
            z=x/y;
            System.out.println("After Try: "+z);
        }
        catch (NullPointerException e){
            System.out.println("Error");
        }
               
        
    }
}

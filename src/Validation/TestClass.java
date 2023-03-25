/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.io.IOException;


public class TestClass {

    public static void main(String[] args) throws IOException, InterruptedException {
        String link = "https://www.alexu.edu.eg/index.php/en/discover-au/4025-diamond-jubilee-celebrations-launch-in-alexandria-university";
        //   LinkValidation v=new LinkValidation();
        LinkValidation.validateURL(link, 0, 1);
    }

}

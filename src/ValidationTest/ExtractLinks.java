/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidationTest;

import java.io.IOException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

 
public class ExtractLinks {

    public static void main(String[] args) throws IOException {

        String link2 = "https://www.alexu.edu.eg/index.php/en/discover-au/4025-diamond-jubilee-celebrations-launch-in-alexandria-university";
        String link = "https://www.google.com";
        Document doc = Jsoup.connect(link2).get();
        Elements e = doc.select("a[href]"); // extract only links

        URL u = new URL(link2);
        System.out.println("Protocol: " + u.getProtocol());
        System.out.println("Host: " + u.getHost());
        String baseLINK = u.getProtocol() + "://" + u.getHost();
        System.out.println("BASE URL : " + baseLINK);
        //System.out.println(e.size());
        // System.out.println(doc.html());
        LinkValidation v = new LinkValidation();
        for (int i = 0; i < e.size(); i++) {
            String x = e.get(i).attr("href");

            if (!x.startsWith("http")) {
                x = baseLINK + x;
            }
            if (v.validateURL(x)) {
                System.out.println("Valid :  " + x);
            } else {
                System.out.println("InValid :  " + x);
            }

//                System.out.println(e.get(i));
        }
        //System.out.println(doc.html());

    }
}

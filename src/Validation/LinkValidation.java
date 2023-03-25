/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class LinkValidation {

    static ExecutorService es = Executors.newFixedThreadPool(100);

    public static void validateURL(String link, int currentdepth, int totaldepth) throws IOException, InterruptedException {
        ThreadValidate t1 = null, t2 = null;
        if (validateSingleURL(link)) {
            System.out.println("Valid Link " + link);
            if (currentdepth == totaldepth) {
                return;
            }
            Document doc = Jsoup.connect(link).get();
            Elements e = doc.select("a[href]"); // extract only links
            System.err.println("Count of Links:" + e.size());

            URL u = new URL(link);
            for (int i = 0; i < e.size(); i++) {
                String x = e.get(i).attr("href");
                String baseLINK = u.getProtocol() + "://" + u.getHost();
                if (!x.startsWith("http")) {
                    x = baseLINK + x;
                }
                t1 = new ThreadValidate(x, currentdepth + 1, totaldepth);
                 es.execute(t1);
//                t1.start();
//                i++;
//                if (i < e.size()) {
//                    x = e.get(i).attr("href");
//                    baseLINK = u.getProtocol() + "://" + u.getHost();
//                    if (!x.startsWith("http")) {
//                        x = baseLINK + x;
//                    }
//                    t2 = new ThreadValidate(x, currentdepth + 1, totaldepth);
//                    t2.start();
//                }

                //t1.join();
                //validateURL(x, currentdepth + 1, totaldepth);
            }
        } else {
            System.err.println("Invalid Link " + link);

        }

    }

    public static boolean validateSingleURL(String link) throws IOException {
        boolean valid = false;
        try {
            Document doc = Jsoup.connect(link).get();
            valid = true;
        } catch (HttpStatusException ex) {  // when returns 404 page not found
            valid = false;
        } catch (IOException ex) { // when timeout to connect to server not found
            valid = false;
        }
        return valid;
    }

//    private String[] getLinks(String link) {
//
//        Document doc = Jsoup.connect(link).get();
//        Elements e = doc.select("a[href]"); // extract only links
//
//        String links[] = new String[e.size()];
//   
//        return links;
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidationTest;

import java.io.IOException;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LinkValidation {

    public boolean validateURL(String link) throws IOException {
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
}

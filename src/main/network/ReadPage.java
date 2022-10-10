package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadPage {

    //Effects: access website and return the string that is on that website
    public static StringBuilder ReadPage() {

        BufferedReader br = null;

        try {
            String theURL = "'https://api.spotify.com/v1/search?type=album&include_external=audio'"; //this can point to any URL
            URL url = null;
            try {
                url = new URL(theURL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                br = new BufferedReader(new InputStreamReader(url.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            return sb;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}


import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class apitester {

    private static final String USER_AGENT = "Chrome/5.0";

   private static final String GET_URL = "http://127.0.0.1:8000/1/";
//
//   public static void main(String[] args) throws IOException {
//       mineBlock("d4735e3a265e16eee03f59718b9b5d03019c07d8b6c51f90da3a666eec13ab35", "maggiisdrugs");
//   }
    
    
    public static void mineBlock(String uniqueKey, String data){
    	String URL = "http://192.168.50.61:8000/1/"+uniqueKey+"/mine_block/"+data;
    	try{
    		sendHttpGETRequest(URL);
    		}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    

    private static void sendHttpGETRequest(String GET_URL) throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }

        for (int i = 1; i <= 8; i++) {
            System.out.println(httpURLConnection.getHeaderFieldKey(i) + " = " + httpURLConnection.getHeaderField(i));
        }

    }
}
package CommunicationsSubsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class HTTPRequest {

    private JSONObject json;
    private final String URL_STRING;
    private final static UUID uuid = UUID.randomUUID();
    
    public HTTPRequest() {
        URL_STRING = "http://dotpizza.azurewebsites.net/api/tictactoe/";
    }

    private static String readJsonFromUrl(String url) throws IOException, JSONException {
        BufferedReader myReader = null;
        try {
            char[] charURL = new char[1024];
            int charReadIndex;
            URL tictactoeURL = new URL(url);
            myReader = new BufferedReader(new InputStreamReader(tictactoeURL.openStream()));

            StringBuilder buffer = new StringBuilder();

            while ((charReadIndex = myReader.read(charURL)) != -1) {
                buffer.append(charURL, 0, charReadIndex);
            }

            return buffer.toString();
        } finally {
            myReader.close();
        }
    }

    public void get(TicTacToeData data) {
        try {
            json = new JSONObject(readJsonFromUrl(URL_STRING));
            HTTPGetInterface myInterface;

            myInterface = new GameBoard();
            String gameBoardString = myInterface.get(json);
            for (int i = 0; i < gameBoardString.length(); i++) {
                data.gameBoard[i] = gameBoardString.charAt(i);
            }

            myInterface = new GameStatistic();
            String turnString = myInterface.get(json);
            data.gameTurn = Integer.parseInt(turnString);

            myInterface = new GameStatus();
            String statusString = myInterface.get(json);
            data.gameMode = Boolean.parseBoolean(statusString.substring(0, statusString.indexOf("@")));
            data.gameWinner = statusString.substring(statusString.indexOf("@") + 1, statusString.length());
            
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void put(int pos) { //This PUT method will be for both normal and death match mode

        putClientUUID();
        
        try {

            String urlStringCopy = URL_STRING;
            urlStringCopy += pos;
            URL url = new URL(urlStringCopy);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "text/json");

            String input = "{"
                    + "\"Spot\": \"" + pos + "\", "
                    + "\"Token\": \"@\"" //Token will be overwritten when sent to the server
                    + "}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());

            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            throw new RuntimeException(e);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }
    
    private void putClientUUID() { //This PUT method will be for both normal and death match mode

        try {

            String urlStringCopy = URL_STRING;
            URL url = new URL(urlStringCopy);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "text/json");

            String input = "{"
                    + "\"ClientUUID\": \"" + uuid + "\""
                    + "}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            throw new RuntimeException(e);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }
}

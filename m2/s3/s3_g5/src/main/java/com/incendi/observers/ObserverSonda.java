package com.incendi.observers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.incendi.models.Response;
import com.incendi.models.Sonda;

@SuppressWarnings("deprecation")
public class ObserverSonda implements Observer {

    @Override
    public void update(Observable obs, Object sonda) {
        Sonda inputS = (Sonda) sonda;
        System.out.println("Livello del fumo " + inputS.getLivelloFumo());
        this.doCall(inputS);
    }

    private void doCall(Sonda s) {
        try {
            ObjectMapper objMap = new ObjectMapper();
            String jsonStr = objMap.writeValueAsString(s);

            URL endpoint = new URL("http://localhost:8081/api/alert");
            HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.addRequestProperty("Content-type", "application/json");

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonStr.getBytes("UTF-8");
                os.write(input, 0, input.length);
            }

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                System.out.println("Segnalazione dalla Sonda " + s.getName() + " effettuata con successo!");

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer res = new StringBuffer();

                while ((inputLine = br.readLine()) != null) {
                    res.append(inputLine);
                }
                br.close();

                ObjectMapper objectMapper = new ObjectMapper();
                Response response = objectMapper.readValue(res.toString(), Response.class);

                System.out.println(response.getMessage());

            } else {
                System.out.println("La segnalazione non è stata inoltrata con successo.. Brucierà tutto..!");
            }

            connection.disconnect();

        } catch (Exception ex) {
            System.out.println("** ERROR ** " + ex.getMessage());
        }
    }
}

package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeMap;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        TreeMap<Integer, Player> suomalaiset = new TreeMap<>(Collections.reverseOrder());
        
        System.out.println("Suomalaiset:");
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) suomalaiset.put(player.getGoals() + player.getAssists(), player);
        }
        for (Player player : suomalaiset.values()) {
            System.out.println(player);
        }  
    }
  
}
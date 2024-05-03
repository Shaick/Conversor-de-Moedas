import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import modelos.ExchangerateApi;
import modelos.Painel;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void
    main (String[] args) throws IOException, InterruptedException {

       boolean exit = true;
       
        Painel.clearConsole();
        System.out.println(Painel.getMesg());        

        do {
            @SuppressWarnings("resource")
            Scanner leitura = new Scanner(System.in);
            System.out.println("Digite uma opção válida: ");
            int cambio = leitura.nextInt();            
    
            if (cambio >= 0) {
                api(cambio);
            }else if(cambio > 14){
                System.out.println(" ");
                System.out.println("Opção Inválida...");
            }else {
                System.out.println(" ");
                System.out.println("Saindo do Programa...");
                System.exit(0);

            }
        }while(exit);        
    }

    static void api(int cambio) throws IOException, InterruptedException {
        String coin = "";
        String tocoin = "";

        switch (cambio) {
            case 0: System.out.println(" "); System.out.println("Saindo do Programa..."); System.exit(0);
            case 1: coin = "BRL"; tocoin = "USD"; call(coin, tocoin);       
                break;
            case 2: coin = "USD"; tocoin = "BRL"; call(coin, tocoin);               
                break;
            case 3: coin = "BRL"; tocoin = "ARS"; call(coin, tocoin);               
                break;
            case 4: coin = "ARS"; tocoin = "BRL"; call(coin, tocoin);               
                break;
            case 5: coin = "USD"; tocoin = "ARS"; call(coin, tocoin);               
                break;
            case 6: coin = "ARS"; tocoin = "USD"; call(coin, tocoin);               
                break;
            case 7: coin = "BRL"; tocoin = "OMR"; call(coin, tocoin);               
                break;
            case 8: coin = "OMR"; tocoin = "BRL"; call(coin, tocoin);               
                break;
            case 9: coin = "USD"; tocoin = "OMR"; call(coin, tocoin);               
                break;
            case 10: coin = "OMR"; tocoin = "USD"; call(coin, tocoin);               
                break;
            case 11: coin = "BRL"; tocoin = "JPY"; call(coin, tocoin);               
                break;
            case 12: coin = "JPY"; tocoin = "BRL"; call(coin, tocoin);               
                break;
            case 13: coin = "USD"; tocoin = "JPY"; call(coin, tocoin);               
                break;
            case 14: coin = "JPY"; tocoin = "USD"; call(coin, tocoin);               
                break;
        
            default: System.out.println("Opção Inválida...");
                break;
        }      
    }

    static void call(String coin, String tocoin) throws IOException, InterruptedException {
        String api_key = "7c70e6f67aa8f33374ede119";       
        String link = "https://v6.exchangerate-api.com/v6/"+ api_key +"/pair/"+ coin +"/"+ tocoin;

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(link)).build();
    
    
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
    
            String json = response.body();
    
            Gson gson = new Gson();
    
            ExchangerateApi rateApi = gson.fromJson(json, ExchangerateApi.class);
            System.out.println(rateApi.toString());

        } catch (JsonSyntaxException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import modelos.Titulo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
    public static void
    main (String[] args) throws IOException, InterruptedException {

        System.out.println("Bem vindo ao conversor de moedas");

        System.out.println("1) Real ¨ BRL ¨ R$ <---> Dolar ¨ USD ¨ U$$ ");
        System.out.println("2) Dolar ¨ USD ¨ U$$ <---> Real ¨ BRL ¨ R$ ");
        System.out.println("3) Real ¨ BRL ¨ R$ <---> Peso Argentino ¨ ARS ¨ $ ");
        System.out.println("4) Peso Argentino ¨ ARS ¨ $ <---> Real ¨ BRL ¨ R$ ");
        System.out.println("5) Dolar ¨ USD ¨ U$$ -> Peso Argentino ¨ ARS ¨ $ ");
        System.out.println("6) Peso Argentino ¨ ARS ¨ $ <---> Dolar ¨ USD ¨ U$$ ");
        System.out.println("7) Real ¨ BRL ¨ R$ <---> Rial Omani ¨ OMR ¨ ر.ع. ");
        System.out.println("8) Rial Omani ¨ OMR ¨ ر.ع. <---> Real ¨ BRL ¨ R$ ");
        System.out.println("9) Dolar ¨ USD ¨ U$$ <---> Rial Omani ¨ OMR ¨ ر.ع. ");
        System.out.println("10) Rial Omani ¨ OMR ¨ ر.ع. <---> Dolar ¨ USD ¨ U$$ ");
        System.out.println("11) Real ¨ BRL ¨ R$ <---> Iene Japonês ¨ JPY ¨ ¥ ");
        System.out.println("12) Iene Japonês ¨ JPY ¨ ¥ <---> Real ¨ BRL ¨ R$ ");
        System.out.println("13) Dolar ¨ USD ¨ U$$ <---> Iene Japonês ¨ JPY ¨ ¥ ");
        System.out.println("14) Iene Japonês ¨ JPY ¨ ¥ <---> Dolar ¨ USD ¨ U$$ ");

        try (Scanner leitura = new Scanner(System.in)) {
            System.out.println("Digite uma opção válida: ");
            var cambio = leitura.nextLine();

            String coin = "";
            String tocoin = "";

            switch (cambio) {
                case "1": coin = "BRL"; tocoin = "USD";           
                    break;
                case "2": coin = "USD"; tocoin = "BRL";                
                    break;
                case "3": coin = "BRL"; tocoin = "ARS";                
                    break;
                case "4": coin = "ARS"; tocoin = "BRL";                
                    break;
                case "5": coin = "USD"; tocoin = "ARS";                
                    break;
                case "6": coin = "ARS"; tocoin = "USD";                
                    break;
                case "7": coin = "BRL"; tocoin = "OMR";                
                    break;
                case "8": coin = "OMR"; tocoin = "BRL";                
                    break;
                case "9": coin = "USD"; tocoin = "OMR";                
                    break;
                case "10": coin = "OMR"; tocoin = "USD";                
                    break;
                case "11": coin = "BRL"; tocoin = "JPY";                
                    break;
                case "12": coin = "JPY"; tocoin = "BRL";                
                    break;
                case "13": coin = "USD"; tocoin = "JPY";                
                    break;
                case "14": coin = "JPY"; tocoin = "USD";                
                    break;
            
                default: coin = "BRL"; tocoin = "USD";
                    break;
            }

            String api_key = "7c70e6f67aa8f33374ede119";       
            String link = "https://v6.exchangerate-api.com/v6/"+ api_key +"/pair/"+ coin +"/"+ tocoin;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(link)).build();


            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new Gson();

            Titulo meuTitulo = gson.fromJson(json, Titulo.class);
            System.out.println(meuTitulo.toString());
        } catch (JsonSyntaxException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
}
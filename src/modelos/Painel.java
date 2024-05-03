package modelos;

public class Painel {

    public static String getMesg(){
        return """

            "Bem vindo ao conversor de moedas"
    
            "1) Real ¨ BRL ¨ R$ <---> Dolar ¨ USD ¨ U$$ "
            "2) Dolar ¨ USD ¨ U$$ <---> Real ¨ BRL ¨ R$ "
            "3) Real ¨ BRL ¨ R$ <---> Peso Argentino ¨ ARS ¨ $ "
            "4) Peso Argentino ¨ ARS ¨ $ <---> Real ¨ BRL ¨ R$ "
            "5) Dolar ¨ USD ¨ U$$ -> Peso Argentino ¨ ARS ¨ $ "
            "6) Peso Argentino ¨ ARS ¨ $ <---> Dolar ¨ USD ¨ U$$ "
            "7) Real ¨ BRL ¨ R$ <---> Rial Omani ¨ OMR ¨ ر.ع. "
            "8) Rial Omani ¨ OMR ¨ ر.ع. <---> Real ¨ BRL ¨ R$ "
            "9) Dolar ¨ USD ¨ U$$ <---> Rial Omani ¨ OMR ¨ ر.ع. "
            "10) Rial Omani ¨ OMR ¨ ر.ع. <---> Dolar ¨ USD ¨ U$$ "
            "11) Real ¨ BRL ¨ R$ <---> Iene Japonês ¨ JPY ¨ ¥ "
            "12) Iene Japonês ¨ JPY ¨ ¥ <---> Real ¨ BRL ¨ R$ "
            "13) Dolar ¨ USD ¨ U$$ <---> Iene Japonês ¨ JPY ¨ ¥ "
            "14) Iene Japonês ¨ JPY ¨ ¥ <---> Dolar ¨ USD ¨ U$$ "

            0) Sair ->
            
           """;
    }
    
    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
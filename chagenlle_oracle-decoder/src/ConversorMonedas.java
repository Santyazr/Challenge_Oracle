import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMonedas {



    public static void main(String[] args) throws IOException, InterruptedException {
        String menu = """
                \n************************************** 
                Bienvenido/a al Conversor de monedas=
                \n*** Escriba el numero de la opcion deseada ***
                1- Dolar =>> Peso argentino
                2- Peso argentino =>> Dolar
                3- Dolar =>> Real brasileño
                4- Real brasileño =>> Dolar
                5- Dolar =>> Peso colombiano
                6- Peso colombiano =>> Dolar
                7- SALIR
                Elija una opcion valida
                  \n************************************** 
                """;
        System.out.println(menu);
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 7) {
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    Conversion caso1 = new Conversion();
                    String caso1MonedaA;
                    String caso1MonedaB;
                    double numeroDeMonedas;
                    System.out.println("Ingrese las siglas de la moneda que tiene:");
                    caso1MonedaA = teclado.next();
                    System.out.println("Ingrese las siglas de la moneda que quiere convertir:");
                    caso1MonedaB = teclado.next();
                    caso1.setMonedaA(caso1MonedaA);
                    caso1.setMonedaB(caso1MonedaB);
                    System.out.println(caso1MonedaA);
                    caso1.setDireccion("https://v6.exchangerate-api.com/v6/b2690162d817e2ef53ec5af1/pair/" +
                            caso1.getMonedaA()+ "/" + caso1.getMonedaB());

                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(caso1.direccion))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();
                    System.out.println(json);

                    System.out.println("Ingrese cantidad a convertir");
                    numeroDeMonedas = teclado.nextInt();
                    caso1.setNumDeMonedasA(numeroDeMonedas);

                    Gson gson = new Gson();
                    JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

                    double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
                    caso1.setConversionRateMonedaB(conversionRate);
                    caso1.setConversionFinal(caso1.getNumDeMonedasA(), conversionRate);
//                    System.out.println(conversionRate);
//                    System.out.println(caso1.getConversionRateMonedaB());
//                    System.out.println(caso1.getNumDeMonedasA());
//                    System.out.println(caso1.getConversionFinal());

                    System.out.println("Usted tiene " + caso1.ConversionFinal() + caso1MonedaB);








                    break;

                case 2:



                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

            }


        }



    }

}
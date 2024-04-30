
import com.google.gson.Gson;
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
                ************************************** 
                Bienvenido/a al Conversor de monedas=
                \nA continuacion va poder elejir entre una amplia selccion de monedas con la que poder 
                  convertir su dinero
                \n Contamos con una amplia base de datos actiualizada que puede usar a su disposicion
                \n*** Escriba el numero de la opcion deseada ***
                1- Convertir moneda
                2- Lista de monedas disponibles 
                3- SALIR
                                
                Elija una opcion valida
                ************************************** 
                """;

        String menuFinal = """
                ************************************** 
                Muchas gracias por usar el programa
                Desea continuar?
                1.SI 2.No
                ************************************** 
                """;

        System.out.println(menu);
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 3) {
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    Conversion caso1 = new Conversion();
                    String caso1MonedaA;
                    String caso1MonedaB;
                    double numeroDeMonedas;
                    int opcionF;
                    System.out.println("Ingrese las siglas de la moneda que tiene:");
                    caso1MonedaA = teclado.next();
                    System.out.println("Ingrese las siglas de la moneda que quiere convertir:");
                    caso1MonedaB = teclado.next();
                    caso1.setMonedaA(caso1MonedaA);
                    caso1.setMonedaB(caso1MonedaB);
                    caso1.setDireccion("https://v6.exchangerate-api.com/v6/b2690162d817e2ef53ec5af1/pair/" +
                            caso1.getMonedaA() + "/" + caso1.getMonedaB());
                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(caso1.direccion))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());
                        String json = response.body();

                        System.out.println("Ingrese cantidad a convertir");
                        numeroDeMonedas = teclado.nextLong();
                        caso1.setNumDeMonedasA((long) numeroDeMonedas);

                        Gson gson = new Gson();
                        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

                        double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
                        caso1.setConversionRateMonedaB(conversionRate);
                        caso1.setConversionFinal(caso1.getNumDeMonedasA(), conversionRate);
                        System.out.printf("Conversion ==> %.0f %s Convertido a %.3f %s\n",
                                numeroDeMonedas, caso1MonedaA, caso1.ConversionFinal(), caso1MonedaB);
                        System.out.println(menuFinal);
                        opcionF = teclado.nextInt();
                        while (opcion != 3) {
                            if (opcionF == 1) {
                                System.out.println(menu);
                                break;
                            } else if (opcionF == 2) {
                                System.out.println("¡Hasta luego!");
                                opcion = 3;
                            } else {
                                System.out.println("Los valores no son válidos, vuelva a intentarlo");
                                opcionF = teclado.nextInt();

                            }
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Ocurrio un de tipeo, Escriba bien las siglas");
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error en la URI, verifique la direccion");
                    } catch (Exception e) {
                        System.out.println("Ocurrio un error inesperado");
                    }
                    System.out.println("Finalizo la ejecucion del programa");
                    break;

                case 2:
                    String listaDeMonedas = """
                ************************************** 
                            USD: Dolares Americanos  COP: Pesos Colombianos
                            EUR: Euros               GBP: Libras esterlinas
                            ARS: Pesos Argentinos    CAD: Dolares Canadienses
                            GBP: Libras esterlinas   AUD: Dolares Australianos
                            CAD: Dolares Canadienses JPY: Yenes
                            CLP: Pesos Chilenos      CNY: Yuanes
                            UYU: Pesos Uruguayos     INR: Rupias
                            PEN: Soles
                            BRL: Reales
                  \n************************************** 
                """;
                    System.out.println(listaDeMonedas);
                    System.out.println("1- Convertir moneda\n" +
                            "2- Lista de monedas disponibles \n" +
                            "3- SALIR");
                    break;

                case 3:

            }
        }
    }
}

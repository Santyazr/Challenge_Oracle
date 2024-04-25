import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tasa de conversión de dólar a euro (como ejemplo)
        double tasaConversion = 0.85;

        // Solicitar al usuario ingresar la cantidad en dólares
        System.out.print("Ingrese la cantidad en dólares$$$: ");
        double cantidadDolares = scanner.nextDouble();

        // Calcular la cantidad equivalente en euros
        double cantidadEuros = cantidadDolares * tasaConversion;

        // Mostrar el resultado al usuario
        System.out.println("La cantidad equivalente en euros es: " + cantidadEuros);

        scanner.close();
    }
}



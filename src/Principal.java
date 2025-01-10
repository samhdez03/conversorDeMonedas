import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        System.out.println("""
                *************************************************
                
                ¡Bienvenid@s a mi Conversor de Divisas!
                
                Instrucciones:
                1.- Ingrese el código de divisa de origen.
                2.- Ingrese el código de la divisa al que se va a convertir.
                3.- Ingrese la cantidad que desea convertir.
                
                ****  Códigos de divisas  ****
                
                ARS → Peso argentino
                BOB → Boliviano boliviano
                BRL → Real brasileño
                CLP → Peso chileno
                COP → Peso colombiano
                EUR → Euro
                GBP → Libra esterlina
                JPY → Yen japonés
                MXN → Peso mexicano
                USD → Dólar estadounidense
                UYU → Peso uruguayo
                
                → (Si ya no desea realizar una operación digite "fin")
                
                *************************************************
                """);

        while (true) {
            System.out.println("Ingrese el código de divisa de origen (o 'fin' para salir):");
            String original = lectura.nextLine();
            if (original.equalsIgnoreCase("fin")) break;

            System.out.println("Ingrese el código de la divisa a la que desea convertir (o 'fin' para salir):");
            String convertir = lectura.nextLine();
            if (convertir.equalsIgnoreCase("fin")) break;

            System.out.println("Ingrese el monto que desea convertir (o 'fin' para salir):");
            String cantidadInput = lectura.nextLine();
            if (cantidadInput.equalsIgnoreCase("fin")) break;

            try {
                double cantidad = Double.parseDouble(cantidadInput);

                Conversor conversor = new Conversor();
                var resultado = conversor.conversor(original, convertir, cantidad);

                System.out.println("El tipo de cambio de "
                        + "[" + original + "] a [" + convertir + "] es de: $" + resultado.conversion_rate() +
                        ", al día " + resultado.time_next_update_utc().substring(0, 17) +
                        "\nPor lo tanto, $" + cantidad + " "
                        + original + " es igual a $" + resultado.conversion_result() + " " + convertir);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido para la cantidad.");
            } catch (RuntimeException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }

        System.out.println("Gracias por usar el conversor, ¡vuelve pronto!");
    }
}

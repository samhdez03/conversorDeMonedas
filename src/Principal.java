import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        Gson gson = new Gson();

        System.out.println("""
                    *************************************************
                    
                    ¡Sea bienvendid@ al Conversor de Divisas!
                    Instrucciones:
                    1.- Ingrese el codigo de divisa de origen.
                    2.- Ingrese el codigo de la divisa al que se va a convertir la divisa de origen.
                    3.- Ingrese la cantidad a convertir.
                    
                    ****  Codigos de divisas  ****
                    
                    ARS → Peso argentino
                    BOB → Boliviano boliviano
                    BRL → Real brasileño
                    CLP → Peso chileno
                    COP → Peso colombiano
                    EUR → Euro
                    GBP → Libra esterlina
                    JPY → Yen japones
                    MXN → Peso mexicano
                    USD → Dolar estadounidense
                    UYU → Peso uruguayo
                    
                    → (Si desea finalizar el conversor, digite: "Salir" en cualquier momento)
                    
                    *************************************************
                    
                    Ingrese el codigo de divisa de origen:
                    """);
        try {
            var original = String.valueOf(lectura.nextLine());
            System.out.println("Ingrese el código de la divisa que desea obtener");
            var convertir = String.valueOf(lectura.nextLine());
            System.out.println("Ingrese la el monto que desee convertir");
            var cantidad = Integer.valueOf(lectura.nextLine());
            Conversor conversor = new Conversor();

            var resultado = conversor.conversor(original, convertir, cantidad);


            System.out.println("El tipo de cambio de "
                    +"["+original+"] a ["+convertir+"] es de: $"+resultado.conversion_rate()+
                    ", al día "+resultado.time_next_update_utc().substring(0,17)+
                    "\nPor lo tanto, $"+cantidad+" "
                    +original+" es igual a $"+resultado.conversion_result()+" "+convertir);


        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación");
        }



    }

}

import java.util.Scanner;

public class Principal {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = """
        ****************************************
        Sea bienvenido/a al Conversor de Monedas
        1) Dolar =>> Peso argentino
        2) Peso argentino =>> Dolar
        3) Dolar =>> Real brasileño
        4) Real brasileño =>> Dolar
        5) Dolar =>> Peso colombiano
        6) Peso colombiano =>> Dolar
        7) Salir
        Elija una opcion valida:
        ****************************************
        """;
        int numero = 0;
        while (numero != 7){
            System.out.println(menu);
            numero = teclado.nextInt();
            switch (numero){
                case 1:
                    convertir("USD", "ARS");
                    break;
                case 2:
                    convertir("ARS", "USD");
                    break;
                case 3:
                    convertir("USD", "BRL");
                    break;
                case 4:
                    convertir("BRL", "USD");
                    break;
                case 5:
                    convertir("USD", "COP");
                    break;
                case 6:
                    convertir("COP", "USD");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente");
            }
            System.out.println("Ha finalizado el programa");
        }

    }
    public static double obtenerCantidad(){
        double cantidad = teclado.nextDouble();
        if (cantidad < 0){
            System.out.println("Por favor, ingrese un valor positivo.");
        }
        return cantidad;
    }
    public static void convertir(String monedaOrigen, String monedaDestino) {
        try {
            ConsultaMoneda consulta = new ConsultaMoneda();
            System.out.printf("Ingrese la cantidad de %s a convertir: ", monedaOrigen);
            double cantidad = obtenerCantidad();

            TipoMoneda miMoneda = consulta.consultarMoneda(monedaOrigen, monedaDestino, cantidad);

            Moneda moneda = new Moneda(miMoneda);

            // Imprimir el resultado de la conversión
            System.out.printf("%.2f %s corresponde a %.2f %s%n",
                    cantidad,
                    monedaOrigen,
                    moneda.getResultado(),
                    monedaDestino
            );

        } catch (Exception e) {
            System.out.println("Falla em la conversión: " + e.getMessage());
        }
    }

}

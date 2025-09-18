import java.util.Scanner;

public class SupermercadoSimulacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== CAJA 1 ==========");
        System.out.print("Ingrese el numero de clientes en la cola: ");
        int clientes = sc.nextInt();

        double tiempoTotalGeneral = 0;

        for (int i = 1; i <= clientes; i++) {
            System.out.print("\nIngrese la cantidad de productos del cliente " + i + ": ");
            int productos = sc.nextInt();

            // Tiempo por productos (4 seg cada uno)
            double tiempoProductos = productos * 4;

            // Tiempo fijo de dar cambio (3 min 5 seg = 185 seg)
            double tiempoCobro = 185;

            // Tiempo total por cliente
            double tiempoCliente = tiempoProductos + tiempoCobro;

            // Convertir a minutos y segundos
            int minutos = (int) (tiempoCliente / 60);
            double segundos = tiempoCliente % 60;

            System.out.printf("Tiempo para atender al cliente %d: %d minutos %.2f segundos%n",
                    i, minutos, segundos);

            tiempoTotalGeneral += tiempoCliente;
        }

        // Calcular promedio por persona
        double promedio = tiempoTotalGeneral / clientes;
        int minProm = (int) (promedio / 60);
        double segProm = promedio % 60;

        System.out.printf("%nTiempo promedio por cliente: %d minutos %.2f segundos%n",
                minProm, segProm);

        sc.close();
    }
}
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Estudiante> listaEstudiantes = new ArrayList<>();

        // Llenar la lista con datos de estudiantes
        listaEstudiantes.add(new Estudiante("Juan", 20));
        listaEstudiantes.add(new Estudiante("María", 22));
        listaEstudiantes.add(new Estudiante("Pedro", 19));
        listaEstudiantes.add(new Estudiante("Ana", 21));
        listaEstudiantes.add(new Estudiante("Luis", 18));

        // Ejercicio 1: Filtrar y mostrar estudiantes mayores de 18 años
        System.out.println("Estudiantes mayores de 18 años:");
        listaEstudiantes.stream()
                .filter(estudiante -> estudiante.getEdad() >= 18)
                .forEach(estudiante -> System.out.println(estudiante));

        // Ejercicio 2: Modificar y mostrar nombres de estudiantes
        System.out.println("\nNombres de estudiantes con 'Sr.' agregado:");
        listaEstudiantes.stream()
                .map(estudiante -> new Estudiante("Sr. " + estudiante.getNombre(), estudiante.getEdad()))
                .forEach(estudiante -> System.out.println(estudiante));

        // Ejercicio 3: Calcular el promedio de edad de los estudiantes
        double promedioEdad = listaEstudiantes.stream()
                .mapToInt(Estudiante::getEdad)
                .average()
                .orElse(0.0); // En caso de que la lista esté vacía
        System.out.println("\nPromedio de edad de los estudiantes: " + promedioEdad);

        /**************************************(
         *
         * Uso de collect
         */
        List<Integer> numeros = new ArrayList<>();
        numeros.add(-3);
        numeros.add(2);
        numeros.add(31);
        numeros.add(5);
        numeros.add(41);
        numeros.add(55);
        numeros.add(97);
        numeros.add(53);
        numeros.add(64);
        numeros.add(88);

        System.out.println("numeros primos");
        List<Integer> numerosPrimos  = numeros.stream()
                .filter(Main::esPrimo) // solo los numeros primos
                .collect(Collectors.toList());

        for (int a = 0; a < numerosPrimos.size(); a ++ ) {
            System.out.println(numerosPrimos.get(a));
        }
        // orden ascendente

        System.out.println("numeros primos orden asc");

        List<Integer> numerosPrimosOrdenAscendente = numerosPrimos.stream()
                .sorted()
                .collect(Collectors.toList());

        for (int a = 0; a < numerosPrimos.size(); a ++ ) {
            System.out.println(numerosPrimosOrdenAscendente.get(a));
        }
        // orden descendente

        System.out.println("numeros primos orden desc");
        List<Integer> numerosPrimosOrdenDescendente = numerosPrimos.stream()
                .sorted(Comparator.reverseOrder())
                .filter(x -> x>=50)
                .collect(Collectors.toList());

        for (int a = 0; a < numerosPrimosOrdenDescendente.size(); a ++ ) {
            System.out.println(numerosPrimosOrdenDescendente.get(a));
        }


        /***
         *
         * ordenando listar por fechas
         */

        List<Transaccion> transaccions = new ArrayList<>();

        transaccions.add(new Transaccion(1, "Pago de TC", LocalDateTime.of(2023, 9, 17,8, 45, 9)));
        transaccions.add(new Transaccion(2, "Yape a luis", LocalDateTime.of(2023, 9, 5,10, 4, 9)));
        transaccions.add(new Transaccion(3, "Plin 987******", LocalDateTime.of(2023, 8, 1,22, 8, 9)));
        transaccions.add(new Transaccion(4, "Abono dad", LocalDateTime.of(2023, 8, 14,14, 5, 9)));

        // ordenar las transacciones por fecha de trx
        // orden ascendente
        transaccions.sort(Comparator.comparing(Transaccion::getFechaTransaccion));
        transaccions.forEach(System.out::println);

        // orden descendete

        transaccions.sort(Comparator.comparing(Transaccion::getFechaTransaccion).reversed());
        transaccions.forEach(System.out::println);
    }

    /**
     *  que tiene únicamente dos divisores positivos distintos: él mismo y el 1.
      * @param numero
     * @return
     */

    public static boolean esPrimo(Integer numero) {
        if (numero <= 1) {
            return false;
        }

        for (int a =  2 ; a * a <= numero  ; a++) {
            if (numero % a == 0) {
                return false; // no es primo
            }
        }

        return true;
    }
}
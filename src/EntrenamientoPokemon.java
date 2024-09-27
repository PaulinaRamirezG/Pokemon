import java.util.InputMismatchException;
import java.util.Scanner;

public class EntrenamientoPokemon {
    public static void entrenar() {
        Scanner scanner = new Scanner(System.in);
        Pokemon pokemon = null;
        int tipo = 0;

        System.out.println("Elige el tipo de Pokémon (1: Agua, 2: Fuego, 3: Eléctrico, 4: Acero): ");
        try {
            tipo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, introduce un número entero.");
            scanner.next(); // Limpiar el buffer del scanner
            scanner.close();
            return;
        }

        System.out.println("Ingresa el nombre de tu Pokémon: ");
        String nombre = scanner.nextLine();
        switch (tipo) {
            case 1:
                pokemon = new PokemonAgua(nombre);
                break;
            case 2:
                pokemon = new PokemonFuego(nombre);
                break;
            case 3:
                pokemon = new PokemonElectrico(nombre);
                break;
            default:
                System.out.println("Tipo de Pokémon no válido.");
                scanner.close();
                return;
        }

        while (true) {
            try {
                System.out.println("\n¿Qué deseas hacer " + pokemon.nombrePokemon + "?");
                System.out.println("1. Entrenar");
                System.out.println("2. Ver mis estadísticas");
                System.out.println("3. Evoluciones");
                System.out.println("4. Salir");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.println("¿Dinos el elemento del pokemón con el que vas a combatir " + pokemon.nombrePokemon + "?");
                        String tipoElemento = scanner.nextLine();
                        String mensaje = pokemon.entrenar(tipoElemento);
                        System.out.println(pokemon.nombrePokemon + " " + mensaje);
                        break;
                    case 2:
                        pokemon.mostrarEstadisticas();
                        break;
                    case 3:
                        pokemon.evolucionar();
                        break;
                    case 4:
                        System.out.println("¡Hasta luego!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número entero.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
    }

}

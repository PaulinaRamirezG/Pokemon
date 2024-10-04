import java.util.InputMismatchException;
import java.util.Scanner;

public class EntrenamientoPokemon {
    /**
     * Se escoge el tipo de pokemón que se desea entrenar
     */
    public static void escogerPokemon() {
        Scanner scanner = new Scanner(System.in);
        int tipoPokemon = 0;

        System.out.println("Elige el tipo de Pokémon (1: Agua, 2: Fuego, 3: Eléctrico, 4: Acero): ");
        try {
            tipoPokemon = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, introduce un número entero.");
            scanner.next(); // Limpiar el buffer del scanner
            scanner.close();
            return;
        }

        System.out.println("Ingresa el nombre de tu Pokémon: ");
        String nombre = scanner.nextLine();

        // Se crea la instancia del pokemon
        Pokemon pokemon = crearPokemon(tipoPokemon, nombre);

        if (pokemon != null) {
            entrenarPokemon(pokemon, scanner);
        }
        scanner.close();
    }

    /**
     * crea la instancia del pokemón
     * 
     * @param tipoPokemon
     * @param nombre
     * @return
     */
    private static Pokemon crearPokemon(int tipoPokemon, String nombre) {
        Pokemon pokemon = null;

        // Se crea la clase dependiendo del tipo de pokemón
        switch (tipoPokemon) {
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
        }
        return pokemon;
    }

    /**
     * Se entrena el pokemon
     * 
     * @param Pokemon
     * @param scanner
     */
    public static void entrenarPokemon(Pokemon pokemon, Scanner scanner) {
        while (true) {
            try {
                System.out.println("\n¿Qué deseas hacer " + pokemon.getNombrePokemon() + "?");
                System.out.println("1. Entrenar");
                System.out.println("2. Ver mis estadísticas");
                System.out.println("3. Evoluciones");
                System.out.println("4. Salir");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.println("¿Dinos el elemento del pokemón con el que vas a combatir "
                                + pokemon.getNombrePokemon() + "?");
                        String tipoElemento = scanner.nextLine();
                        String mensaje = pokemon.entrenar(tipoElemento);
                        System.out.println(pokemon.getNombrePokemon() + " " + mensaje);
                        break;
                    case 2:
                        pokemon.mostrarEstadisticas();
                        break;
                    case 3:
                        pokemon.evolucionar();
                        break;
                    case 4:
                        System.out.println("¡Hasta luego!");
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

public class PokemonFuego extends Pokemon {
    private static final int EFECTIVIDAD_ENTRENAMIENTO = 12;

    public PokemonFuego(String nombre) {
        super(nombre);

        setElementoEficazContra("acero");
        setElementoEficazContra("bicho");
        setElementoEficazContra("hielo");
        setElementoEficazContra("planta");

        setElementoDebil("agua");
        setElementoDebil("dragon");
        setElementoDebil("fuego");
        setElementoDebil("roca");

        setFuerza(8);
        setPoder(20);
        setVelocidad(15);
    }

    @Override
    public String entrenar(String elementoACombatir) {
        String mensaje = "Uy! lo dejaste en cenizas, tu oponente no pudo!";
        // el elemento determina el puntaje
        if (getElementosEficazContra().contains(elementoACombatir)) {
            // se triplican tus estadísticas
            setFuerza(getFuerza() * 3);
            setPoder(getPoder() * 2);
            setVelocidad(getVelocidad() * 1);
            mensaje = "Genial! tus estadísticas han mejorado";
        }

        if (elementosDebil.contains(elementoACombatir)) {
            // se disminuyen tus estadísticas
            setFuerza(getFuerza() - 2);
            setPoder(getPoder() - 3);
            setVelocidad(getVelocidad() - 1);
            mensaje = "Fiu! Fue una pelea dura y saliste aporreado, puedes mejorar!";
        }

        experiencia += EFECTIVIDAD_ENTRENAMIENTO;
        if (experiencia >= 100) {
            nivel++;
            experiencia = 0;
        }
        return mensaje;
    }
}

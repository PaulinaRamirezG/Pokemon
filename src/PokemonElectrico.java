public class PokemonElectrico extends Pokemon {
    private static final int EFECTIVIDAD_ENTRENAMIENTO = 8;

    public PokemonElectrico(String nombre) {
        super(nombre);

        setElementoEficazContra("agua");
        setElementoEficazContra("volador");

        setElementoDebil("eléctrico");
        setElementoDebil("dragon");
        setElementoDebil("planta");
        setElementoDebil("tierra");

        setFuerza(5);
        setPoder(10);
        setVelocidad(35);
    }

    @Override
    public String entrenar(String elementoACombatir) {
        String mensaje = "Uy! estuviste muy eléctrico, tu oponente no pudo!";
        // el elemento determina el puntaje
        if (getElementosEficazContra().contains(elementoACombatir)) {
            // se triplican tus estadísticas
            setFuerza(getFuerza() * 3);
            setPoder(getPoder() * 3);
            setVelocidad(getVelocidad() * 3);
            mensaje = "Genial! tu estadística se ha triplicado";
        }

        if (elementosDebil.contains(elementoACombatir)) {
            // se disminuyen tus estadísticas
            setFuerza(getFuerza() - 4);
            setPoder(getPoder() - 4);
            setVelocidad(getVelocidad() - 4);
            mensaje = "Fiu! Fue una pelea dura y saliste encalambrado, puedes mejorar!";
        }
        experiencia += EFECTIVIDAD_ENTRENAMIENTO;
        if (experiencia >= 100) {
            nivel++;
            experiencia = 0;
        }
        return mensaje;
    }
}

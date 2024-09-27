public class PokemonElectrico extends Pokemon {
    private static final int EFECTIVIDAD_ENTRENAMIENTO = 8;

    public PokemonElectrico(String nombre) {
        super(nombre);
    }

    @Override
    public String entrenar(String tipoElemento) {
        experiencia += EFECTIVIDAD_ENTRENAMIENTO;
        if (experiencia >= 100) {
            nivel++;
            experiencia = 0;
        }
        return "";
    }
}


public class PokemonAgua extends Pokemon {
    private static final int EFECTIVIDAD_ENTRENAMIENTO = 10;        

    // constructor
    public PokemonAgua(String nombre) {
        super(nombre);
        setElementoEficazContra("fuego");
        setElementoEficazContra("roca");
        setElementoEficazContra("tierra");

        setElementoDebil("agua");
        setElementoDebil("dragon");
        setElementoDebil("planta");

        setFuerza(10);
        setPoder(5);
        setVelocidad(15);
    }

    @Override
    public String entrenar(String elementoACombatir) {
        String mensaje = "Uy! fue una pelea muy pareja!";
        // el elemento determina el puntaje
        if(getElementosEficazContra().contains(elementoACombatir)){
            // se duplican tus estadísticas
            setFuerza(getFuerza()*2);
            setPoder(getPoder() *2);
            setVelocidad(getVelocidad()*2); 
            mensaje = "Genial! tu estadística se ha duplicado";
        }

        if(elementosDebil.contains(elementoACombatir)){
            // se disminuyen tus estadísticas
            setFuerza(getFuerza()-2);
            setPoder(getPoder() -2);
            setVelocidad(getVelocidad()-2); 
            mensaje = "Fiu! Fue una pelea dura y saliste con abolladuras, puedes mejorar!";
        }

        setExperiencia(getExperiencia() + EFECTIVIDAD_ENTRENAMIENTO);
        if (getExperiencia() >= 100) {
            setNivel(getNivel()+1);
            setExperiencia(0);
        }
        return mensaje;
    }
}

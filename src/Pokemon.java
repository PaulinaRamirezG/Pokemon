import java.util.HashSet;

public abstract class Pokemon {
    protected String nombrePokemon;
    protected int nivel;
    protected int experiencia;
    protected int poder;
    protected int fuerza;
    protected int velocidad;
    HashSet<String> elementosEficazContra = new HashSet<>();
    HashSet<String> elementosDebil = new HashSet<>();

    public Pokemon(String nombre) {
        this.nombrePokemon = nombre;
    }

    public abstract String entrenar(String tipoElemento);

    public void evolucionar() {
        if (nivel >= 5) {
            System.out.println(nombrePokemon + " ha evolucionado!");
            nivel++;
        }else{
            System.out.println(nombrePokemon + " lo siento, aún debes entrenar más para evolucionar");
        }
    }

    public void mostrarEstadisticas() {
        System.out.println("Nombre: " + this.nombrePokemon);
        System.out.println("Nivel: " + this.nivel);
        System.out.println("Experiencia: " + this.experiencia);
        System.out.println("Poder:" + this.poder);
        System.out.println("Fuerza:" + this.fuerza);
        System.out.println("Velocidad:" + this.velocidad);
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public HashSet<String> getElementosEficazContra() {
        return elementosEficazContra;
    }

    public void setElementoEficazContra(String elementoEficazContra) {
        this.elementosEficazContra.add(elementoEficazContra);
    }

    public HashSet<String> getElementosDebil() {
        return elementosDebil;
    }

    public void setElementoDebil(String elementoDebil) {
        this.elementosDebil.add(elementoDebil);
    }
}

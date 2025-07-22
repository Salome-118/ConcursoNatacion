package concurso;

public abstract class Participante {
    protected String nombre;
    protected int edad;
    protected String genero;
    protected boolean buenaSalud;
    protected String tipoEntidad;

    public Participante(String nombre, int edad, String genero, boolean buenaSalud, String tipoEntidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.buenaSalud = buenaSalud;
        this.tipoEntidad = tipoEntidad;
    }

    public boolean puedeParticipar() {
        return edad >= 18 && edad <= 25 && buenaSalud;
    }

    public abstract String getInfo();
}

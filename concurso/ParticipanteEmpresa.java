package concurso;

public class ParticipanteEmpresa extends Participante {
    private String nombreEmpresa;
    private String tipoEmpresa; // Pública o Privada

    public ParticipanteEmpresa(String nombre, int edad, String genero, boolean buenaSalud, String nombreEmpresa, String tipoEmpresa) {
        super(nombre, edad, genero, buenaSalud, "Empresa " + tipoEmpresa);
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEmpresa = tipoEmpresa;
    }

    @Override
    public String getInfo() {
        return tipoEmpresa + " - Nombre: " + nombre + ", Edad: " + edad + ", Género: " + genero +
                ", Salud: " + (buenaSalud ? "Buena" : "Mala") + ", Empresa: " + nombreEmpresa;
    }
}


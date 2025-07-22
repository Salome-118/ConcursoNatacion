package concurso;

import java.util.ArrayList;
import java.util.Scanner;

public class ConcursoNatacion {
    static ArrayList<Participante> participantes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Participantes por defecto (2 por tipo de entidad)
        participantes.add(new ParticipanteColegio("Diana", 22, "Femenino", false, "Colegio UE 24 de Julio"));
        participantes.add(new ParticipanteColegio("Fabricio", 25, "Masculino", true, "Colegio APCH"));

        participantes.add(new ParticipanteUniversidad("Fabiana", 18, "Femenino", true, "UCE"));
        participantes.add(new ParticipanteUniversidad("Alberto", 22, "Masculino", false, " Salesiana"));

        participantes.add(new ParticipanteEmpresa("Lupe", 21, "Femenino", false, "Empresa Lácteos El Bosque", "Pública"));
        participantes.add(new ParticipanteEmpresa("Angel", 24, "Masculino", true, "Empresa OMNILIFE", "Privada"));

        participantes.add(new ParticipanteSindicato("Juliana", 20, "Femenino", false, "Sindicato de Choferes"));
        participantes.add(new ParticipanteSindicato("Marcelo", 19, "Masculino", false, "Sindicato Fuentes"));
        int opcion;

        do {
            System.out.println("\n=== Concurso de Natación ===");
            System.out.println("1. Registrar nuevo participante");
            System.out.println("2. Ver todos los participantes");
            System.out.println("3. Ver participantes aptos");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrarParticipante();
                    break;
                case 2:
                    mostrarParticipantes(false);
                    break;
                case 3:
                    mostrarParticipantes(true);
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }

    public static void registrarParticipante() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        if (edad < 18 || edad > 25) {
            System.out.println("Edad fuera del rango permitido (18-25).");
            return;
        }

        System.out.print("Género: ");
        String genero = sc.nextLine();

        System.out.print("¿Condición de salud buena? (true/false): ");
        boolean salud = sc.nextBoolean();
        sc.nextLine();
        if (!salud) {
            System.out.println("No puede participar por salud no adecuada.");
            return;
        }

        System.out.println("Tipo de entidad:\n1. Colegio\n2. Universidad\n3. Empresa\n4. Sindicato");
        int tipo = sc.nextInt();
        sc.nextLine();

        Participante p = null;

        switch (tipo) {
            case 1:
                System.out.print("Nombre del colegio: ");
                String colegio = sc.nextLine();
                p = new ParticipanteColegio(nombre, edad, genero, salud, colegio);
                break;
            case 2:
                System.out.print("Nombre de la universidad: ");
                String universidad = sc.nextLine();
                p = new ParticipanteUniversidad(nombre, edad, genero, salud, universidad);
                break;
            case 3:
                System.out.print("Nombre de la empresa: ");
                String empresa = sc.nextLine();
                System.out.print("¿Es pública o privada?: ");
                String tipoEmp = sc.nextLine();
                p = new ParticipanteEmpresa(nombre, edad, genero, salud, empresa, tipoEmp);
                break;
            case 4:
                System.out.print("Tipo de sindicato: ");
                String sindicato = sc.nextLine();
                p = new ParticipanteSindicato(nombre, edad, genero, salud, sindicato);
                break;
            default:
                System.out.println("Tipo de entidad no válido.");
                return;
        }

        participantes.add(p);
        System.out.println("Participante registrado exitosamente.");
    }

    public static void mostrarParticipantes(boolean soloAptos) {
        if (participantes.isEmpty()) {
            System.out.println("No hay participantes registrados.");
            return;
        }

        for (Participante p : participantes) {
            if (!soloAptos || p.puedeParticipar()) {
                System.out.println(p.getInfo());
            }
        }
    }
}

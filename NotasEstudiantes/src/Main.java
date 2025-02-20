import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorEstudiantes gestor = new GestorEstudiantes();
        String id;
        String asignatura;
        Double calificacion;
        int opcion;

        do {
            System.out.println("""
                    MENÚ PRINCIPAL
                    1. Agregar estudiante
                    2. Agregar asignatura
                    3. Actualizar calificacion
                    4. Eliminar estudiante
                    5. Eliminar asignatura
                    6. Mostrar informacion de un estudiante
                    7. Calcular media de un estudiante
                    8. Mostrar todos los estudiantes
                    0. Terminar programa""");
            System.out.print("Introduce una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("El programa ha terminado.");
                    break;
                case 1:
                    System.out.print("Introduce un ID para el estudiante: ");
                    id = sc.next();
                    gestor.agregarEstudiante(id);
                    break;
                case 2:
                    System.out.print("Introduce un ID para el estudiante al que le quieras poner una asignatura: ");
                    id = sc.next();
                    System.out.println("Indica el nombre de la asignatura: ");
                    asignatura = sc.next();
                    gestor.agregarAsignatura(id, asignatura);
                    break;
                case 3:
                    System.out.print("Introduce un ID para el estudiante al que le quieras actualizar la nota: ");
                    id = sc.next();
                    System.out.println("Indica el nombre de la asignatura: ");
                    asignatura = sc.next();
                    System.out.println("Introduce la nueva nota: ");
                    calificacion = sc.nextDouble();
                    gestor.actualizarNota(id, asignatura, calificacion);
                    break;
                case 4:
                    System.out.println("Introduce el ID de un estudiante para eliminarlo: ");
                    id = sc.next();
                    gestor.eliminarEstudiante(id);
                    break;
                case 5:
                    System.out.println("Introduce el ID de un estudiante para eliminar una de sus asignaturas: ");
                    id = sc.next();
                    System.out.println("Introduce el nombre de una asignatura para eliminarla: ");
                    asignatura = sc.next();
                    gestor.eliminarAsignatura(id, asignatura);
                    break;
                case 6:
                    System.out.print("Introduce el ID del estudiante del que quieras obtener información: ");
                    id = sc.next();
                    gestor.mostrarInfoEstudiante(id);
                    break;
                case 7:
                    System.out.println("Introduce el ID para calcular su media: ");
                    id = sc.next();
                    gestor.calcularMedia(id);
                    break;
                case 8:
                    gestor.mostrarEstudiantes();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

            System.out.println("");
        } while (opcion != 0);
    }
}
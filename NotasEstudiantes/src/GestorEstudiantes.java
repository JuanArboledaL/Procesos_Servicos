import java.util.HashMap;
import java.util.Map;

public class GestorEstudiantes {

    HashMap<String, HashMap<String, Double>> map = new HashMap<>();
    Double nota = 0.0;

    public void agregarEstudiante(String id) {
        map.put(id, new HashMap<>());
        System.out.println("Nuevo estudiante agregado");
    }

    public void agregarAsignatura(String id, String asignatura) {
        if (map.containsKey(id)) {
            HashMap<String, Double> asignaturasMap = map.get(id);
            asignaturasMap.put(asignatura, 1.0);
            System.out.println("Asignatura agregada");
        } else {
            System.out.println("El estudiante no existe");
        }
    }

    public void actualizarNota(String id, String asignatura, Double nota) {
        for (Map.Entry<String, HashMap<String, Double>> entry : map.entrySet()) {
            if (entry.getKey().equals(id) && entry.getValue().containsKey(asignatura)) {
                HashMap<String, Double> asignaturasMap = map.get(id);
                asignaturasMap.put(asignatura, nota);
                System.out.println("Nota actualizada");
            } else {
                System.out.println("Asignatura no existe");
            }
        }
    }

    public void eliminarEstudiante(String id) {
        if (map.containsKey(id)) {
            map.remove(id);
            System.out.println("Estudiante eliminado");
        } else {
            System.out.println("El estudiante no existe");
        }
    }

    public void eliminarAsignatura(String id, String asignatura) {
        if (map.containsKey(id)) {
            if (map.get(id).containsKey(asignatura)) {
                map.get(id).remove(asignatura);
                System.out.println("Asignatura eliminada");
            } else {
                System.out.println("La asignatura no existe");
            }
        } else {
            System.out.println("El estudiante no existe");
        }
    }

    public void mostrarInfoEstudiante(String id) {
        System.out.println("Para el estudiante " + id);

        HashMap<String, Double> infoEstudiante = map.get(id);

        for (Map.Entry<String, Double> entry : infoEstudiante.entrySet()) {
            System.out.println("Asignatura: " + entry.getKey());
            System.out.println("Calificación: " + entry.getValue());
        }
    }

    public void calcularMedia(String id) {

        int cont = 0;

        for (Map.Entry<String, HashMap<String, Double>> entry : map.entrySet()) {
            if (entry.getKey().equals(id)) {
                nota += entry.getValue().get("nota");
                cont++;
            } else {
                System.out.println("Alumno no encontrado");
            }
        }

        System.out.println("La media del alumno con ID: " + id + " es: " + nota / cont);
    }

    public void mostrarEstudiantes() {
        for (Map.Entry<String, HashMap<String, Double>> entry : map.entrySet()) {
            System.out.println("Alumno: " + entry.getKey());
            System.out.println("Asignaturas: " + entry.getValue().size());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej2recuperacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Juanito
 */
public class Ej2Recuperacion {
    public static void main(String[] args) {

        Map<Asignatura, List<Alumno>> mapaAsignaturas = new HashMap<>();
        ArrayList<Alumno> alumnos1 = new ArrayList<>();
        ArrayList<Alumno> alumnos2 = new ArrayList<>();

        //lista de alumnos
        Alumno a1 = new Alumno("Arenas","Fernando","e.arenas@gmail.com");
        Alumno a2 = new Alumno("Velazques","Alberto","n.velazques@gmail.com");
        Alumno a3 = new Alumno("Cardenas","Juan","j.cardenas@gmail.com");
        Alumno a4 = new Alumno("Mujica","Carlos","c.mujica@gmail.com");

        //Lista de asignaturas
        Asignatura asignatura1 = new Asignatura("Leguaje",1);
        Asignatura asignatura2 = new Asignatura("BBDD",2);

        //Grupos de alumnado
        alumnos1.add(a1);
        alumnos1.add(a2);
        alumnos1.add(a3);
        alumnos2.add(a1);
        alumnos2.add(a4);

        mapaAsignaturas.put(asignatura1, alumnos1);
        mapaAsignaturas.put(asignatura2, alumnos2);
        pintarMapaAsignaturas(mapaAsignaturas);


    }

    public static void pintarMapaAsignaturas(Map<Asignatura, List<Alumno>> mapa) {

        for (int i = 0; i < mapa.size(); i++) {
            for (Map.Entry<Asignatura, List<Alumno>> entry : mapa.entrySet()) {
                List<Alumno> alumno = entry.getValue();
                Asignatura asignatura = entry.getKey();
                System.out.println(asignatura.getNombre() + " : ");
                for (int j = 0; j < alumno.size(); j++) {
                    System.out.println(alumno.get(j).getNombre());
                }
            }
        }

    }


    
}

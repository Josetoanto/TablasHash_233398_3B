import models.Bussines;
import models.HashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String line;
        String splitBy = ",";
        int id = 1;
        int errores = 0;
        HashMap hashMap = new HashMap();
        hashMap.inicializar();
        HashMap hashMap2 = new HashMap();
        hashMap2.inicializar();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        long diferencia = 0;
        do {
            System.out.println("---------------------------------------------");
            System.out.println("Menu");
            System.out.println("1.-Ingresar informacion a funcion hash 1");
            System.out.println("2.-Ingresar informacion a funcion hash 2");
            System.out.println("3.-Buscar");
            System.out.println("4.-Salir");
            System.out.println("---------------------------------------------");
            switch (scanner.nextInt()) {
                case 1:
                    long startTime = System.nanoTime(); // Tiempo inicial en nanosegundos
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
                        while ((line = br.readLine()) != null) {
                            String[] bussines = line.split(splitBy);
                            System.out.println("[" + id + "] Bussines [ID=" + bussines[0] + ", Name=" + bussines[1] + ", Address=" + bussines[2] + ", City=" + bussines[3] + ", State= " + bussines[4] + "]");
                            String idBussines = bussines[0];
                            String name = bussines[1];
                            String address = bussines[2];
                            String city = bussines[3];
                            Bussines newBussines = new Bussines(idBussines, name, address, city);
                            if (hashMap.putValue(idBussines, newBussines)) {
                                System.out.println("Agregado con exito");
                            } else {
                                System.out.println("Error");
                                errores++;
                            }
                            id++;
                        }
                        System.out.println("Errores: " + errores);
                        long endTime = System.nanoTime(); // Tiempo final después de ingresar datos en nanosegundos
                        long elapsedTime = endTime - startTime; // Tiempo total transcurrido en nanosegundos
                        System.out.println("Tiempo total de ingreso de datos: " + elapsedTime + " nanosegundos");
                        diferencia = elapsedTime;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    long startTime2 = System.nanoTime(); // Tiempo inicial en nanosegundos
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
                        while ((line = br.readLine()) != null) {
                            String[] bussines = line.split(splitBy);
                            String idBussines = bussines[0];
                            String name = bussines[1];
                            String address = bussines[2];
                            String city = bussines[3];
                            Bussines newBussines = new Bussines(idBussines, name, address, city);
                            if (!hashMap2.putValue2(idBussines, newBussines)) {
                                System.out.println("Error");
                                errores++;
                            }
                            id++;
                        }
                        System.out.println("Errores: " + errores);
                        long endTime = System.nanoTime(); // Tiempo final después de ingresar datos en nanosegundos
                        long elapsedTime = endTime - startTime2; // Tiempo total transcurrido en nanosegundos
                        System.out.println("Tiempo total de ingreso de datos: " + elapsedTime + " nanosegundos");
                        if (diferencia > elapsedTime){
                            System.out.println("Funcion mas rapida: 2");
                        } else  {
                            System.out.println("Funcion mas rapida: 1");
                        }
                        diferencia = diferencia - elapsedTime;
                        System.out.println("Tiempo de diferencia entre funcion hash 1 y funcion hash 2: " + diferencia + " nanosegundo");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Ingresa el ID de la empresa a buscar:");
                    String idBuscar = scanner.nextLine();
                    System.out.println("Funcion 1");
                    long tiempoInicial = System.nanoTime();
                    Bussines bussines = hashMap.searchBussines(idBuscar);
                    if (bussines != null){
                        System.out.println("Empresa encontrada");
                        System.out.println(bussines);
                    } else {
                        System.out.println("Empresa no encontrada");
                    }
                    long endTime = System.nanoTime();
                    long elapsedTime = endTime - tiempoInicial;
                    System.out.println("Tiempo de busqueda: " + elapsedTime + " nanosegundos" );
                    diferencia = elapsedTime;
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Funcion 2");
                    tiempoInicial = System.nanoTime();
                    bussines = hashMap2.searchBussines2(idBuscar);
                    if (bussines != null){
                        System.out.println("Empresa encontrada");
                        System.out.println(bussines);
                    } else {
                        System.out.println("Empresa no encontrada");
                    }
                    endTime = System.nanoTime();
                    elapsedTime = endTime - tiempoInicial;
                    System.out.println("Tiempo de busqueda: " + elapsedTime + " nanosegundos" );
                    if (diferencia > elapsedTime){
                        System.out.println("Funcion mas rapida: 2");
                    } else {
                        System.out.println("Funcion mas rapida: 1");
                    }
                    diferencia = diferencia - elapsedTime;
                    System.out.println("Diferencia de busqueda = " +  diferencia +" nanosegundos");
                    break;
                case 4:
                    run = false;
                    break;
            }
        } while (run);
    }
}

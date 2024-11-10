package laTierraDeLaFantasia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {

    // Cargar datos en Mapa (Grafo)
    public Mapa cargarDatosMapa(String rutaArchivo) throws Exception {
        Mapa mapa = Mapa.obtenerInstancia();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            
            // Leer la cantidad de pueblos
        	String lineaCantidadPueblos = lector.readLine().trim();           
            if (!esNumero(lineaCantidadPueblos)) {
                throw new IllegalArgumentException();
            }
            int cantidadPueblos = Integer.parseInt(lineaCantidadPueblos);
            mapa.setCantidadPueblos(cantidadPueblos);

            // Leer la información de cada pueblo                    
            for (int i = 0; i < cantidadPueblos; i++) {
                String lineaPueblo = lector.readLine();
                if (lineaPueblo == null || lineaPueblo.split(" ").length != 4) {
                    throw new IllegalArgumentException();
                }
                procesarPueblo(lineaPueblo);
            }

            // Leer la línea que indica el pueblo inicial y final
            String lineaInicioFin = lector.readLine();
            if (!lineaInicioFin.contains("->")) {
                throw new IllegalArgumentException();
            }
            procesarInicioFin(lineaInicioFin);

            // Leer las distancias entre los pueblos
            String lineaDistancia;
            while ((lineaDistancia = lector.readLine()) != null) {
                if (lineaDistancia.split(" ").length != 3) {
                    throw new IllegalArgumentException();
                }
                procesarDistancia(lineaDistancia);
            }
       
        }catch(FileNotFoundException E) {
        	throw new FileNotFoundException("Archivo no encontrado");
        }catch(IOException e) {
        	throw new IOException("io");
        }catch(IllegalArgumentException e) {
        	throw new IllegalArgumentException("Formato de archivo incorrecto");
        }

        return mapa;
    }

    // Procesar cada línea que tiene la información de pueblo
    private void procesarPueblo(String lineaPueblo) {
        String[] partes = lineaPueblo.split(" ");
        int id = Integer.parseInt(partes[0]);
        int habitantes = Integer.parseInt(partes[1]);
        String raza = partes[2];
        String tipo = partes[3]; // propio, aliado o enemigo

        Pueblo pueblo = new Pueblo(id, habitantes, Raza.valueOf(raza.toLowerCase()), TipoPueblo.valueOf(tipo.toLowerCase()));
        Mapa.obtenerInstancia().agregarPueblo(pueblo);
    }
    

    // Método para procesar la línea que indica el pueblo inicial y final
    private void procesarInicioFin(String lineaInicioFin) {
        String[] partes = lineaInicioFin.split(" -> ");
        int puebloInicial = Integer.parseInt(partes[0]);
        int puebloFinal = Integer.parseInt(partes[1]);

        Mapa.obtenerInstancia().setPuebloInicial(puebloInicial);
        Mapa.obtenerInstancia().setPuebloFinal(puebloFinal);
    }

    // Método para procesar cada línea que contiene la distancia entre dos pueblos
    private void procesarDistancia(String lineaDistancia) {
        String[] partes = lineaDistancia.split(" ");
        int origen = Integer.parseInt(partes[0]);
        int destino = Integer.parseInt(partes[1]);
        int distancia = Integer.parseInt(partes[2]);
        //////////////////////////////////////////////////////////////////////////////////solo demostrativo
        System.out.println(origen  +  " " + destino + " "+distancia);
        
        Mapa.obtenerInstancia().agregarCamino(origen, destino, distancia);
    }
    
    private boolean esNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


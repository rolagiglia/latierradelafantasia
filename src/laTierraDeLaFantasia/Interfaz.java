package laTierraDeLaFantasia;

import java.util.Scanner;

public class Interfaz {

	public void iniciar() throws Exception {

		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			System.out.println("Opciones:");
			System.out.println("1. Cargar archivo de mapa");
			System.out.println("2. Mostrar mapa Cargado");
			System.out.println("3. Ejecutar Mision!");
			System.out.print("Seleccione una opcion: ");
			int opcion = scanner.nextInt();
			scanner.nextLine(); // Consumir la nueva línea

			switch (opcion) {
			case 1:
				cargarArchivo(scanner);
				System.out.println("");
				break;
			case 2:
				mostrarCamino();
				System.out.println("");
				break;			
			case 3:
				ejecutarMision();
				System.out.println("");
				break;
			default:
				System.out.println("Opcion inválida. Intente nuevamente.");
			}
			System.out.println("Presione cualquier tecla para volver al menu...");
            scanner.nextLine(); 
		}
		scanner.close();
	}

	// Método para cargar el archivo de mapa
	private void cargarArchivo(Scanner scanner) throws Exception {
		LeerArchivo leerArchivo = new LeerArchivo();
		if (!mapaEstaVacio()) {
			System.out.println("Ya existe un mapa cargado. ¿Desea sobrescribir los datos? (S/N)");
			String respuesta = scanner.nextLine().toUpperCase();

			if (!respuesta.equals("S")) {
				System.out.println("Operacion cancelada. No se sobrescribio el mapa.");
				return;
			}
			Mapa.getInstancia().borrarMapa();
		}

		System.out.print("Ingrese la ruta del archivo de mapa: ");
		String rutaArchivo = scanner.nextLine();
		
		try {
		
		leerArchivo.cargarDatosMapa(rutaArchivo);
		
		System.out.println("Archivo cargado exitosamente.");
		
		}catch(Exception E) {
			System.out.println("\n"+E.getMessage()+"\n");
		}
		
	}
	
	private void mostrarCamino() {
		if(mapaEstaVacio())
			System.out.println("AUN NO SE HA CARGADO UN ARCHIVO DE MAPA");
		else
		{
			for(int i=1;i<Mapa.getInstancia().getCantidadPueblos()+1;i++) {
				if(Mapa.getInstancia().getPueblo(i)!=null) 
					System.out.println("Pueblo: " + Mapa.getInstancia().getPueblo(i));	
			}
		}
		System.out.println("");
	}

	
	private void ejecutarMision() {
		
		if(mapaEstaVacio())
			System.out.println("AUN NO SE HA CARGADO UN ARCHIVO DE MAPA");
		else
		{
			if(Mapa.getInstancia().getCaminoMenorCosto()!=null) {
				System.out.println("Existe un camino de " + 
									Mapa.getInstancia().getPuebloInicial() + " a " +
									Mapa.getInstancia().getPuebloFinal() + "\n, realizando mision....");
				Cruzada cruzada =  new Cruzada();
				if(cruzada.cruzada()!=0)
					System.out.println("MISION EXITOSA. \n"
							+ "Cantidad de guerreros que llegaron con vida: " + cruzada.getCantidadGuerrerosRestantes() + 
							"\nTiempo total: " + (Mapa.getInstancia().getCostoMinimoTotal()/10+ cruzada.getTiempoTotal()) + " dias " + 
							                    (Mapa.getInstancia().getCostoMinimoTotal()%10)*2.4 + " horas ");
				else
					System.out.println("EJERCITO PROPIO DERROTADO. LA MISION NO ES FACTIBLE");
				
			}
			else 
				System.out.println("NO HAY CAMINO");
		}
	}

	// Método auxiliar para verificar si el mapa ya tiene datos cargados
	private boolean mapaEstaVacio() {
		return Mapa.getInstancia().getCantidadPueblos() == 0; 																	
	}
}

package org.bfa.PruebaPOO.run;

import org.openxava.util.*;

/**
 * Ejecuta esta clase para arrancar la aplicación.
 */

public class PruebaPOO {

	public static void main(String[] args) throws Exception {
		// DBServer.start("bfa_testing"); // Para usar tu propia base de datos comenta esta línea y configura src/main/webapp/META-INF/context.xml
		AppServer.run("PruebaPOO"); // Usa AppServer.run("") para funcionar en el contexto raíz
	}

}

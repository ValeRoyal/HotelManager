package com.acm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal del proyecto.
 *
 * <p>Marca el punto de entrada de la aplicación Spring Boot.
 * Al ejecutarse, inicia el contexto de Spring, detecta componentes
 * y arranca la configuración automática del backend.</p>
 */
@SpringBootApplication
public class Main {

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args argumentos de línea de comandos (no se usan en este proyecto)
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
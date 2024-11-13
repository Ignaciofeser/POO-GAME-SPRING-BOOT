package org.example.controller;

import org.example.Game;
import org.example.Personajes.Personajes;
import java.util.Scanner;

public class GameController {

    private Game game;
    private Scanner scanner;

    public GameController() {
        this.game = new Game();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        game.iniciarJuego();
    }

    public void elegirClasePersonaje() {
        System.out.println("Seleccione una clase para su personaje:");
        System.out.println("1 - Guerrero");
        System.out.println("2 - Mago");
        System.out.println("3 - Paladín");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1 -> game.getEstado().agregarPersonaje(Personajes.GUERRERO);
            case 2 -> game.getEstado().agregarPersonaje(Personajes.MAGO);
            case 3 -> game.getEstado().agregarPersonaje(Personajes.PALADIN);
            default -> System.out.println("Opción inválida. Selección por defecto: Guerrero.");
        }
    }

    public void elegirCamino() {
        System.out.println("Seleccione un camino para su aventura:");
        System.out.println("1 - Bosque Sombrío");
        System.out.println("2 - Templo en Ruinas");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1 -> game.manejarCaminoBosque();
            case 2 -> game.manejarCaminoRuinas();
            default -> System.out.println("Opción no válida.");
        }
    }

    public void manejarProgresionBosque() {
        System.out.println("¿Desea continuar en el bosque?");
        System.out.println("1 - Profundidades del bosque");
        System.out.println("2 - Laberinto");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1 -> game.manejarCaminoProfundidadesDelBosque();
            case 2 -> game.manejarCaminoLaberinto();
            default -> System.out.println("Opción no válida.");
        }
    }

    public void manejarProgresionRuinas() {
        System.out.println("¿Desea continuar en las ruinas?");
        System.out.println("1 - Portal Tenebroso");
        System.out.println("2 - Profundidades de la Cueva");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1 -> game.manejarCaminoPortal();
            case 2 -> game.manejarCaminoProfundidadesDeLaCueva();
            default -> System.out.println("Opción no válida.");
        }
    }

    public void finalizarJuego() {
        System.out.println("Gracias por jugar. ¡Hasta la próxima aventura!");
        scanner.close();
    }
}

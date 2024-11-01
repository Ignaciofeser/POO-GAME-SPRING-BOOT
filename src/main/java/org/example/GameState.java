package org.example;

import org.example.Personajes.MainCharacter;
import org.example.Personajes.Npc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameState {
    private List<MainCharacter> personajes;
    private List<Npc> personajesNpc;
    private int monedas;
    private boolean gameOver = false;

    public GameState() {
        this.personajes = new ArrayList<>();
        this.personajesNpc = new ArrayList<>();
        this.monedas = 0;
        this.gameOver = gameOver;
    }

    // Método para agregar personajes jugables
    public void agregarPersonaje(MainCharacter personaje) {
        personajes.add(personaje);
    }

    // Método para agregar NPCs
    public void agregarNpc(Npc npc) {
        personajesNpc.add(npc);
    }

    // Método para obtener el personaje actual
    public MainCharacter getPersonajeActual() {
        if (personajes.isEmpty()) {
            System.out.println(ConsoleColors.RED_BRIGHT + "No hay personajes en el juego." + ConsoleColors.RESET);
            return null;
        }
        return personajes.getFirst();
    }


    // Método para mostrar el estado actual de todos los personajes y NPCs
    public void mostrarEstado() {
        if (personajes.isEmpty() && personajesNpc.isEmpty()) {
            System.out.println(ConsoleColors.RED_BRIGHT + "No hay personajes ni NPCs en el juego." + ConsoleColors.RESET);
            return;
        }

        System.out.println("Estado actual del juego:");
        System.out.println("------------");

        for (MainCharacter p : personajes) {
            System.out.println(ConsoleColors.GREEN_BOLD + p + ConsoleColors.RESET);
            System.out.println("------------");
        }

        for (Npc npc : personajesNpc) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + npc + ConsoleColors.RESET);
            System.out.println("------------");
        }
    }


    // Método para ganar monedas después de cada combate
    public void ganarMonedas() {
        int recompensa = (int) (Math.random() * 50 + 25);
        monedas += recompensa;
        System.out.println("Has ganado " + ConsoleColors.BLUE_BOLD + recompensa + ConsoleColors.RESET + " monedas. Total: " + ConsoleColors.BLUE_BOLD + monedas + ConsoleColors.RESET + " monedas.");
    }

    // Método para visitar la tienda
    public void visitarTienda() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println(ConsoleColors.BLUE_BACKGROUND + "¡Has encontrado una tienda misteriosa! Puedes comprar lo siguiente:" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "1. Pociones de vida (50 monedas)" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "2. Pociones de mana (50 monedas)" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "3. Mejorar habilidad especial (100 monedas)" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "4. Salir de la tienda" + ConsoleColors.RESET);

            int eleccion = scanner.nextInt();

            switch (eleccion) {
                case 1 -> {
                    if (monedas >= 50) {
                        monedas -= 50;
                        getPersonajeActual().restaurarSalud();
                        System.out.println(ConsoleColors.PURPLE_BOLD + "Has comprado una poción de vida." + ConsoleColors.RESET );
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD + "No tienes suficientes monedas." + ConsoleColors.RESET );
                    }
                }
                case 2 -> {
                    if (monedas >= 50) {
                        monedas -= 50;
                        getPersonajeActual().restaurarMana();
                        System.out.println(ConsoleColors.PURPLE_BOLD + "Has comprado una poción de mana." + ConsoleColors.RESET );
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD + "No tienes suficientes monedas." + ConsoleColors.RESET );
                    }
                }
                case 3 -> {
                    if (monedas >= 100) {
                        monedas -= 100;
                        getPersonajeActual().mejorarHabilidadEspecial();
                        System.out.println(ConsoleColors.PURPLE_BOLD + "Has mejorado tu habilidad especial." + ConsoleColors.RESET );
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD + "No tienes suficientes monedas." + ConsoleColors.RESET );
                    }
                }
                case 4 -> {
                    System.out.println(ConsoleColors.PURPLE_BOLD + "Has salido de la tienda." + ConsoleColors.RESET );
                    salir = true;
                }
                default -> System.out.println(ConsoleColors.RED_BOLD + "Elección no válida." + ConsoleColors.RESET );
            }

            if (!salir) {
                System.out.println("Te quedan " + ConsoleColors.BLUE_BOLD + monedas + ConsoleColors.RESET + " monedas.");
            }
        }
    }


    public boolean setGameOver(boolean gameOver) {
        return gameOver;
    }


    // Método para remover un NPC
    public void removerNpc(Npc npc) {
        personajesNpc.remove(npc);
    }

    @Override
    public String toString() {
        return null;
    }
}



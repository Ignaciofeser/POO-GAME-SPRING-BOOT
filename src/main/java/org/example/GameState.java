package org.example;

import org.example.Personajes.Enemigos;
import org.example.Personajes.Personajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameState {
    private List<Personajes> personajes;
    private List<Enemigos> enemigos;
    private int monedas;

    public GameState() {
        this.personajes = new ArrayList<>();
        this.enemigos = new ArrayList<>();
        this.monedas = 0;
    }

    public void agregarPersonaje(Personajes personaje) {
        personajes.add(personaje);
    }

    public void agregarNpc(Enemigos enemigo) {
        enemigos.add(enemigo);
    }

    public Personajes getPersonajeActual() {
        if (personajes.isEmpty()) {
            System.out.println(ConsoleColors.RED_BRIGHT + "No hay personajes en el juego." + ConsoleColors.RESET);
            return null;
        }
        return personajes.get(0); // Cambiado a `get(0)`
    }

    // Mostrar el estado actual del juego
    public void mostrarEstado() {
        if (personajes.isEmpty() && enemigos.isEmpty()) {
            System.out.println(ConsoleColors.RED_BRIGHT + "No hay personajes ni NPCs en el juego." + ConsoleColors.RESET);
            return;
        }

        System.out.println("Estado actual del juego:");
        System.out.println("------------");

        for (Personajes p : personajes) {
            System.out.println(ConsoleColors.GREEN_BOLD + p.getNombre() + ConsoleColors.RESET);
            System.out.println("Salud: " + ConsoleColors.GREEN_BOLD + p.getSaludActual() + "/" + p.getSaludMax() + ConsoleColors.RESET);
            System.out.println("Daño: " + ConsoleColors.YELLOW_BOLD + p.getFuerza() + ConsoleColors.RESET);
            System.out.println("Mana: " + ConsoleColors.BLUE_BOLD + p.getMana() + "/" + p.getManaMax() + ConsoleColors.RESET);
            System.out.println("------------");
        }

        for (Enemigos enemigos : enemigos) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + enemigos.getNombre() + ConsoleColors.RESET);
            System.out.println("Salud: " + ConsoleColors.GREEN_BOLD + enemigos.getSaludActual() + "/" + enemigos.getSaludMax() + ConsoleColors.RESET);
            System.out.println("Daño: " + ConsoleColors.YELLOW_BOLD + enemigos.getFuerza() + ConsoleColors.RESET);
            System.out.println("------------");
        }
    }



    public void ganarMonedas() {
        int recompensa = (int) (Math.random() * 50 + 25);
        monedas += recompensa;
        System.out.println("Has ganado " + ConsoleColors.BLUE_BOLD + recompensa + ConsoleColors.RESET + " monedas. Total: " + ConsoleColors.BLUE_BOLD + monedas + ConsoleColors.RESET + " monedas.");
    }


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
                        getPersonajeActual().setManaMax();
                        System.out.println(ConsoleColors.PURPLE_BOLD + "Has comprado una poción de mana." + ConsoleColors.RESET );
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD + "No tienes suficientes monedas." + ConsoleColors.RESET );
                    }
                }
                case 3 -> {
                    if (monedas >= 100) {
                        monedas -= 100;
                        getPersonajeActual().setMultiplicadorHabilidadEspecial();
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

  /*  public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }*/


    public void removerNpc(Enemigos npc) {
        enemigos.remove(npc);
    }

    @Override
    public String toString() {
        return "GameState{" +
                "personajes=" + personajes +
                ", personajesNpc=" + enemigos +
                ", monedas=" + monedas +
                ", gameOver=" + isGameOver() +
                '}';
    }


    public boolean isGameOver() {
        return false;
    }
}

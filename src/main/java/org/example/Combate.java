package org.example;

import org.example.Personajes.MainCharacter;
import org.example.Personajes.Npc;
import java.util.Random;
import java.util.Scanner;

public class Combate {

    // Logica de combate
    public static void combate(GameState estado, Npc enemigo) {
        Scanner scanner = new Scanner(System.in);
        MainCharacter jugador = estado.getPersonajeActual();
        Random random = new Random();
        System.out.println();
        System.out.println(ConsoleColors.YELLOW_BACKGROUND + "¡Prepárate para pelear!" + ConsoleColors.RESET);
        System.out.println();

        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            estado.mostrarEstado();

            System.out.println(ConsoleColors.YELLOW_UNDERLINED + "Es tu turno. Elige una acción:" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "1. Ataque normal" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "2. Habilidad especial" + ConsoleColors.RESET);
            int accion = scanner.nextInt();

            int probabilidad = random.nextInt(100);

            if (accion == 1) {
                if (probabilidad < 75) {
                    int danio = jugador.atacar(enemigo);

                    System.out.println("Atacaste a " + enemigo.getNombre() + " y causaste " + ConsoleColors.GREEN_BOLD_BRIGHT + danio + ConsoleColors.RESET + " de daño.");
                  
                } else {
                    System.out.println(ConsoleColors.RED_BRIGHT + "Has fallado el ataque." + ConsoleColors.RESET);
                }
            } else if (accion == 2) {
                if (probabilidad < 90) {
                    if (jugador.usarHabilidadEspecial(enemigo)) {
                        System.out.println("Usaste una habilidad especial en " + enemigo.getNombre() + ".");
                    } else {
                        System.out.println(ConsoleColors.RED_BRIGHT + "Fallaste al usar tu habilidad especial." + ConsoleColors.RESET);
                    }
                }
            } else {
                System.out.println(ConsoleColors.RED_BRIGHT + "Acción no válida." + ConsoleColors.RESET);
            }

            if (enemigo.getSalud() <= 0) {
                System.out.println();
                System.out.println(ConsoleColors.WHITE_BACKGROUND + "Has derrotado a " + enemigo.getNombre() + "!" + ConsoleColors.RESET);
                System.out.println();
                estado.removerNpc(enemigo);
                break;
            }

            System.out.println(ConsoleColors.CYAN_BOLD + "Es el turno del enemigo." + ConsoleColors.RESET);

            probabilidad = random.nextInt(100);

            if (probabilidad < 20) {
                enemigo.habilidadEspecialNpc(jugador);
                System.out.println("El enemigo " + ConsoleColors.RED_BOLD + enemigo.getNombre() + ConsoleColors.RESET + " usó su habilidad especial.");
            } else {
                int danioRecibido = enemigo.atacar(jugador);
                System.out.println("El enemigo " + ConsoleColors.RED_BOLD + enemigo.getNombre() + ConsoleColors.RESET + " te atacó y causó " + ConsoleColors.RED_BRIGHT + danioRecibido + ConsoleColors.RESET + " de daño.");
            }

            if (jugador.getSalud() <= 0) {

                System.out.println(ConsoleColors.RED_BACKGROUND + "Fin del juego." + ConsoleColors.RESET);
                estado.setGameOver(true);

                break;
            }

            jugador.regenerarMana();
        }


    }
}




package org.example.Personajes.PJ;

import org.example.ConsoleColors;
import org.example.Personaje;
import org.example.Personajes.MainCharacter;

import java.io.Console;

public class Mago extends MainCharacter {
    public Mago() {
        super("Mago", 110, 20, 5, 100, 200, 50,1);}

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        if (getMana() >= getManaHabilidad()) {
            System.out.println(ConsoleColors.GREEN_BOLD + getNombre() + ConsoleColors.RESET + " lanza una bola de fuego!");
            int danio = getFuerza() * 3;  // La bola de fuego hace 3 veces su fuerza en daño
            objetivo.recibirDanio(danio);
            System.out.println(objetivo.getNombre() + " recibe " + ConsoleColors.GREEN_BOLD_BRIGHT + danio + ConsoleColors.RESET + " puntos de daño.");
            setMana(getMana() - getManaHabilidad());  // Consumir el mana necesario para la habilidad
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "No hay suficiente mana para lanzar la bola de fuego." + ConsoleColors.RESET);
        }
    }
}
package org.example.Personajes.PJ;

import org.example.ConsoleColors;
import org.example.Personaje;
import org.example.Personajes.MainCharacter;

public class Guerrero extends MainCharacter {
    public Guerrero() {
        super("Guerrero", 160, 30, 18, 25, 50, 25, 1);
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        if (getMana() >= getManaHabilidad()) {
            int danio = (int) (getFuerza() * 2 * getMultiplicadorHabilidadEspecial());
            System.out.println(ConsoleColors.GREEN_BOLD + getNombre() + ConsoleColors.RESET + " usa Golpe Devastador, causando " + ConsoleColors.GREEN_BOLD_BRIGHT + danio + ConsoleColors.RESET + " de daño a " + objetivo.getNombre());
            objetivo.recibirDanio(danio);
            setMana(getMana() - getManaHabilidad());
        } else {
            System.out.println("No hay suficiente mana para usar Golpe Devastador.");
        }
    }
}
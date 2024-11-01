package org.example.Personajes.NPC;

import org.example.ConsoleColors;
import org.example.Personajes.MainCharacter;
import org.example.Personajes.Npc;

public class Espectro extends Npc {
    public Espectro() {
        super("Espectro", 100, 25, 0);
    }

    @Override
    public void habilidadEspecialNpc(MainCharacter jugador) {
        int danio = 15;
        jugador.recibirDanio(danio);
        int saludActual = getSalud();
        int saludMax = getSaludMax();
        setSalud(Math.min(saludActual + danio, saludMax));
        System.out.println(getNombre() + " usa Drenaje de Alma, absorbiendo " + ConsoleColors.RED_BRIGHT + danio + ConsoleColors.RESET + " de salud del jugador.");
        System.out.println(jugador.getNombre() + " ha perdido " + ConsoleColors.RED_BRIGHT + danio + ConsoleColors.RESET + " puntos de salud.");
        System.out.println(getNombre() + " ha recuperado " + ConsoleColors.RED_BRIGHT + danio + ConsoleColors.RESET + " puntos de salud.");
    }
}

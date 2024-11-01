package org.example.Personajes.NPC;

import org.example.Personajes.MainCharacter;
import org.example.Personajes.Npc;

public class AnacondaGigante extends Npc {
    public AnacondaGigante() {super("Eunectes", 100, 20, 5);
    }
 /*   @Override
    public void habilidadEspecialNpc(MainCharacter jugador) {
        int saludMax = getSaludMax();
        int saludActual = getSalud();
        int curacion = (int) (saludMax * 0.25);
        setSalud(Math.min(saludActual + curacion, saludMax));
        System.out.println(getNombre() + " usa Regeneración, recuperando un 25% de su salud máxima.");
    }*/
}
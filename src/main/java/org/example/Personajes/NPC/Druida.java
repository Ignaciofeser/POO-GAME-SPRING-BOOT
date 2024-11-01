package org.example.Personajes.NPC;
import org.example.Personajes.MainCharacter;
import org.example.Personajes.Npc;

public class Druida extends Npc {
    public Druida() {super("Druida", 75, 20, 17);
    }

    @Override
    public void habilidadEspecialNpc(MainCharacter jugador) {
        int saludMax = getSaludMax();
        int saludActual = getSalud();
        int curacion = (int) (saludMax * 0.10);
        setSalud(Math.min(saludActual + curacion, saludMax));
        System.out.println(getNombre() + " usa Planta Protectora, obteniendo un escudo del 50% de su salud máxima.");
    }
}
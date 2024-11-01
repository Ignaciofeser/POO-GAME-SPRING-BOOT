package org.example.Personajes.NPC;
import org.example.Personaje;
import org.example.Personajes.MainCharacter;
import org.example.Personajes.Npc;

public class Golem extends Npc {
    public Golem() {
        super("Golem", 150, 20, 10);
    }

    @Override
    public void habilidadEspecialNpc(MainCharacter jugador) {
        System.out.println(getNombre() + " usa Piel de Piedra, aumentando su defensa en un 10%.");
        this.defensa += (int) (this.defensa * 0.10);
    }

}

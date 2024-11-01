package org.example.Personajes.NPC;
import org.example.ConsoleColors;
import org.example.Personajes.Npc;
import org.example.Personajes.MainCharacter;

public class Goblin extends Npc {
    public Goblin() {
        super("Goblin", 75, 20, 8);
    }

    @Override
    public void habilidadEspecialNpc(MainCharacter jugador) {
        int danio = getFuerza() * 2;
        System.out.println(getNombre() + " usa Doble Ataque, causando " + ConsoleColors.RED_BRIGHT + danio + ConsoleColors.RESET + " de daño a " + jugador.getNombre());
        jugador.recibirDanio(danio);
    }

}

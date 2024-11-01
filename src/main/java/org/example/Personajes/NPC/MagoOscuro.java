package org.example.Personajes.NPC;
import org.example.ConsoleColors;
import org.example.Personaje;
import org.example.Personajes.MainCharacter;
import org.example.Personajes.Npc;

public class MagoOscuro extends Npc {
    public MagoOscuro() {
        super("Mago Oscuro", 80, 25, 5);
    }

    @Override
    public void habilidadEspecialNpc(MainCharacter jugador) {
        int danio = getFuerza() * 2;
        System.out.println(getNombre() + " te lanza una Poción Explosiva, causando " + ConsoleColors.RED_BRIGHT + danio + ConsoleColors.RESET + " de daño a " + jugador.getNombre());
        jugador.recibirDanio(danio);
    }
}
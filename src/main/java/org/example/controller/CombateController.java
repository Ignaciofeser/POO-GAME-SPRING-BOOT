package org.example.controller;

import org.example.GameState;
import org.example.Personajes.Enemigos;
import org.example.Combate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/combate")
public class CombateController {

    @Autowired
    private GameState estado;

    // Endpoint para iniciar un combate contra un enemigo específico
    @PostMapping("/iniciar")
    public String iniciarCombate(@RequestBody Enemigos enemigo) {
        if (estado.isGameOver()) {
            return "El juego ha terminado. Por favor, reinicia para jugar de nuevo.";
        }

        // Llama al método combate de la clase Combate
        Combate.combate(estado, enemigo);

        // Verifica si el juego continúa o ha finalizado
        if (estado.isGameOver()) {
            return "Fin del juego. Has sido derrotado.";
        } else if (enemigo.getSaludActual() <= 0) {
            return "¡Has derrotado al enemigo " + enemigo.getNombre() + "!";
        } else {
            return "Combate en progreso.";
        }
    }
}

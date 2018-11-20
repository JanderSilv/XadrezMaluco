
package com.xadrez.pecas;

import com.xadrez.core.Peca;
import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;

/**
 *
 * @author Jafe
 */

public class PaiDeTodos extends Peca {

    public Necromancer(Position posicao, int time) {
        super(1, "PaiDeTodos", posicao, time);
        CriarMovimentacao();
    }

    @Override
    public void CriarMovimentacao() {
      movimentacao.Add(new MovTree(0, 1)).Add(new MovTree(0,2)); // Movimentação para frente.
      movimentacao.Add(new MovTree(0, -1)).Add(new MovTree(0,-2)); // Movimentação para tras.
      movimentacao.Add(new MovTree(1, 0)).Add(new MovTree(2,0)); // Movimentação para direita.
      movimentacao.Add(new MovTree(-1, 0)).Add(new MovTree(-2,0)); // Movimentação para esquerda.
    }    
}

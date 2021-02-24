package lp2.projetofinal.orders;

/**
 * Classe responsavel por implementar a interface Comparator e criar um criterio de comparacao para itens. 
 * Criterio pelo preco do item.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import java.util.Comparator;

import lp2.projetofinal.entidades.Item;

public class OrdenaItemPeloPreco implements Comparator<Item> {

	@Override
	public int compare(Item itemUm, Item itemDois) {

		double result = itemUm.getPreco() - itemDois.getPreco();
		
		if(result < 0)
			return -1;
		else if(result > 0)
			return 1;
		else
			return 0;
	}

}


/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe é parte da aplicação "World of Zuul".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado aos 
 * outros ambientes através de saídas. As saídas são nomeadas como norte, sul, leste 
 * e oeste. Para cada direção, o ambiente guarda uma referência para o ambiente vizinho, 
 * ou null se não há saída naquela direção.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */
import java.util.HashMap;

public class Ambiente {
    // descrição do ambiente
    private String descricao;
    // ambientes vizinhos de acordo com a direção
    private HashMap<String, Ambiente> saidas;
    private Itens item;

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele não tem saidas.
     * "descricao" eh algo como "uma cozinha" ou "um jardim aberto".
     * 
     * @param descricao A descrição do ambiente.
     */
    public Ambiente(String descricao) {
        this.descricao = descricao;
        saidas = new HashMap<String, Ambiente>();
    }

    public Ambiente(String descricao, Itens itemNovo) {
        this.descricao = descricao;
        item = new Itens(itemNovo.getNome(), itemNovo.getDescricao());
        saidas = new HashMap<String, Ambiente>();
    }

    /**
     * Define as saídas do ambiente. Cada direção ou leva a um outro ambiente ou é
     * null
     * (indicando que não tem nenhuma saída para lá).
     * 
     * @param norte A saída norte.
     * @param leste A saída leste.
     * @param sul   A saída sul.
     * @param oeste A saída oeste.
     */
    public void ajustarSaidas(String direcao, Ambiente ambiente) {
        saidas.put(direcao, ambiente);
    }

    /**
     * @return A descrição do ambiente.
     */
    public String getDescricao() {
        return descricao;
    }

    public Ambiente getSaida(String direcao) {
        return saidas.get(direcao);
    }

    public String direcoesDeSaida() {
        String textoSaidas = "";
        for (String direcao : saidas.keySet()) {
            textoSaidas = textoSaidas + direcao + " ";
        }
        return textoSaidas;
    }

    public String getDescricaoLonga() {
        if (temItem() == true) {
            return ("Voce esta " + this.getDescricao() + " Esse local possui um/uma " + this.item.getNome()
                    + this.item.getDescricao());
        } else {
            return ("Voce esta " + this.getDescricao());
        }
    }

    public boolean temItem() {
        if (this.item != null) {
            return true;
        } else {
            return false;
        }
    }

    public String consultarItem() {
        if (this.item != null) {
            return this.item.getNome();
        } else {
            return null;
        }
    }

    public Itens coletarItem() {
        Itens aux = this.item;
        this.item = null;
        return aux;
    }
}

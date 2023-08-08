package concessionaria;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.CarroFactory;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import java.util.HashMap;
import java.util.Map;

import detran.GeradorDePlaca;

/**
 * Representa uma concessionária que vende carros de uma determinada Marca.
 */
public class Concessionaria {
    // Nome da concessionária
    private String nome;
    // Carros da concessionária
    private Map<String, Carro> carros;
    // Marca da qual a concessionária vende os carros
    private CarroFactory factory;
    
    /**
     * Uma concessionária é construída com um nome e uma Marca da qual vende carros
     * @param nome O nome da concessionária.
     * @param marca A marca da qual a concessionária vende os carros
     */
    public Concessionaria(String nome, CarroFactory factory) {
        this.nome = nome;        
        this.factory = factory;
        carros = new HashMap<>();
    }

    public void mudarDeFranquia(CarroFactory franquia){
        factory = franquia;
    }
    
    /**
     * Retorna o nome da concessionária
     * 
     * @return O nome da concessionária
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna a Marca da qual a concessionária vende os carros.
     * 
     * @return A marca dos carros
     */
    public Marca getMarcaFranquia() {
        return factory.getMarcaFranquia();
    }
    
    /**
     * Realiza a compra de um carro de uma determinada categoria e com uma cor
     * @param categoria Categoria do carro a ser comprado.
     * @param cor Cor do carro a ser comprado
     * 
     * @return Verdadeiro se o carro pode ser comprado (modelo disponível)
     */
    public boolean comprarCarro(Categoria categoria, String cor) {
        Carro carro = null;
        carro = factory.criarCarro(categoria, cor);
        
        if (carro != null) {
            carro.emplacar(GeradorDePlaca.gerarPlaca());
            carro.prepararParaEntrega();
            carro.liberarDocumentacao();
            carros.put(carro.obterNome(),  carro);
            return true;
        }
        else {
            System.out.println("Não há modelos disponíveis para essa categoria");
            return false;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaria;

import fabricaautomoveis.carros.CarroFactory;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.FiatFactory;
import fabricaautomoveis.carros.RenaultFactory;
import fabricaautomoveis.carros.VWFactory;

import java.util.Scanner;

/**
 *
 * @author julio
 */
public class InterfaceUsuario {

    private Concessionaria ppooVeiculos;
    private Scanner entrada;
        
    public void exibir() {
        CarroFactory factory = new RenaultFactory();
        ppooVeiculos = new Concessionaria("PPOO Veículos", factory);
        entrada = new Scanner(System.in);
        
        int opcao;        
        do {
            opcao = menu();
            
            switch (opcao) {
                case 1:
                    comprarCarro();
                    break;
                case 2:
                    mudarFranquia();
                    break;
                case 3:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");                   
            }
            
        } while (opcao != 3);        
    }            
    
    private int menu() {
        System.out.println("1 - Comprar Carro");
        System.out.println("2 - Mudar Franquia");
        System.out.println("3 - Sair");
        
        return Integer.parseInt(entrada.nextLine());
    }

    private void comprarCarro() {        
        System.out.println("Concessionaria vende carros da: " + ppooVeiculos.getMarcaFranquia());        
        
        System.out.print("Escolha a categoria (1: Entrada, 2: Caminhonete ou 3: Superior): ");
        Categoria categoria = Categoria.peloID(Integer.parseInt(entrada.nextLine()));
        
        System.out.print("Escolha a cor: ");
        String cor = entrada.nextLine();
        
        if (ppooVeiculos.comprarCarro(categoria, cor)) {
            System.out.println("Parabéns!!! O carro é seu!!!");            
        }
        else {
            System.out.println("Sinto muito, não quer escolher outro?");
        }
        
        esperarTecla();
    }

    public void mudarFranquia(){
        System.out.println("Escolha a franquia que deseja: 1- Fiat 2- Renault 3- Volkswagen");
        CarroFactory franquia = franquiaCarro(Integer.parseInt(entrada.nextLine()));
        if(franquia!=null){
            ppooVeiculos.mudarDeFranquia(franquia);
        }else{
            System.out.println("Não temos essa opção de franquia.");
        }
        esperarTecla();

    }
    
    private void esperarTecla() {
        entrada.nextLine();
    }

    private CarroFactory franquiaCarro(int opcao){
        CarroFactory franquia = null;
        if(opcao==1){
            franquia = new FiatFactory();
        }else if(opcao==2){
            franquia = new RenaultFactory();
        }else if(opcao==3){
            franquia = new VWFactory();
        }
        return franquia;
    }
}


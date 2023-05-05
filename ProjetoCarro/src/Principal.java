import java.util.Scanner;
public class Principal {
    private Carro[] carros = new Carro[5];

    public void executar(Carro carro){
        Scanner ler = new Scanner(System.in);
        int opcao;
        int tamanho = 0;
        int contador = 0;
        int numero;
        
        for(int i = 0; i < carros.length; i++) {
            carros[i] = new Carro("");
        }

        do{
            System.out.println("\n-------- MENU --------");
            System.out.println("Escolha uma opção:");
            System.out.println("1: Criar carro.");
            System.out.println("2: Acelerar carro.");
            System.out.println("3: Reduzir a velocidade do carro.");
            System.out.println("4: Exibir os dados do carro.");
            System.out.println("5: Sair.");
            opcao = Integer.parseInt(ler.nextLine());
            switch(opcao){  
                case 1:
                    if(tamanho<5){
                        System.out.println("Digite o nome do modelo do carro.");
                        String modelo = ler.nextLine();
                        contador = 0;
                        for (Carro n : carros){
                            if(n.getModelo().equals(modelo)){
                                contador++;
                            }
                        }
                        if(contador>=1){
                            System.out.println("Esse modelo já foi registrado.");
                        }else{
                            carros[tamanho] = new Carro(modelo);
                            tamanho++;
                        }
                    }else{
                        System.out.println("Não é possível criar mais carros.");
                    }
                break;
                case 2:
                    System.out.println("Digite o modelo do carro que deseja acelerar.");
                    String nome = ler.nextLine();
                    contador = 0;
                    for (Carro n : carros){
                        if(n.getModelo().equals(nome)){
                            contador++;
                        }
                    }
                    if(contador==0){
                        System.out.println("Esse modelo não foi registrado.");
                    }else{
                        System.out.println("Quanto deseja acelerar o carro?");
                        numero = Integer.parseInt(ler.nextLine());
                        for (Carro n : carros){
                            if(n.getModelo().equals(nome)){
                                n.acelerar(numero);
                                contador++;
                            }
                        }
                    }
                break;
                case 3:
                    System.out.println("Digite o modelo do carro que deseja reduzir a velocidade.");
                    nome = ler.nextLine();
                    contador = 0;
                    for (Carro n : carros){
                        if(n.getModelo().equals(nome)){
                            contador++;
                        }
                    }
                    if(contador==0){
                        System.out.println("Esse modelo não foi registrado.");
                    }else{
                        System.out.println("Quanto deseja desacelerar o carro?");
                        numero = Integer.parseInt(ler.nextLine());
                        for (Carro n : carros){
                            if(n.getModelo().equals(nome)){
                                n.reduzir(numero);
                                contador++;
                            }
                        }
                    }
                break;
                case 4:
                    System.out.println("Digite o modelo do carro que deseja exibir os dados.");
                    nome = ler.nextLine();
                    contador = 0;
                    for(Carro n : carros){
                        if(n.getModelo().equals(nome)){
                            System.out.println(n.getModelo());
                            System.out.println(n.getVelocidade());
                            contador++;
                        }
                    }
                    if(contador==0){
                        System.out.println("Esse modelo não foi registrado.");
                    }
                    
                break;
            }
        }while(opcao!=5);
        ler.close();
    }
}

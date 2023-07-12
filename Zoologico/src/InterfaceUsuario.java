import java.util.Scanner;

/*
 * Classe que trata a interface com o usuário (menu de opções)
 */
public class InterfaceUsuario {
    // Scanner para obter dados do usuário via terminal
    private Scanner entrada;
    private Zoologico zoologico = new Zoologico();

    /*
     * Construtor da classe
     */
    public InterfaceUsuario() {
        entrada = new Scanner(System.in);
    }

    /*
     * Método que trata o loop de exibição e tratamento do menu
     */
    public void executar() {
        int opcao;
        do {
            exibirMenu();

            System.out.println("\nDigite sua opção: ");
            opcao = Integer.parseInt(entrada.nextLine());

            tratarMenu(opcao);

        } while (opcao != 5);

        // fecha o objeto Scanner para liberar os seus recursos
        entrada.close();
    }

    /*
     * Método que exibe as opções de menu
     */
    public void exibirMenu() {
        System.out.println("1 - Cadastrar animal");
        System.out.println("2 - Descrever animal");
        System.out.println("3 - Listar animais");
        System.out.println("4 - Listar animais completo");
        System.out.println("5 - Sair");
    }

    /*
     * Método que trata uma opção de menu escolhida pelo usuário
     */
    private void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarAnimal();
                break;
            case 2:
                descreverAnimal();
                break;
            case 3:
                listarAnimais();
                break;
            case 4:
                listarAnimaisCompleto();
                break;
            case 5:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        // se o usuário não estiver saindo do programa, pede para ele digitar ENTER
        // antes de exibir o menu novamente
        if (opcao != 5) {
            System.out.println("\nDigite ENTER para continuar!");
            entrada.nextLine();
        }
    }

    /*
     * Método auxiliar que obtém uma String do usuário
     */
    private String pedirString(String instrucao) {
        System.out.print(instrucao + ": ");
        String informacao = entrada.nextLine();
        return informacao;
    }

    /*
     * Trata a opção de menu: Cadastrar Animal
     */
    private void cadastrarAnimal() {
        // implemente seu código aqui.
        String nome = pedirString("Digite o nome do animal");
        System.out.println("Qual especie deseja cadastrar (1-Tigre, 2-Tucano, 3-Avestruz, 4- Chimpanze)?");
        int especie = Integer.parseInt(entrada.nextLine());
        String corPelo, qualidadeVoo;
        switch (especie) {
            case 1:
                corPelo = pedirString("Qual a cor do pelo do animal?");
                zoologico.adicionarTigre(nome, corPelo);
                break;
            case 2:
                qualidadeVoo = pedirString("Como o animal voa?");
                zoologico.adicionarTucano(nome, qualidadeVoo);
                break;
            case 3:
                qualidadeVoo = pedirString("Como o animal voa?");
                zoologico.adicionarAvestruz(nome, qualidadeVoo);
                break;
            case 4:
                corPelo = pedirString("Qual a cor do pelo do animal?");
                zoologico.adicionarChimpanze(nome, corPelo);
                break;
        }
    }

    /*
     * Trata a opção de menu: Descrever Animal
     */
    private void descreverAnimal() {
        // implemente seu código aqui.
        String nome = pedirString("Digite o nome do animal que deseja descrever.");
        zoologico.retornaDescricao(nome);
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimais() {
        // implemente seu código aqui.
        // zoologico.listarDescricaoResumida();
        System.out.println(zoologico.listarDescricaoResumidaAnimais());
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimaisCompleto() {
        // implemente seu código aqui.
        // zoologico.listarDescricaoCompleta();
        System.out.println(zoologico.listarDescricaoCompletaAnimais());
    }
}
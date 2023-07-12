import java.util.Scanner;

/**
 * Essa é a classe principal da aplicacao "World of Zull".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E é tudo! Ele realmente precisa ser
 * estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método
 * "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os
 * ambientes,
 * cria o analisador e começa o jogo. Ela também avalia e executa os comandos
 * que
 * o analisador retorna.
 * 
 * @author Michael Kölling and David J. Barnes (traduzido e adaptado por Julio
 *         César Alves)
 */

public class Jogo {
    // analisador de comandos do jogo
    private Analisador analisador;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;
    // itens
    private Itens item;
    private Itens item2;
    private Scanner ler = new Scanner(System.in);
    private Agente agente;

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() {
        criarAmbientes();
        analisador = new Analisador();
        agente = new Agente("Ash");
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente sala_principal, sala_de_aula, escada, lavanderia, corredor, sala_de_suprimentos;
        // criando itens
        item = new Itens("bomba", ", dispositivo armado por terroristas para causar uma grande explosao na casa.");
        item2 = new Itens("desativador", ", dispositivo utilizado para desarmar a bomba plantada pelos terroristas.");
        // cria os ambientes
        sala_principal = new Ambiente("em uma sala de estar.");
        sala_de_aula = new Ambiente("na sala de aulas.", item2);
        escada = new Ambiente("na escada da lavanderia.");
        lavanderia = new Ambiente("no lavanderia do sotao.");
        corredor = new Ambiente("no corredor da sala de suprimentos.");
        sala_de_suprimentos = new Ambiente("na sala de suprimentos.", item);
        // inicializa as saidas dos ambientes
        sala_principal.ajustarSaidas("leste", escada);
        sala_principal.ajustarSaidas("oeste", sala_de_aula);
        sala_de_aula.ajustarSaidas("norte", sala_principal);
        sala_de_aula.ajustarSaidas("leste", sala_principal);
        escada.ajustarSaidas("sul", lavanderia);
        escada.ajustarSaidas("norte", sala_principal);
        lavanderia.ajustarSaidas("sul", escada);
        lavanderia.ajustarSaidas("norte", corredor);
        corredor.ajustarSaidas("leste", sala_de_suprimentos);
        corredor.ajustarSaidas("sul", lavanderia);
        sala_de_suprimentos.ajustarSaidas("oeste", corredor);

        ambienteAtual = sala_principal; // o jogo comeca em frente à sala_principal
    }

    /**
     * Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e
        // os executamos até o jogo terminar.

        boolean terminado = false;
        while (!terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Até mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo ao Mini Six!");
        System.out.println(
                "Mini Six eh um novo jogo de aventura em que o objetivo eh encontrar a bomba plantada pelos terroristas e desarma-la.");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();

        System.out.println("Voce esta " + ambienteAtual.getDescricao());

        System.out.print("Saidas: ");
        definirSaida();
        System.out.println();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * 
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) {
        boolean querSair = false;

        if (comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        } else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        } else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        } else if (palavraDeComando.equals("observar")) {
            observar(ambienteAtual);
        } else if (palavraDeComando.equals("pegar")) {
            pegarItem(ambienteAtual);
        } else if (palavraDeComando.equals("inventario")) {
            System.out.println(exibirInventario());
        }

        return querSair;
    }

    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de palavras de comando
     */
    private void imprimirAjuda() {
        System.out.println(
                "Voce eh o ultimo operador restante e possui alguns minutos antes da bomba explodir. Voce caminha");
        System.out.println("por uma casa em Oregon, Estados Unidos.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        String[] comandos = analisador.getPalavrasDeComando();
        for (String comando : comandos) {
            System.out.print(comando + " ");
        }
        System.out.println();
    }

    /**
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente,
     * caso contrário imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando) {
        // se não há segunda palavra, não sabemos pra onde ir...
        if (!comando.temSegundaPalavra()) {
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = null;
        if (direcao.equals("norte")) {
            proximoAmbiente = ambienteAtual.getSaida(direcao);
        }
        if (direcao.equals("leste")) {
            proximoAmbiente = ambienteAtual.getSaida(direcao);
        }
        if (direcao.equals("sul")) {
            proximoAmbiente = ambienteAtual.getSaida(direcao);
        }
        if (direcao.equals("oeste")) {
            proximoAmbiente = ambienteAtual.getSaida(direcao);
        }

        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        } else {
            ambienteAtual = proximoAmbiente;
            System.out.println(ambienteAtual.getDescricao());
            System.out.print("Saidas: ");
            definirSaida();
            System.out.println();
        }
    }

    /**
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos
     * realmente sair do jogo.
     * 
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando) {
        if (comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        } else {
            return true; // sinaliza que nós realmente queremos sair
        }
    }

    private void definirSaida() {
        if (ambienteAtual.getSaida("norte") != null) {
            System.out.print("norte ");
        }
        if (ambienteAtual.getSaida("leste") != null) {
            System.out.print("leste ");
        }
        if (ambienteAtual.getSaida("sul") != null) {
            System.out.print("sul ");
        }
        if (ambienteAtual.getSaida("oeste") != null) {
            System.out.print("oeste ");
        }
    }

    private void observar(Ambiente ambiente) {
        System.out.println(ambiente.getDescricaoLonga());
    }

    private void pegarItem(Ambiente ambiente) {
        if (ambiente.consultarItem() != null) {
            System.out.println("Pegar o que?");
            String nomeItem = ler.nextLine();
            if (nomeItem.equals(ambiente.consultarItem())) {
                agente.adicionarItemMochila(ambiente.coletarItem());
                System.out.println("Item coletado!");
            } else {
                System.out.println("Não há esse item nesse ambiente.");
            }
        } else {
            System.out.println("Não há nada para pegar nesse momento.");
        }
    }

    private String exibirInventario() {
        return agente.listarItensMochila();
    }
}

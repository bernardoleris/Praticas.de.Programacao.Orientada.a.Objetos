package iu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import feed.FeedNoticias;
import feed.Publicacao;

/**
 * Classe criada para implementar a interface gráfica da Rede Social.
 * O objetivo dessa implementação é didático! 
 * - Exercitar e apresentar conceitos de GUIs (Interfaces Gráficas de Usuário) 
 *   e Tratamento de Exceções
 * 
 * @author Julio Cesar Alves
 */
public class TelaRedeSocial {
    // Janela da nossa tela
    private JFrame janela;
    // Caixa de texto para exibir o feed de noticiai    
    private JTextArea areaTextoFeed;    
    // Botão para postar uma mensagem no feed
    private JButton botaoPostarMensagem;
    // Botão para curtir uma mensagem do feed
    private JButton botaoCurtir;
    // Botão para comentar uma mensagem do feed
    private JButton botaoComentar;
    // Botão para atualizar feed
    private JButton botaoAtualizar;
    //barra de rolagem
    private JScrollPane scroll;
    // Objeto que representa a Regra de Negócios (a lógica da Rede Social em si)
    private FeedNoticias feed;
    // caixa de selecao
    private JComboBox<String> comboBoxAutores;
    // boolean para controlar erro de execucao simultanea
    private boolean carregando = false;
    
    /**
     * Construtor da classe: cria o feed, os componentes e monta a tela.
    */
    public TelaRedeSocial() {
        feed = new FeedNoticias();
        
        construirJanela();
    }

    /**
     * Constroi os componentes e monta a janela
    */
    private void construirJanela() throws HeadlessException {
        janela = new JFrame("GUI - Rede Social");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        criarComponentes();
        
        montarJanela();
        FlatDarkLaf.setup();
    }

    private void preencherCaixa(){
        carregando = true;
        comboBoxAutores.removeAllItems();
        comboBoxAutores.addItem("Todos");
        List<String> autores = new ArrayList<>();
        autores = feed.getAutores();
        for (String autor : autores) {
            comboBoxAutores.addItem(autor);
        }
        carregando = false;
    }

    /**
     * Cria os componentes da tela e faz a inscrição nos eventos necessários
     */
    private void criarComponentes() {
        // criando os componentes
        areaTextoFeed = new JTextArea();
        scroll = new JScrollPane(areaTextoFeed);
        botaoPostarMensagem = new JButton("Postar Mensagem");
        botaoCurtir = new JButton("Curtir");
        botaoComentar = new JButton("Comentar");
        botaoAtualizar= new JButton("Atualizar");
        comboBoxAutores = new JComboBox<>();
        // impede que o usuário edite a área de texto do feed
        areaTextoFeed.setEditable(false);
        
        // adiciona o método que tratará o evento de clique no botão Postar Mensagem
        botaoPostarMensagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postarMensagem();
            }            
        });
        
        // adiciona o método que tratará o evento de clique no botão Curtir
        botaoCurtir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curtirMensagem();
            }
        });

        // adiciona o método que tratará o evento de clique no botão Comentar
        botaoComentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comentarMensagem();
            }
        });

        // adiciona o método que tratará o evento de clique no botão Atualizar
        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarFeed();
            }
        });

        // adiciona o método que tratará o evento de seleção na caixa de seleção
        comboBoxAutores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!carregando){
                    atualizarAreaTextoFeed();
                }
            }
        });
    }

    /**
     * Monta a janela
     */
    private void montarJanela() {
        janela.setSize(500, 600);
        
        janela.setLayout(new BorderLayout());

        JPanel painelSelecaoAutor = new JPanel();
        painelSelecaoAutor.setLayout(new FlowLayout());
        painelSelecaoAutor.add(new JLabel("Selecionar Autor:"));
        painelSelecaoAutor.add(comboBoxAutores);
        comboBoxAutores.addItem("Todos");

        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout());
        painelSuperior.add(new JLabel("Feed de Notícias"));
        painelSuperior.add(painelSelecaoAutor);
        janela.add(painelSuperior, BorderLayout.NORTH);
        
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        //adicao da fonte 
        Font fonte = new Font("Serif", Font.BOLD, 16);
        areaTextoFeed.setFont(fonte);
        painelCentral.add(scroll);
        janela.add(painelCentral, BorderLayout.CENTER);
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoPostarMensagem);
        painelBotoes.add(botaoCurtir);
        painelBotoes.add(botaoComentar);
        painelBotoes.add(botaoAtualizar);
        janela.add(painelBotoes, BorderLayout.SOUTH);
    }
    
    /*
     * Exibe a tela da Rede Social
    */
    public void exibir() {
        janela.setVisible(true);
    }
    
    /**
     * Posta uma mensagem no feed. Solicita o autor e a mensagem ao usuário,
     * posta no Feed e atualiza a área de texto de exibição do feed.
     */
    private void postarMensagem() {
        String autor = JOptionPane.showInputDialog("Autor da mensagem");
        // Se o usuário digitou algum autor e confirmou
        if(autor != null) {
            String mensagem = JOptionPane.showInputDialog("Texto da mensagem");
            // Se o usuário digitou alguma mensagem e confirmou
            if (mensagem != null) {
                feed.postarMensagemTexto(autor, mensagem);        
                atualizarAreaTextoFeed();
                preencherCaixa();
            }
        }
    }
    
    /**
     * Curte uma mensagem. Solicita o identificador da mensagem ao usuário,
     * curte a mensagem e atualiza a área de texto de exibição do feed.
     */
    private void curtirMensagem() {
        int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));
        feed.curtir(idMensagem);
        atualizarAreaTextoFeed();
    }


    /**
     * Comenta uma mensagem. Solicita o identificador da mensagem ao usuário e o comentário
     * a ser feito e atualiza a área de texto de exibição do feed.
     */
    private void comentarMensagem() {
        int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));
        String comentario = JOptionPane.showInputDialog("Comentário");
        feed.comentar(idMensagem, comentario);
        atualizarAreaTextoFeed();
    }    

    /**
     * Atualiza a área de texto de exibição do Feed.
     */
    private void atualizarAreaTextoFeed() {
        // Limpa a lista de publicações
        areaTextoFeed.setText("");

        // Obtém o índice da opção selecionada na caixa de seleção
        int indiceSelecionado = comboBoxAutores.getSelectedIndex();

        // Verifica a opção selecionada
        if (indiceSelecionado == 0) {
            List<Publicacao> publicacoes = feed.getPublicacoes();
            for (Publicacao publicacao : publicacoes) {
                areaTextoFeed.append(publicacao.getTextoExibicao());
            }
        } else {
            String autorSelecionado = (String) comboBoxAutores.getItemAt(indiceSelecionado);
            List<Publicacao> publicacoesFiltradas = new ArrayList<>();

            for (Publicacao publicacao : feed.getPublicacoes()) {
                if (publicacao.getAutor().equals(autorSelecionado)) {
                    publicacoesFiltradas.add(publicacao);
                }
            }

            for (Publicacao publicacao : publicacoesFiltradas) {
                areaTextoFeed.append(publicacao.getTextoExibicao());
            }
        }
    }



    /**
     * Atualiza o feed.
     */
    private void atualizarFeed() {
        atualizarAreaTextoFeed();
    }
}

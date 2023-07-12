import java.util.ArrayList;

public class Agente {
    private String nome;
    private ArrayList<Itens> mochila;

    public Agente(String nome) {
        this.nome = nome;
        mochila = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarItemMochila(Itens item) {
        mochila.add(item);
    }

    public String removerItemMochila(String nomeItem) {
        for (Itens item : mochila) {
            if (nomeItem.equals(item.getNome())) {
                mochila.remove(item);
                return item.getNome();
            }
        }
        return null;
    }

    // utilizacao da classe StringBuilder para manipular dinamicamente a String
    public String listarItensMochila() {
        StringBuilder lista = new StringBuilder();
        lista.append("[");
        for (Itens item : mochila) {
            lista.append(item.getNome()).append(" ");
        }
        lista.append("]");
        return lista.toString();
    }

}

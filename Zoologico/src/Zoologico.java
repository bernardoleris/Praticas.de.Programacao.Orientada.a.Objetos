import java.util.ArrayList;

public class Zoologico {
    /*
     * private ArrayList<Avestruz> avestruzes = new ArrayList<Avestruz>();
     * private ArrayList<Tigre> tigres = new ArrayList<Tigre>();
     * private ArrayList<Tucano> tucanos = new ArrayList<Tucano>();
     * private ArrayList<Chimpanze> chimpanzes = new ArrayList<Chimpanze>();
     */
    private ArrayList<Animal> animais = new ArrayList<Animal>();

    public void adicionarAvestruz(String nome, String qualidadeVoo) {
        Avestruz avestruz = new Avestruz(nome, qualidadeVoo);
        // avestruzes.add(avestruz);
        animais.add(avestruz);
    }

    public void adicionarTigre(String nome, String corPelo) {
        Tigre tigre = new Tigre(nome, corPelo);
        // tigres.add(tigre);
        animais.add(tigre);
    }

    public void adicionarTucano(String nome, String qualidadeVoo) {
        Tucano tucano = new Tucano(nome, qualidadeVoo);
        // tucanos.add(tucano);
        animais.add(tucano);
    }

    public void adicionarChimpanze(String nome, String corPelo) {
        Chimpanze chimpanze = new Chimpanze(nome, corPelo);
        // chimpanzes.add(chimpanze);
        animais.add(chimpanze);
    }

    /*
     * public void listarDescricaoCompleta() {
     * String lista = "";
     * for (Avestruz i : avestruzes) {
     * lista += (i.getDescricaoCompleta());
     * lista += "/n";
     * }
     * for (Tigre i : tigres) {
     * lista += (i.getDescricaoCompleta());
     * lista += "/n";
     * }
     * for (Chimpanze i : chimpanzes) {
     * lista += (i.getDescricaoCompleta());
     * lista += "/n";
     * }
     * for (Tucano i : tucanos) {
     * lista += (i.getDescricaoCompleta());
     * lista += "/n";
     * }
     * }
     * 
     * public void listarDescricaoResumida() {
     * lista = "";
     * for (Avestruz i : avestruzes) {
     * lista += (i.getDescricaoResumida());
     * lista += "/n";
     * }
     * for (Tigre i : tigres) {
     * lista += (i.getDescricaoResumida());
     * lista += "/n";
     * }
     * for (Chimpanze i : chimpanzes) {
     * lista += (i.getDescricaoResumida());
     * lista += "/n";
     * }
     * for (Tucano i : tucanos) {
     * lista += (i.getDescricaoResumida());
     * lista += "/n";
     * }
     * return lista;
     * }
     * 
     * public void retornaDescricao(String nome) {
     * String descricao = "";
     * for (Tigre i : tigres) {
     * if (i.getNome().equals(nome)) {
     * descricao += (i.getDescricaoCompleta());
     * }
     * }
     * for (Avestruz i : avestruzes) {
     * if (i.getNome().equals(nome)) {
     * descricao += (i.getDescricaoCompleta());
     * }
     * }
     * for (Chimpanze i : chimpanzes) {
     * if (i.getNome().equals(nome)) {
     * descricao += (i.getDescricaoCompleta());
     * }
     * }
     * for (Tucano i : tucanos) {
     * if (i.getNome().equals(nome)) {
     * descricao += (i.getDescricaoCompleta());
     * }
     * }
     * return descricao;
     * }
     */

    public String listarDescricaoCompletaAnimais() {
        String lista = "";
        for (Animal i : animais) {
            lista += (i.getDescricaoCompleta());
            lista += "\n";
        }
        return lista;
    }

    public String listarDescricaoResumidaAnimais() {
        String lista = "";
        for (Animal i : animais) {
            lista += (i.getDescricaoResumida());
            lista += "\n";
        }
        return lista;
    }

    public void retornaDescricao(String nome) {
        for (Animal i : animais) {
            if (i.getNome().equals(nome)) {
                System.out.println(i.getDescricaoCompleta());
            }
        }
    }


}

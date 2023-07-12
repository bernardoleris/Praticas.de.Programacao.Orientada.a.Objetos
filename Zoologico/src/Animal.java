public class Animal {
    private String nome;
    private String especie;
    private String som;
    private int qtdePatas;

    public Animal(String nome, String especie, String som, int qtdePatas){
        this.nome = nome;
        this.especie = especie;
        this.som = som;
        this.qtdePatas = qtdePatas;
    }
    public String getDescricaoResumida(){
        return this.getNome() + " é um(a) " + this.getEspecie();
    }

    public String getDescricaoCompleta(){
        return this.getNome() + " é um(a) " + this.getEspecie() + " que faz " + this.getSom() + " e ";
    }
    public String getNome() {
        return nome;
    }
    public String getEspecie() {
        return especie;
    }
    public String getSom() {
        return som;
    }
    public int getQtdePatas() {
        return qtdePatas;
    }
    


}

public class SerVoador extends Animal{
    private String qualidadeVoo;

    public SerVoador(String nome, String especie, String som, int qtdePatas, String qualidadeVoo){
        super(nome, especie, som, qtdePatas);
        this.qualidadeVoo = qualidadeVoo;
    }

    public String getDescricaoCompleta(){
        String descricao = super.getDescricaoCompleta();
        descricao = descricao + "possui um voo " + this.qualidadeVoo;
        return descricao;
    }

    public String getQualidadeVoo() {
        return qualidadeVoo;
    }
    
}

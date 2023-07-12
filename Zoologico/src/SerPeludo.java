public class SerPeludo extends Animal{
    private String corPelo;

    public SerPeludo(String nome, String especie, String som, int qtdePatas, String corPelo){
        super(nome, especie, som, qtdePatas);
        this.corPelo = corPelo;
    }

    public String getDescricaoCompleta(){
        String descricao = super.getDescricaoCompleta();
        descricao = descricao + "possui pelo " + this.corPelo;
        return descricao;
    }

    public String getCorPelo() {
        return corPelo;
    }
    
}

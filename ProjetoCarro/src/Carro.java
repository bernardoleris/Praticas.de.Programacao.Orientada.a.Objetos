public class Carro {
    private String modelo;
    private int velocidade;

    public Carro(String umModelo){
        modelo = umModelo;
        velocidade = 0;
    }

    public String getModelo(){
        return modelo;
    }

    public int getVelocidade(){
        return velocidade;
    }

    public void setVelocidade(int novaVelocidade){
        velocidade = novaVelocidade;
    }

    public void acelerar(int quantidade){
        velocidade = velocidade + 5*(quantidade);
    }

    public void reduzir(int quantidade){
        velocidade = velocidade - 5*(quantidade);
    }
}

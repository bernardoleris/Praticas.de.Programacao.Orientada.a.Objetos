package fabricaautomoveis.carros;

public class VWFactory implements CarroFactory{
    private Marca marcaFranquia;

    public VWFactory(){
        marcaFranquia = Marca.VW;
    }

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;
        if (categoria == Categoria.ENTRADA) {
            carro = new Polo(cor);
        }
        else if (categoria == Categoria.CAMINHONETE) {
            carro = new Saveiro(cor);
        }
        return carro;  
    }
    
    @Override
    public Marca getMarcaFranquia(){
        return marcaFranquia;
    }
    
}
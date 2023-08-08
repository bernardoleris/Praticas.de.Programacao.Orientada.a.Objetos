package fabricaautomoveis.carros;

public class RenaultFactory implements CarroFactory{
    private Marca marcaFranquia;

    public RenaultFactory(){
        marcaFranquia = Marca.RENAULT;
    }

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;
        if (categoria == Categoria.ENTRADA) {
            carro = new Sandero(cor);
        }
        else if (categoria == Categoria.CAMINHONETE) {
            carro = new Oroch(cor);
        }
        return carro;  
    }
    
    @Override
    public Marca getMarcaFranquia(){
        return marcaFranquia;
    }
    
}
package fabricaautomoveis.carros;

public class FiatFactory implements CarroFactory {
    private Marca marcaFranquia;

    public FiatFactory() {
        marcaFranquia = Marca.FIAT;
    }

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;

        if (categoria == Categoria.ENTRADA) {
            carro = new Argo(cor);
        }
        else if (categoria == Categoria.CAMINHONETE) {
            carro = new Strada(cor);
        }
        else if (categoria == Categoria.SUPERIOR) {
            carro = new Toro(cor);
        }

        return carro;
    }
    
    @Override
    public Marca getMarcaFranquia(){
        return marcaFranquia;
    }
    
}
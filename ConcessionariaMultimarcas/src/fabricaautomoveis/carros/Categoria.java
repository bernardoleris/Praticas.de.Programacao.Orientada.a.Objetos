package fabricaautomoveis.carros;

/**
 * Enumerador para representar as possíveis categorias de carros
 */
public enum Categoria {
    
    ENTRADA(1), 
    CAMINHONETE(2), 
    SUPERIOR(3);
    
    private int id;
    
    private Categoria(int id) {
        this.id = id;
    }
    
    public static Categoria peloID(int id) {
        for (Categoria c : Categoria.values()) {
            if (c.id == id) {
                return c;
            }
        }
        throw new RuntimeException("Não existe categoria de id " + id);
    }
}

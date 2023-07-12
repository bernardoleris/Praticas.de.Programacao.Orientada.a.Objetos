public class Teste {
    public static void main(String[] args) throws Exception {
        Animal animal = new Tigre("Jake", "Laranja");
        animal.getNome();
        animal = new Tucano("Bob", "Boa");
        animal.getNome();

        Tigre tigre = new Tigre("Marcos", "Laranja");
        exibirDescricaoCompleta(tigre);
        Avestruz avestruz = new Avestruz("Wellington", "Ruim");
        exibirDescricaoCompleta(avestruz);
    }

    public static void exibirDescricaoCompleta(Animal animal) {
        System.out.println(animal.getDescricaoCompleta());
    }
}

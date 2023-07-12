package youtubevideos;
import java.util.ArrayList;
import series.Periodicidade;
import series.SerieDados;
public class SerieDadosVideos implements SerieDados{
    private String tema;
    private int periodoInicial;
    private int periodoFinal;
    private Periodicidade periodicidade;
    private ArrayList<int[]> dadosSerie;
    //foi criado um ArrayList para armazenar os dados conforme o mês, e dentro dele há um vetor com os dados(vizualizações e curtidas).

    public SerieDadosVideos(String tema, int periodoInicial, int periodoFinal, Periodicidade periodicidade){
        this.tema = tema;
        this.periodoInicial = periodoInicial;
        this.periodoFinal = periodoFinal;
        this.periodicidade = periodicidade;
        dadosSerie = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            int[] vetor = new int[0];
            dadosSerie.add(vetor); 
        }
    }

    public String obterIdentificacaoSerie(){
        return tema;
    }

    public int obterInicioPeriodo(){
        return periodoInicial;
    }
    
    public int obterFimPeriodo(){
        return periodoFinal;
    }

    public Periodicidade obterPeriodicidade(){
        return periodicidade;
    }
    
    public int obterDado(int periodo){
        if(periodo>=this.periodoInicial && periodo<=periodoFinal){
            int[] vetor = dadosSerie.get(periodo);
            return vetor[0];
        }
        return -1;
    }

    public int obterDado2(int periodo){
        if(periodo>=this.periodoInicial && periodo<=periodoFinal){
            int[] vetor = dadosSerie.get(periodo);
            return vetor[1];
        }
        return -1;
    }
    //A fim de mannter a classe "SerieDados" intacta, foi necessario fazer outro "obter dados" para receber as curtidas conforme
    //a solucao que obtive.

    public void adicionarDado(int periodo, int visualizacoes, int curtidas){
        if(periodo>=this.periodoInicial && periodo<=periodoFinal){
            int[] vetor = new int[2];
            vetor[0] = visualizacoes;
            vetor[1] = curtidas;
            dadosSerie.add(periodo, vetor);
        }
    }
}
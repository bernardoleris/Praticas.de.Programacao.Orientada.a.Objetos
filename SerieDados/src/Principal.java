import youtubevideos.*;
import java.util.List;
//import series.VisualizadorSeries;
public class Principal {
    public void executar() {
        RegraDeNegocio regraDeNegocio = new RegraDeNegocio();
        List<SerieDadosVideos> listaSeries = regraDeNegocio.getListaSeries();
        //VisualizadorSeries vizualSeries = new VisualizadorSeries(listaSeries);
        
        for (SerieDadosVideos serie : listaSeries) {
            int dados;
            int dados2;
            System.out.println("Dados da Serie " + serie.obterIdentificacaoSerie() + " (" + serie.obterPeriodicidade() + ")");
            for (int i = serie.obterInicioPeriodo(); i <= serie.obterFimPeriodo(); i++) {
                dados = serie.obterDado(i);
                dados2 = serie.obterDado2(i);
                System.out.println("Mês " + i + ": " + dados + " visualizações | " + dados2 + " curtidas");
            }
            System.out.println();
        }
    }
}

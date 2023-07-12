package youtubevideos;

import java.util.ArrayList;
import series.Periodicidade;

public class RegraDeNegocio {
    private SerieDadosVideos serieDados1;
    private SerieDadosVideos serieDados2;
    private ArrayList<SerieDadosVideos> listaSeries = new ArrayList<>();

    public RegraDeNegocio() {
        serieDados1 = new SerieDadosVideos("Video Youtube", 5, 7, Periodicidade.MENSAL);
        serieDados2 = new SerieDadosVideos("Video Youtube", 10, 12, Periodicidade.MENSAL);
        
        listaSeries.add(serieDados1);
        listaSeries.add(serieDados2);

        serieDados1.adicionarDado(5, 100, 200);
        serieDados1.adicionarDado(6, 500, 700);
        serieDados1.adicionarDado(7, 600, 900);

        serieDados2.adicionarDado(10, 200, 300);
        serieDados2.adicionarDado(11, 300, 400);
        serieDados2.adicionarDado(12, 400, 500);
    }

    public ArrayList<SerieDadosVideos> getListaSeries() {
        return listaSeries;
    }
}

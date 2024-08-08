package br.edu.ifsul.cc.projetolpooe2_barbarawehrmann;

import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.dao.PersistenciaJPA;
import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.Midias;
import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.Noticias;
import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.TipoNoticia;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestePersistenciaNoticia {
    
    PersistenciaJPA jpa = new PersistenciaJPA();

    public TestePersistenciaNoticia() {}

    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void testePersistenciaNoticia() throws Exception {

        // definindo tipos de notícias
        
        TipoNoticia tipo1 = new TipoNoticia();
        tipo1.setDescricao("Informativo");        
        
        TipoNoticia tipo2 = new TipoNoticia();
        tipo2.setDescricao("Opinativo");
        
        jpa.persist(tipo1);
        jpa.persist(tipo2);
        
        // definindo mídias
        
        Midias midia1 = new Midias();
        midia1.setDescricao("Imagem 1");
        midia1.setUrl("http://example.com/imagem1.jpg");

        Midias midia2 = new Midias();
        midia2.setDescricao("Imagem 2");
        midia2.setUrl("http://example.com/imagem2.jpg");

        Midias midia3 = new Midias();
        midia3.setDescricao("Imagem 3");
        midia3.setUrl("http://example.com/imagem3.jpg");

        jpa.persist(midia1);
        jpa.persist(midia2);
        jpa.persist(midia3);
        
        // definindo mídias de cada notícia
        
        List<Midias> midiasNoticia1 = new ArrayList<>();
        midiasNoticia1.add(midia1);
        midiasNoticia1.add(midia2);
        
        List<Midias> midiasNoticia2 = new ArrayList<>();
        midiasNoticia2.add(midia1);
        
        List<Midias> midiasNoticia3 = new ArrayList<>();
        midiasNoticia3.add(midia1);
        midiasNoticia3.add(midia2);
        midiasNoticia3.add(midia3);
        
        List<Midias> midiasNoticia4 = new ArrayList<>();
        midiasNoticia4.add(midia3);

        // criando notícias
        
        Noticias noticia1 = new Noticias();
        noticia1.setTitulo("Novo feriado nacional");
        noticia1.setConteudo("Foi definido pelo Governo Federal que dia 20 de Novembro (Dia da Consciência Negra) será feriado nacional iniciando já em 2024.");
        noticia1.setTipo_noticia(tipo1);
        noticia1.setMidias(midiasNoticia1);
        
        jpa.persist(noticia1);

        Noticias noticia2 = new Noticias();
        noticia2.setTitulo("Lançamento do novo smartphone");
        noticia2.setConteudo("O novo smartphone da marca XYZ será lançado no próximo mês com diversas novidades.");
        noticia2.setTipo_noticia(tipo2);
        noticia2.setMidias(midiasNoticia2);
        
        jpa.persist(noticia2);

        Noticias noticia3 = new Noticias();
        noticia3.setTitulo("Previsão do tempo para o fim de semana");
        noticia3.setConteudo("A previsão do tempo para o próximo fim de semana indica chuva em várias regiões do país.");
        noticia3.setTipo_noticia(tipo1);
        noticia3.setMidias(midiasNoticia3);
        
        jpa.persist(noticia3);

        Noticias noticia4 = new Noticias();
        noticia4.setTitulo("Aumento no preço dos combustíveis");
        noticia4.setConteudo("O preço dos combustíveis sofreu um novo reajuste nesta semana, impactando o bolso dos consumidores.");
        noticia4.setTipo_noticia(tipo2);
        noticia4.setMidias(midiasNoticia4);
        
        jpa.persist(noticia4);

        // verificação
        
        Noticias persistidaNoticia1 = (Noticias) jpa.find(Noticias.class, noticia1.getId());
        Assert.assertNotNull(persistidaNoticia1);
        Assert.assertEquals(noticia1.getTitulo(), persistidaNoticia1.getTitulo());
        Assert.assertEquals(2, persistidaNoticia1.getMidias().size());

        Noticias persistidaNoticia2 = (Noticias) jpa.find(Noticias.class, noticia2.getId());
        Assert.assertNotNull(persistidaNoticia2);
        Assert.assertEquals(noticia2.getTitulo(), persistidaNoticia2.getTitulo());
        Assert.assertEquals(1, persistidaNoticia2.getMidias().size());

        Noticias persistidaNoticia3 = (Noticias) jpa.find(Noticias.class, noticia3.getId());
        Assert.assertNotNull(persistidaNoticia3);
        Assert.assertEquals(noticia3.getTitulo(), persistidaNoticia3.getTitulo());
        Assert.assertEquals(3, persistidaNoticia3.getMidias().size());

        Noticias persistidaNoticia4 = (Noticias) jpa.find(Noticias.class, noticia4.getId());
        Assert.assertNotNull(persistidaNoticia4);
        Assert.assertEquals(noticia4.getTitulo(), persistidaNoticia4.getTitulo());
        Assert.assertEquals(1, persistidaNoticia4.getMidias().size());
    }
}

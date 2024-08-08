package br.edu.ifsul.cc.projetolpooe2_barbarawehrmann;

import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.dao.PersistenciaJPA;
import org.junit.Test;

public class TestePersistencia {

    @Test
    public void testeConexao()
    {
        PersistenciaJPA jpa = new PersistenciaJPA();
        
        if (jpa.conexaoAberta())
            System.out.println("\n\nSUCESSO: Conexão com BD aberta!\n\n");
        else 
            System.out.println("\n\nERRO: Falha ao conectar ao BD!\n\n");
    } 
}

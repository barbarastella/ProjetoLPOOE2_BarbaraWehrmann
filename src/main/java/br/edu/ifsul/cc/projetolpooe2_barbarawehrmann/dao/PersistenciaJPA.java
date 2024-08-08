package br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.dao;

import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.Midias;
import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.Noticias;
import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.TipoNoticia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PersistenciaJPA implements InterfacePersistencia {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("pu_projetolpooe2_barbarawehrmann");
        entity = factory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    @Override
    public Boolean conexaoAberta() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        if (entity != null && entity.isOpen()) {
            entity.close();
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        EntityManager em = getEntityManager();
        return em.find(c, id);
    }

    @Override
    public void persist(Object o) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (!em.contains(o)) {
                o = em.merge(o);
            }
            em.remove(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }
    
     public List<Noticias> getNoticias() {
        try {
            TypedQuery<Noticias> query = entity.createQuery("SELECT n FROM Noticias n", Noticias.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     
      public List<TipoNoticia> getTiposDeNoticia() {
        try {
            TypedQuery<TipoNoticia> query = entity.createQuery("SELECT t FROM TipoNoticia t", TipoNoticia.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Midias> getMidias() {
        try {
            TypedQuery<Midias> query = entity.createQuery("SELECT m FROM Midias m", Midias.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

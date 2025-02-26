package com.mycompany.sgfp.persistencia;

import com.mycompany.sgfp.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class DespesaDAO {
    public void cadastrar(Despesa d) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public List<Despesa> consultar() {
        EntityManager em = JPAUtil.getEntityManager();
        Query consulta = em.createQuery("select d from Despesa d");
        List<Despesa> despesas = consulta.getResultList();
        
        return despesas;
    }
    
    public void atualizar(Despesa d) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            Despesa d = em.find(Despesa.class, id);
            if (d != null) {
                em.getTransaction().begin();
                em.remove(d);
                em.getTransaction().commit();
            }
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        finally {
            JPAUtil.closeEntityManager();
        }
    }
}

package com.mycompany.sgfp.persistencia;

import com.mycompany.sgfp.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class UsuarioDAO {
    public List<Usuario> consultar() {
        EntityManager em = JPAUtil.getEntityManager();
        Query consulta = em.createQuery("select u from Usuario u");
        List<Usuario> usuarios = consulta.getResultList();
        
        return usuarios;
    }
}

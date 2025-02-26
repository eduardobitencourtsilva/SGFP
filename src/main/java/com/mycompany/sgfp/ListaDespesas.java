package com.mycompany.sgfp;

import com.mycompany.sgfp.persistencia.Despesa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaDespesas {
    private static List<Despesa> lista = new ArrayList();
    
    public static List<Despesa> listar() {
        return lista;
    }
    
    public static void adicionar(Despesa d) { 
        lista.add(d);
    }
    
    public static void remover(Despesa d) { 
        lista.remove(d);
    }
    
    public static void organizar() {
        Collections.sort(lista, new DespesasComparator());
    }
}

package com.mycompany.sgfp;

import com.mycompany.sgfp.persistencia.Despesa;

public class DespesasComparator implements java.util.Comparator<Despesa> {

    @Override
    public int compare(Despesa a, Despesa b) {
        return a.getId() - b.getId();
    }
}

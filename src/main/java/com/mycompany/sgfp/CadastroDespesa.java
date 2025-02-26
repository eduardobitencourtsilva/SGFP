package com.mycompany.sgfp;

import com.mycompany.sgfp.persistencia.Despesa;
import com.mycompany.sgfp.persistencia.DespesaDAO;

public class CadastroDespesa {
    public static void cadastrarDespesa(int id, String nome, double valor, String tipo, String categoria, String status) {
        Despesa d = new Despesa(id, nome, valor, tipo, categoria, status);
        DespesaDAO dao = new DespesaDAO();
        
        ListaDespesas.adicionar(d);
        dao.cadastrar(d);
    }
}

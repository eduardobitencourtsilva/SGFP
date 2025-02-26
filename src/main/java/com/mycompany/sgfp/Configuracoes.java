package com.mycompany.sgfp;

import com.mycompany.sgfp.persistencia.Despesa;

public class Configuracoes {
    public static void configurar(int id, String categoria) {
        Despesa despesa = null;
        
        for (Despesa d : ListaDespesas.listar()) {
            if (d.getId() == id) {
                    despesa = d;
            }
        }

        try {
            if (despesa != null)
                despesa.setCategoria(categoria);
            else
                throw new Exception("Erro de configuração: despesa nula");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}

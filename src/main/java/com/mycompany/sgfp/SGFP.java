package com.mycompany.sgfp;

import com.mycompany.sgfp.persistencia.Despesa;
import static com.mycompany.sgfp.CadastroDespesa.cadastrarDespesa;
import java.util.Scanner;

public class SGFP {    
    private static int id_atual = 1;

    public static int getId_atual() {
        return id_atual;
    }

    public static void setId_atual(int id_atual) {
        SGFP.id_atual = id_atual;
    }  
        
    private static void cadastro() {
        double valor = 0;
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("\nDigite o nome da despesa");
        String nome = scanner.nextLine();
        
        try {
            System.out.println("Digite o valor da despesa");
            valor = scanner.nextDouble();
        }
        catch (Exception e) {
            System.out.println("O valor precisa ser numérico.\n");
            return;
        }
        
        scanner.nextLine();
        
        System.out.println("Digite se a despesa é fixa ou variável");
        String tipo = scanner.nextLine();
        
        System.out.println("Digite se a despesa está pendente ou já está paga");
        String status = scanner.nextLine(); 
        
        cadastrarDespesa(id_atual, nome, valor, tipo, "", status);
        
        System.out.println("Despesa cadastrada com sucesso!\n\n");
        
        id_atual++;
    }
    
    private static void listagem() {
        for (Despesa d : ListaDespesas.listar()) {
            if (!d.getCategoria().equals("")) {
                System.out.println("\nVocê possui a despesa " + d.getNome() + 
                    " de valor R$ " + d.getValor() + 
                    " do tipo " + d.getTipo() +  
                    " da categoria " +  d.getCategoria() +
                    ". Essa despesa está " + d.getStatus() + ".\n");
            }
            else {
                System.out.println("\nVocê possui a despesa " + d.getNome() + 
                    " de valor R$ " + d.getValor() + 
                    " do tipo " + d.getTipo() +
                    ". Essa despesa está " + d.getStatus() + ".\n");
            }
        }
    }
    
    private static void configurar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nQual despesa você gostaria de configurar a categoria?\n\n"
                + "Digite o id.\n");
        
        int id;
        
        try {
            id = scanner.nextInt();
        }
        catch (Exception e) {
            System.out.println("O valor precisa ser numérico.\n");
            return;
        }
        scanner.nextLine();
                
        System.out.println("Digite a categoria que você deseja colocar.\n");
                
        String categoria = scanner.nextLine();
        
        Configuracoes.configurar(id, categoria);  
    }
    
    public static void main(String[] args) {
        int escolha = -1;

        while (escolha != 0) {
            System.out.println("Bem vindo ao Sistema de Gerenciamento de Finanças Pessoais (SGFP)\n" +
                    "O que deseja fazer?\n\n" +
                    "0) Sair\n" +
                    "1) Cadastrar despesa\n" +
                    "2) Listar despesas\n" +
                    "3) Configurar despesas\n");

            Scanner scanner = new Scanner(System.in);
            escolha = scanner.nextInt();

            scanner.nextLine();

            switch(escolha) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    cadastro();
                    break;
                case 2:
                    listagem();
                    break;
                case 3:
                    configurar();
                    break;
                default:
                    System.out.println("Houve um erro. Por favor tente escolher novamente.\n");
                    break;

            }   
        }  
    }
}

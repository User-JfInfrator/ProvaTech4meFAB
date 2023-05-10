package aplicativos;

import java.io.IOException;
import java.util.Scanner;
import classes.Pessoa;
import classes.Piloto;
import classes.Aeronave;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        String CPF;
        Piloto [] pilotos = new Piloto[MAX_ELEMENTOS];
        Scanner sc = new Scanner(System.in);
        Pessoa pss = new Pessoa();
        Aeronave arn = new Aeronave();

        System.out.print("\033[H\033[2J");
            System.out.flush();

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(sc);
                    continue;
                }
                Piloto piloto = new Piloto();
                System.out.println("Digite o nome do piloto: ");
                piloto.setNome(sc.next());
                System.out.println("Digite o cpf do piloto: ");
                piloto.setCpf(sc.next());
                System.out.println("Digite o brevê do piloto: ");
                piloto.setBreve(sc.next());

                pilotos [qtdCadastrados] = piloto;
                qtdCadastrados++;
                
                

                voltarMenu(sc);
                System.out.println("\nPiloto cadastrado com sucesso.");
                System.out.println("\nNome do piloto: " + piloto.getNome());
                System.out.println("Cpf do piloto: " + piloto.getCpf());
                System.out.println("Brevê do piloto: " + piloto.getBreve());
                
                
            } else if (opcao == 2) {
                
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(sc);
                    continue;
                }

                for(int i = 0; i < qtdCadastrados; i++){
                    if(pilotos[i] != null){
                        System.out.println(pilotos[i].toString());
                        
                        
                      
                                   
                    }
                }

                voltarMenu(sc);
            } else if (opcao == 3) {
                boolean localizado = false;
                System.out.println("Informe o cpf do piloto: ");
                CPF = sc.next();
                for (Piloto piloto : pilotos) {
                    if(piloto != null && CPF .equals(piloto.getCpf())){
                        System.out.println(piloto);
                        localizado = true;
                    }
                }
                    

                if(!localizado){
                    System.out.println("Cpf não localizado.");
                }
                System.out.println("DIGITE qualquer coisa e APERTE Enter para voltar o menu: ");
                sc.next();



            } else if (opcao == 4) {
                 
                 if (qtdCadastrados == 0) {
                    System.out.println("\nSem pilotos, não há como cadastrar uma aeronave");
                    voltarMenu(sc);
                    continue;
                }
                
                System.out.println("Digite o cpf do piloto que deseja cadastrar na aeronave: ");
                CPF = sc.next();
                 Boolean encontrarPiloto = false;
                for (Piloto piloto : pilotos) {
                    if(piloto != null && CPF .equals(piloto.getCpf())){
                        Aeronave aero = new Aeronave();
                        System.out.println("Digite o modelo da aeronave: ");
                        aero.setModelo(sc.next());
                        System.out.println("Digite o número de série da aeronave: ");
                        aero.setNumeroSerie(sc.next());
                        encontrarPiloto = true;
                        System.out.println("\nAeronave cadastrada com sucesso.");
                        System.out.println(aero);
                        piloto.setAero(aero);
                     
                } 
                            
                if(!encontrarPiloto){
                    System.out.println("Cpf não encontrado!");
                        
                
                } 
                    }
                    voltarMenu(sc);
                    continue;
                }

                
                


                
            
        
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        sc.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}
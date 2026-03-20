package veiw;
import java.util.Scanner;

import model.Camisa;
import model.Cliente;
import controller.Loja;
import model.Venda;

public class Principal {

    public static void main(String[] args) {

        int escolha;
        Loja loja = new Loja();
        Scanner scanner = new Scanner(System.in);

        do {
            exibirMenu();

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1: 
                    menuCliente(scanner, loja);
                    break;

                case 2: 
                    menuCamisa(scanner, loja);
                    break;

                case 3: 
                    menuVenda(scanner, loja);
                    break;

                case 4: 
                    menuRelatorio(loja,scanner);
                    break;

                case 0: 
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (escolha != 0);

        scanner.close();

    }

    public static void exibirMenu() {
        System.out.println("\n------- Menu -------");
        System.out.println("1 - Cliente");
        System.out.println("2 - Camisa");
        System.out.println("3 - Venda");
        System.out.println("4 - Relatório");
        System.out.println("0 - Sair");
        System.out.print("\nDigite a opção desejada: ");
    }

    public static void menuCliente(Scanner scanner, Loja loja) {
        int escolha;
        String cpf, nome, telefone;

        do {
            System.out.println("\n------- Menu Cliente -------");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Remover cliente");
            System.out.println("3 - Listar clientes");
            System.out.println("0 - Voltar");
            System.out.print("\nDigite a opção desejada: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1: // Adicionar cliente
                System.out.print("Digite o CPF do cliente: ");
                cpf = scanner.next();

                
                Cliente clienteExistente = loja.encontrarCliente(cpf);
                if (clienteExistente != null) {
                    System.out.println("\nJá existe um cliente cadastrado com este CPF!\n");
                    break;
                }

                System.out.print("Digite o nome do cliente: ");
                nome = scanner.next();
                System.out.print("Digite o telefone do cliente: ");
                telefone = scanner.next();

                Cliente cliente = new Cliente(cpf, nome, telefone);
                loja.adicionarCliente(cliente);
                System.out.println("\nCliente cadastrado com sucesso!\n");
                break;


                case 2: // Remover cliente
                    System.out.print("Digite o CPF do cliente a ser removido: ");
                    cpf = scanner.next();
                    Cliente clienteRemover = loja.encontrarCliente(cpf);
                    if (clienteRemover != null) {
                        loja.removerCliente(clienteRemover);
                        System.out.println("\nCliente removido com sucesso!\n");
                    } else {
                        System.out.println("\nCliente não encontrado!\n");
                    }
                    break;

                case 3: // Listar clientes
                    if (loja.listarClientes().isEmpty()) {
                        System.out.println("\nNão há clientes cadastrados!\n");
                    } else {
                        System.out.println("\nLista de clientes:");
                        for (Cliente c : loja.listarClientes()) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 0: // Voltar
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (escolha != 0);
    }

    public static void menuCamisa(Scanner scanner, Loja loja) {
        int escolha;
        int codigo;
        String tamanho;
        String cor;
        double preco;

        do {
            System.out.println("\n------- Menu Camisa -------");
            System.out.println("1 - Adicionar camisa");
            System.out.println("2 - Remover camisa");
            System.out.println("3 - Listar camisas");
            System.out.println("0 - Voltar");
            System.out.print("\nDigite a opção desejada: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1: // Adicionar camisa
                    System.out.print("Digite o código da camisa: ");
                    codigo = scanner.nextInt();

                    if (loja.buscarCamisa(codigo) != null) {
                        System.out.println("\nEssa camisa já existe!\n");
                    } else {
                        System.out.print("Digite o tamanho da camisa: ");
                        tamanho = scanner.next();
                        System.out.print("Digite a cor da camisa: ");
                        cor = scanner.next();
                        System.out.print("Digite o preço da camisa: ");
                        preco = scanner.nextDouble();

                        Camisa camisa = new Camisa(codigo, tamanho, cor, preco);
                        loja.adicionarCamisa(camisa);
                        System.out.println("\nCamisa cadastrada com sucesso!\n");
                    }
                    break;

                case 2: // Remover camisa
                    System.out.print("Digite o código da camisa a ser removida: ");
                    codigo = scanner.nextInt();
                    Camisa camisaRemover = loja.buscarCamisa(codigo);
                    if (camisaRemover != null) {
                        loja.removerCamisa(camisaRemover);
                        System.out.println("\nCamisa removida com sucesso!\n");
                    } else {
                        System.out.println("\nCamisa não encontrada!\n");
                    }
                    break;

                case 3: // Listar camisas
                    if (loja.listarCamisas().isEmpty()) {
                        System.out.println("\nNão há camisas cadastradas!\n");
                    } else {
                        System.out.println("\nLista de camisas:");
                        for (Camisa c : loja.listarCamisas()) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 0: // Voltar
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (escolha != 0);
    }


    public static void menuVenda(Scanner scanner, Loja loja) {
        int escolha;
        int codigo;
        String cpf;
      

        do {
            System.out.println("\n------- Menu Venda -------");
            System.out.println("1 - Realizar venda");
            System.out.println("2 - Listar vendas");
            System.out.println("3 - Remover venda");
            System.out.println("0 - Voltar");
            System.out.print("\nDigite a opção desejada: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1: // Realizar venda
                    System.out.print("Digite o CPF do cliente: ");
                    cpf = scanner.next();

                    if (loja.encontrarCliente(cpf) != null) {
                        System.out.print("Digite o código da camisa: ");
                        codigo = scanner.nextInt();

                        if (loja.buscarCamisa(codigo) != null) {
                            Cliente cliente = loja.encontrarCliente(cpf);
                            Camisa camisa = loja.buscarCamisa(codigo);      

                            loja.registrarVenda(codigo, camisa, cliente);
                            System.out.println("\nVenda realizada com sucesso!\n");
                        } else {
                            System.out.println("\nCamisa não encontrada.\n");
                        }
                    } else {
                        System.out.println("\nCliente não encontrado.\n");
                    }
                    break;

                case 2: // Listar vendas
                    if (loja.listarVendas().isEmpty()) {
                        System.out.println("\nNão há vendas realizadas!\n");
                    } else {
                        System.out.println("\nLista de vendas:");
                        for (Venda v : loja.listarVendas()) {
                            System.out.println(v);
                        }
                    }
                    break;
                case 3:// remover vendas   
                    System.out.print("Digite o cpf do cliente: ");
                    String cpfp = scanner.next();
                    System.out.print("Digite o código da camisa: ");
                    int cod = scanner.nextInt();
           
                    Cliente cliente = loja.encontrarCliente(cpfp);
                    if (cliente == null) {
                        System.out.println("\nCliente não encontrado!\n");
                        break;
                    }
            
       
                    Camisa camisa = loja.buscarCamisa(cod);
                    if (camisa == null) {
                         System.out.println("\nCamisa não encontrada!\n");
                        break;
                    }
            
                    Venda vendaremover = loja.buscarVendaPorCPFECodigo(cpfp, cod);
                    if (vendaremover != null) {
                        loja.removerVenda(vendaremover);
                        System.out.println("\nVenda removida com sucesso!\n");
                    } else {
                        System.out.println("\nVenda não encontrada!\n");
                    }
                    break;
                case 0: // Voltar
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (escolha != 0);
    }


    public static void menuRelatorio(Loja loja,Scanner scanner) {
        int escolha;


        do {
            System.out.println("\n------- Menu Relatório -------");
            System.out.println("1 - Camisa mais cara");
            System.out.println("2 - Cliente que fez a venda mais cara");
            System.out.println("3 - Camisa mais barata");
            System.out.println("0 - Voltar");
            System.out.print("\nDigite a opção desejada: ");
            escolha = scanner.nextInt();
    
            switch (escolha) {
                case 1: // Camisa mais cara
                    Camisa camisaMaisCara = loja.getCamisaMaisCara();
                    if (camisaMaisCara != null) {
                        System.out.println("\nCamisa mais cara:");
                        System.out.println(camisaMaisCara);
                    } else {
                        System.out.println("\nNão há camisas cadastradas!");
                    }
                    break;
    
                case 2: // Cliente que mais comprou

                     Cliente clienteqmais = loja.clienteQueMaisComprou();
                    if (clienteqmais != null) {
                        System.out.println("\nCliente que comprou mais caro:");
                        System.out.println(clienteqmais);
                    } else {
                        System.out.println("\nNão há camisas cadastradas!");
                    }
                    break;
    
                case 3: // Camisa mais barata
                    Camisa camisaMaisBarata = loja.getCamisaMaisBarata();
                    if (camisaMaisBarata != null) {
                        System.out.println("\nCamisa mais barata:");
                        System.out.println(camisaMaisBarata);
                    } else {
                        System.out.println("\nNão há camisas cadastradas!");
                    }
                    break;
    
                case 0: // Voltar
                    break;
    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
    
        } while (escolha != 0);
    }
}

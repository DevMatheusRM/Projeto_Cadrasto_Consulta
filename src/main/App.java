package main;

import auxclass.Telefone;
import estruturas.FilaDeClientesQueue;
import estruturas.ListaDeTelefonesNaoOrdenados;
import pessoas.Cliente;
import pessoas.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Cliente> listaClientes = new ArrayList<>(); // Lista para armazenar clientes cadastrados
    private static List<Funcionario> listaFuncionarios = new ArrayList<>(); // Lista para armazenar funcionários cadastrados
    private static FilaDeClientesQueue filaDeClientes = new FilaDeClientesQueue(); // Fila de clientes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("====MENU PRINCIPAL====");
            System.out.println("1. Cadastrar NOVO Cliente");
            System.out.println("2. Cadastrar NOVO Funcionário");
            System.out.println("3. Adicionar Telefone a Cliente");
            System.out.println("4. Adicionar Telefone a Funcionário");
            System.out.println("5. Criar FILA de Clientes");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarCliente();
                    break;
                case "2":
                    cadastrarFuncionario();
                    break;
                case "3":
                    adicionarTelefoneCliente();
                    break;
                case "4":
                    adicionarTelefoneFuncionario();
                    break;
                case "5":
                    criarFilaDeClientes();
                    break;
                case "6":
                    System.out.println("Saindo...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    // Metodo para cadastrar cliente
    public static void cadastrarCliente() {
        System.out.println("Cadastro de Cliente:");
        Cliente cliente = new Cliente(); // Cria um novo objeto da classe Cliente
        cliente.cadastrar(); // Chama o método cadastrar() da classe Cliente
        listaClientes.add(cliente); // Adiciona o cliente à lista
        System.out.println("Cliente cadastrado com sucesso: " + cliente);
    }

    // Metodo para cadastrar funcionário
    public static void cadastrarFuncionario() {
        System.out.println("Cadastro de Funcionário:");
        Funcionario funcionario = new Funcionario(); // Cria um novo objeto da classe Funcionario
        funcionario.cadastrar(); // Chama o método cadastrar() da classe Funcionario
        listaFuncionarios.add(funcionario); // Adiciona o funcionário à lista
        System.out.println("Funcionário cadastrado com sucesso: " + funcionario);
    }

    // Metodo para adicionar telefone a um cliente
    public static void adicionarTelefoneCliente() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Selecione o cliente:");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println(i + 1 + ". " + listaClientes.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha o número do cliente: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (escolha < 1 || escolha > listaClientes.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Cliente cliente = listaClientes.get(escolha - 1);
        System.out.println("Adicionando telefone para: " + cliente);
        Telefone telefone = new Telefone();
        telefone.cadastrar(); // Método para preencher os dados do telefone
        cliente.getTelefones().add(telefone); // Adiciona o telefone à lista do cliente
        System.out.println("Telefone adicionado com sucesso!");
    }

    // Metodo para adicionar telefone a um funcionário
    public static void adicionarTelefoneFuncionario() {
        if (listaFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("Selecione o funcionário:");
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            System.out.println(i + 1 + ". " + listaFuncionarios.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha o número do funcionário: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (escolha < 1 || escolha > listaFuncionarios.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Funcionario funcionario = listaFuncionarios.get(escolha - 1);
        System.out.println("Adicionando telefone para: " + funcionario);
        Telefone telefone = new Telefone();
        telefone.cadastrar(); // Método para preencher os dados do telefone
        funcionario.getTelefones().add(telefone); // Adiciona o telefone à lista do funcionário
        System.out.println("Telefone adicionado com sucesso!");
    }

    // Metodo para criar uma fila de clientes
    public static void criarFilaDeClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Criando fila de clientes...");
        for (Cliente cliente : listaClientes) {
            filaDeClientes.adicionarCliente(cliente);
        }

        System.out.println("Fila criada com sucesso!");
        System.out.println("Clientes na fila:");
        filaDeClientes.exibirFila();
    }
}

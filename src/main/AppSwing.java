package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppSwing extends JFrame {

    public AppSwing() {
        // Configuração da Janela Principal
        setTitle("Sistema de Cadastro");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel Principal com CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel painelPrincipal = new JPanel(cardLayout);

        // Painel do Menu Principal
        JPanel menuPrincipal = new JPanel();
        menuPrincipal.setLayout(new GridLayout(0, 1));

        JLabel titulo = new JLabel("====MENU PRINCIPAL====", JLabel.CENTER);
        menuPrincipal.add(titulo);

        JButton btnCadastrarCliente = new JButton("1. Cadastrar NOVO Cliente");
        JButton btnCadastrarFuncionario = new JButton("2. Cadastrar NOVO Funcionário");
        JButton btnAdicionarTelefoneCliente = new JButton("3. Adicionar Telefone a Cliente");
        JButton btnAdicionarTelefoneFuncionario = new JButton("4. Adicionar Telefone a Funcionário");
        JButton btnCriarFilaClientes = new JButton("5. Criar FILA de Clientes");
        JButton btnSair = new JButton("6. Sair");

        menuPrincipal.add(btnCadastrarCliente);
        menuPrincipal.add(btnCadastrarFuncionario);
        menuPrincipal.add(btnAdicionarTelefoneCliente);
        menuPrincipal.add(btnAdicionarTelefoneFuncionario);
        menuPrincipal.add(btnCriarFilaClientes);
        menuPrincipal.add(btnSair);

        // Adicionando ações aos botões
        btnCadastrarCliente.addActionListener(e -> cardLayout.show(painelPrincipal, "CadastroCliente"));
        btnCadastrarFuncionario.addActionListener(e -> cardLayout.show(painelPrincipal, "CadastroFuncionario"));
        btnAdicionarTelefoneCliente.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade não implementada ainda."));
        btnAdicionarTelefoneFuncionario.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade não implementada ainda."));
        btnCriarFilaClientes.addActionListener(e -> JOptionPane.showMessageDialog(this, "Fila de Clientes criada!"));
        btnSair.addActionListener(e -> System.exit(0));

        // Painel para Cadastro de Cliente
        JPanel cadastroCliente = new JPanel(new GridLayout(0, 2));
        JLabel nomeLabelCliente = new JLabel("Nome:");
        JTextField nomeFieldCliente = new JTextField();
        JLabel dataLabelCliente = new JLabel("Data de Nascimento (YYYY-MM-DD):");
        JTextField dataFieldCliente = new JTextField();
        JButton btnSalvarCliente = new JButton("Salvar Cliente");

        cadastroCliente.add(nomeLabelCliente);
        cadastroCliente.add(nomeFieldCliente);
        cadastroCliente.add(dataLabelCliente);
        cadastroCliente.add(dataFieldCliente);
        cadastroCliente.add(new JLabel());
        cadastroCliente.add(btnSalvarCliente);

        btnSalvarCliente.addActionListener(e -> {
            String nome = nomeFieldCliente.getText();
            String data = dataFieldCliente.getText();
            // Chamar o método do backend para salvar cliente
            JOptionPane.showMessageDialog(this, "Cliente " + nome + " cadastrado com sucesso!");
        });

        // Painel para Cadastro de Funcionário
        JPanel cadastroFuncionario = new JPanel(new GridLayout(0, 2));
        JLabel nomeLabelFuncionario = new JLabel("Nome:");
        JTextField nomeFieldFuncionario = new JTextField();
        JLabel dataLabelFuncionario = new JLabel("Data de Nascimento (YYYY-MM-DD):");
        JTextField dataFieldFuncionario = new JTextField();
        JButton btnSalvarFuncionario = new JButton("Salvar Funcionário");

        cadastroFuncionario.add(nomeLabelFuncionario);
        cadastroFuncionario.add(nomeFieldFuncionario);
        cadastroFuncionario.add(dataLabelFuncionario);
        cadastroFuncionario.add(dataFieldFuncionario);
        cadastroFuncionario.add(new JLabel());
        cadastroFuncionario.add(btnSalvarFuncionario);

        btnSalvarFuncionario.addActionListener(e -> {
            String nome = nomeFieldFuncionario.getText();
            String data = dataFieldFuncionario.getText();
            // Chamar o método do backend para salvar funcionário
            JOptionPane.showMessageDialog(this, "Funcionário " + nome + " cadastrado com sucesso!");
        });

        // Adicionar os painéis ao CardLayout
        painelPrincipal.add(menuPrincipal, "Menu");
        painelPrincipal.add(cadastroCliente, "CadastroCliente");
        painelPrincipal.add(cadastroFuncionario, "CadastroFuncionario");

        // Adicionar o painel principal à janela
        add(painelPrincipal);

        // Mostrar o Menu Inicial
        cardLayout.show(painelPrincipal, "Menu");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppSwing app = new AppSwing();
            app.setVisible(true);
        });
    }
}

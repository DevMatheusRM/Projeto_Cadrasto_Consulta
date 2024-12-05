package pessoas;

import auxclass.Cargo;
import auxclass.Telefone;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    private int matricula;
    private Cargo cargo;
    private double salario;
    private LocalDate dataAdmissao;
    private List<Telefone> telefones; // Lista de telefones do funcionário

    private Scanner leitor = new Scanner(System.in);

    // Construtor
    public Funcionario() {
        this.telefones = new ArrayList<>(); // Inicializa a lista de telefones
    }

    public void cadastrar() {
        super.cadastrar(); // Chama o método cadastrar da superclasse Pessoa
        System.out.println("Informe a matrícula: ");
        this.matricula = leitor.nextInt();

        System.out.println("Deseja cadastrar os dados do Cargo? ");
        cargo = new Cargo();
        cargo.cadastrar();
        this.salario = cargo.getSalario();

        System.out.println("Informe o dia da admissão: ");
        int dia = leitor.nextInt();
        System.out.println("Informe o mês da admissão: ");
        int mes = leitor.nextInt();
        System.out.println("Informe o ano da admissão: ");
        int ano = leitor.nextInt();
        this.dataAdmissao = LocalDate.of(ano, mes, dia);
    }

    public void reajustarSalario(double percentual) {
        this.salario = this.salario * (1 + percentual / 100);
    }

    public void promover(Cargo novoCargo) {
        this.cargo = novoCargo;
        this.salario = novoCargo.getSalario(); // Atualiza o salário para o do novo cargo
    }

    // Métodos relacionados a telefones

    // Retorna a lista de telefones do funcionário
    public List<Telefone> getTelefones() {
        return telefones;
    }

    // Adiciona um telefone à lista
    public void adicionarTelefone(Telefone telefone) {
        telefones.add(telefone);
    }

    // Getters e setters
    public int getMatricula() {
        return matricula;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "matricula=" + matricula +
                ", cargo=" + cargo +
                ", salario=" + salario +
                ", dataAdmissao=" + dataAdmissao +
                ", telefones=" + telefones +
                "} " + super.toString();
    }
}

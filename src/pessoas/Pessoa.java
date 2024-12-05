package pessoas;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import auxclass.Endereco;
import auxclass.Telefone;
import estruturas.ListaDeTelefonesNaoOrdenados;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private ListaDeTelefonesNaoOrdenados telsContato;

    private Scanner leitor = new Scanner(System.in);

    public void cadastrar() {
        System.out.println("Informe o nome: ");
        this.nome = leitor.nextLine();

        System.out.println("Informe a data de nascimento! ");
        System.out.print("Informe o dia: ");
        int dia = leitor.nextInt();
        System.out.print("Informe o mês: ");
        int mes = leitor.nextInt();
        System.out.print("Informe o ano: ");
        int ano = leitor.nextInt();
        this.dataNascimento = LocalDate.of(ano, mes, dia);
        leitor.nextLine(); // Consumir a quebra de linha

        // Inicializa a lista de telefones
        telsContato = new ListaDeTelefonesNaoOrdenados();

        // Adicionar telefone uma única vez se o usuário desejar
        System.out.println("Deseja cadastrar um telefone? ");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int opcaoTelefone = leitor.nextInt();
        leitor.nextLine(); // Consumir a quebra de linha

        if (opcaoTelefone == 1) {
            System.out.println("Informe os dados do telefone: ");
            Telefone tele = new Telefone();
            tele.cadastrar(); // Método para preencher os dados do telefone
            telsContato.adicionarTelefone(tele);
            System.out.println("Telefone e email cadastrado com sucesso!");
        }

        // Cadastro de endereço
        System.out.println("Deseja cadastrar o endereço? ");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int end = leitor.nextInt();
        leitor.nextLine(); // Consumir a quebra de linha
        if (end == 1) {
            endereco = new Endereco();
            endereco.cadastrar();
            System.out.println("Endereço cadastrado com sucesso!");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ListaDeTelefonesNaoOrdenados getTelsContato() {
        return telsContato;
    }

    public void setTelsContato(ListaDeTelefonesNaoOrdenados telsContato) {
        this.telsContato = telsContato;
    }


    public int obterIdade(){
        LocalDate dataNascimento = this.dataNascimento;
        LocalDate dataAtual = LocalDate.now();

        Period periodo = Period.between(dataNascimento, dataAtual);

        return periodo.getYears();
    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", endereco=" + endereco +
                ", telsContato=" + telsContato +
                '}';
    }
}

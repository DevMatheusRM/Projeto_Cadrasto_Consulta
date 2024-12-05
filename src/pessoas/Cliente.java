package pessoas;

import auxclass.Profissao;
import auxclass.Telefone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID; // ferramenta que gera identificadores únicos universais

public class Cliente extends Pessoa { // Cliente herda atributos da classe Pessoa;
    private String codigo; // Cada cliente terá um código exclusivo, em String;
    private Profissao profissao; // Contém profissões pré-definidas
    private List<Telefone> telefones; // Lista de telefones do cliente

    private Scanner leitor = new Scanner(System.in);

    // Construtor padrão
    public Cliente() {
        this.codigo = UUID.randomUUID().toString();
        this.telefones = new ArrayList<>(); // Inicializa a lista de telefones
    }

    // Metodo para cadastrar um cliente
    public void cadastrar() {
        super.cadastrar(); // Chama o método cadastrar da classe base (superclasse), Pessoa;
        System.out.println("Informe a profissão do cliente: ");
        this.profissao = Profissao.valueOf(leitor.nextLine());
        // Converte a string digitada pelo usuário em um valor do tipo Profissao (enum);
    }

    // Metodo para obter o código único do cliente
    public String getCodigo() {
        return codigo;
    }

    // Metodo para gerar e atribuir um novo código ao cliente
    public void setNewCodigo() {
        this.codigo = UUID.randomUUID().toString();
    }

    // Metodo para atribuir uma profissão ao cliente
    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    // Metodo para acessar a lista de telefones
    public List<Telefone> getTelefones() {
        return telefones;
    }

    // Metodo para adicionar um telefone à lista
    public void adicionarTelefone(Telefone telefone) {
        telefones.add(telefone);
    }

    // Sobrescreve o metodo toString para exibir informações do cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "codigo='" + codigo + '\'' +
                ", profissao=" + profissao +
                ", telefones=" + telefones +
                '}' + super.toString();
    }
}

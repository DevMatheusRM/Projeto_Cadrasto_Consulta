package auxclass;

import java.util.Scanner;

public class Cargo {
    private String nome;
    private String info;
    private double salario;
    private String nivel;

    private Scanner leitor = new Scanner(System.in);
    // cria um objeto da classe Scanner, chamado leitor,
    // que será usado para ler entradas

    public void cadastrar(){
        System.out.println("Informe o cargo: ");
        this.nome = leitor.nextLine();
        System.out.println("Informe as informações do cargo: ");
        this.info = leitor.nextLine();
        System.out.println("Informe o Salário: ");
        this.salario = leitor.nextDouble();
        this.nivel = leitor.nextLine();
        System.out.println("Informe o nível (JR, PL, SR): ");
        this.nivel = leitor.nextLine();
    }
    public String getNome() {
        // Getter: metodo para acessar o valor do atributo 'nome'
        return nome;
    }

    public void setNome(String nome) {
        // Setter: metodo para definir ou alterar o valor do atributo 'nome'
        this.nome = nome;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override // metodo está sobrescrevendo o metodo toString() da classe Object.
    public String toString() { //usado para fornecer uma representação textual de um obj
        return "Cargo{" +
                "nome='" + nome + '\'' +
                ", info='" + info + '\'' +
                ", salario=" + salario +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}

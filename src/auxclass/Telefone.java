package auxclass;

import java.util.Scanner;

public class Telefone {
    private int ddd;
    private String numero;
    private String email;

    private Scanner leitor = new Scanner(System.in);

    public void cadastrar() {
        System.out.println("Informe o DDD: ");
        this.ddd = leitor.nextInt();
        leitor.nextLine();
        System.out.println("Informe o numero: ");
        this.numero = leitor.nextLine();
        System.out.println("Informe o email: ");
        this.email = leitor.nextLine();
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Telefone{" +
                "ddd=" + ddd +
                ", numero='" + numero + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

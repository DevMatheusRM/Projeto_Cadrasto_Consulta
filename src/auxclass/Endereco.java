package auxclass;

import java.util.Scanner;

public class Endereco {
        private String rua;
        private String numero;
        private String cep;
        private String cidade;
        private String estado;
        private String pais;

        private Scanner leitor = new Scanner(System.in);

        public String getRua() {
            return rua;
        }

        public void setRua(String rua) {
            this.rua = rua;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        public void cadastrar() {
            System.out.println("Informe a Rua: ");
            this.rua = leitor.nextLine();
            System.out.println("Informe a Número: ");
            this.numero = leitor.nextLine();
            System.out.println("Informe a CEP: ");
            this.cep = leitor.nextLine();
            System.out.println("Informe a cidade: ");
            this.cidade = leitor.nextLine();
            System.out.println("Informe a estado: ");
            this.estado = leitor.nextLine();
            System.out.println("Informe a País: ");
            this.pais = leitor.nextLine();
        }


        public String toString() {
            return "Endereco{" +
                    "pais='" + pais + '\'' +
                    ", estado='" + estado + '\'' +
                    ", cidade='" + cidade + '\'' +
                    ", cep='" + cep + '\'' +
                    ", numero='" + numero + '\'' +
                    ", rua='" + rua + '\'' +
                    '}';
        }
    }


package estruturas;

import pessoas.Cliente;

public class FilaDeClientes {
        private Cliente[] fila; //Array para armazenar os clientes;
        private int tamanho;
        private int capacidade;
        private int inicio;
        private int fim;

        public FilaDeClientes(int capacidade) {
            this.capacidade = capacidade;
            //Define a capacidade máxima da fila com o valor passado como parâmetro
            this.fila = new Cliente[capacidade];
            // Cria um array de objetos do tipo Cliente com o tamanho definido pela capacidade
            this.tamanho = 0;
            // Inicializa o tamanho atual da fila como 0, já que ela começa vazia
            this.inicio = 0;
            // Define o índice do início da fila como 0, indicando a primeira posição do array
            this.fim = -1;
            //Define o índice do fim da fila como -1, pois ainda não há elementos na fila
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        // Retorna 'true' se o tamanho atual da fila for igual a 0
        return tamanho == 0;
    }

    // Verifica se a fila está cheia
    public boolean isFull() {
        // Retorna 'true' se o tamanho atual da fila for igual à capacidade máxima
        return tamanho == capacidade;
    }
    public void adicionarCliente(Cliente cliente) {
        // Verifica se ainda há espaço na fila
        if (tamanho < capacidade) {
            // Calcula a nova posição do índice 'fim' (considerando comportamento circular)
            fim = (fim + 1) % capacidade;

            // Adiciona o cliente no índice calculado
            fila[fim] = cliente;

            // Incrementa o tamanho da fila
            tamanho++;

            // Exibe uma mensagem confirmando a adição do cliente
            System.out.println("Cliente " + cliente.getNome() + " adicionado à fila.");
        } else {
            // Caso a fila esteja cheia, exibe uma mensagem de erro
            System.out.println("A fila está cheia. Não é possível adicionar mais clientes.");
        }
    }
    public Cliente atenderProximoCliente() {
        // Verifica se há clientes na fila para atender
        if (tamanho > 0) {
            // Obtém o cliente que está na frente da fila (índice 'inicio')
            Cliente clienteAtendido = fila[inicio];

            // Ajusta o índice 'inicio' para o próximo cliente, considerando a fila circular
            inicio = (inicio + 1) % capacidade;

            // Reduz o tamanho da fila, pois um cliente foi atendido
            tamanho--;

            // Exibe uma mensagem informando qual cliente está sendo atendido
            System.out.println("Atendendo cliente " + clienteAtendido.getNome() + ".");

            // Retorna o cliente que foi atendido
            return clienteAtendido;
        } else {
            // Caso a fila esteja vazia, exibe uma mensagem e retorna 'null'
            System.out.println("A fila está vazia. Não há clientes para atender.");
            return null;
        }
    }

    public void exibirFila() {
        // Exibe um cabeçalho indicando que a fila será listada
        System.out.println("Fila de clientes:");

        // Itera sobre o número atual de clientes na fila
        for (int i = 0; i < tamanho; i++) {
            // Calcula o índice real no array, considerando o comportamento circular
            int index = (inicio + i) % capacidade;

            // Exibe o nome do cliente na posição calculada
            System.out.println(fila[index].getNome());
        }
    }
    public void exibirPrimeiroCliente() {
        // Verifica se a fila não está vazia
        if (!isEmpty()) {
            // Exibe o nome do cliente localizado no índice 'inicio'
            System.out.println("Primeiro cliente na fila: " + fila[inicio].getNome());
        } else {
            // Caso a fila esteja vazia, exibe uma mensagem informando isso
            System.out.println("A fila está vazia. Não há clientes.");
        }
    }
    public void exibirUltimoCliente() {
        // Verifica se a fila não está vazia
        if (!isEmpty()) {
            // Exibe o nome do cliente localizado no índice 'fim'
            System.out.println("Último cliente na fila: " + fila[fim].getNome());
        } else {
            // Caso a fila esteja vazia, exibe uma mensagem informando isso
            System.out.println("A fila está vazia. Não há clientes.");
        }
    }

}

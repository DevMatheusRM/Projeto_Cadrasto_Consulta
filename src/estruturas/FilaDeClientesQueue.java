package estruturas;

import java.util.LinkedList; //Estrutura que armazena elementos de forma sequencial, mas não utiliza índices fixos;
import java.util.Queue; // Representa uma fila, onde os elementos seguem a regra FIFO (First In, First Out).

// LinkedList pode ser usada como uma implementação de Queue,
// ou seja, você pode criar uma fila utilizando uma lista encadeada.

import pessoas.Cliente;

public class FilaDeClientesQueue {
    private Queue<Cliente> fila; // Atributo para armazenar os clientes em fila

    public FilaDeClientesQueue() {
        this.fila = new LinkedList<>(); // Inicializa a fila como uma LinkedList
    }
    public void adicionarCliente(Cliente cliente) {
        fila.offer(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adcionado à fila.");
    }
    public Cliente atenderProximoCliente() {
        Cliente clienteAtendido = fila.poll(); // Remove o próximo cliente da fila
        if (clienteAtendido != null) { // Verifica se um cliente foi atendido
            System.out.println("Atendendo cliente " + clienteAtendido.getNome() + ".");
        } else { // Caso a fila esteja vazia
            System.out.println("A fila está vazia. Não há clientes para atender.");
        } // Retorna o cliente atendido ou null
        return clienteAtendido;
    }
    public void exibirFila() {
        System.out.println("Fila de clientes:");
        for (Cliente cliente : fila) { // Itera sobre cada elemento da fila, usando o laço for-each
            System.out.println(cliente.getNome());
        }
    }
}

package estruturas;

import auxclass.Telefone;

public class ListaTelefoneOrdenados {
    private Telefone[] telefones;
    private int tamanho;
    private static final int DEFAULT_CAPACITY = 10;

    public ListaTelefoneOrdenados() {
        this.telefones = new Telefone[DEFAULT_CAPACITY];
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void addTelefone(Telefone telefone) {
        if (tamanho == telefones.length) {
            // Se o vetor estiver cheio, aumente sua capacidade
            ensureCapacity();
        }

        // Encontrar a posicao correta para inserir o telefone ordenadamente
        int index = findInsertionIndex(telefone);

        // Deslocar os elementos para abrir espaco para o novo telefone
        for (int i = tamanho - 1; i >= index; i--) {
            telefones[i + 1] = telefones[i];
        }

        // Inserir o novo telefone na posi��o correta
        telefones[index] = telefone;
        tamanho++;
    }

    private int findInsertionIndex(Telefone telefone) {
        int index = 0;
        while (index < tamanho && telefones[index].getDdd() == telefone.getDdd()) {
            index++;
        }
        return index;
    }

    private void ensureCapacity() {
        int newCapacity = telefones.length * 2;
        Telefone[] newTelefones = new Telefone[newCapacity];
        for (int i = 0; i < tamanho; i++) {
            newTelefones[i] = telefones[i];
        }
        telefones = newTelefones;
    }

    public void displayTelefones() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(telefones[i]);
        }
    }
}

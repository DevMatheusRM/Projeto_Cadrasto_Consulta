package estruturas;

import auxclass.Telefone;

public class ListaDeTelefonesNaoOrdenados {
    //Vetor de Telefones onde criaremos nossa lista
    private Telefone[] telefones;
    //Controle do tamanho
    private int tamanho;
    //Capacidade inicial (pode ser alterada depois / Boa prática)
    private static final int CAPACIDADE_PADRAO = 6;

    // Variável auxiliar para acessar a capacidade padrão dinamicamente
    private int capacidadePadrao = CAPACIDADE_PADRAO;

    // Metodo de acesso Getter
    public int getCapacidadePadrao() {
        return capacidadePadrao;
    }

    //Construtor que inicia o vetor com a capacidade padrão e define o tamanho inicia com 0
    public ListaDeTelefonesNaoOrdenados() {
        this.telefones = new Telefone[CAPACIDADE_PADRAO];
        this.tamanho = 0;
    }

    // Método para verificar se a lista está vazia
    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    // Método para verificar se a lista está cheia
    public boolean isFull() {
        return this.tamanho == CAPACIDADE_PADRAO;
    }

    // Adiciona um telefone na lista, respeitando a capacidade inicial
    public void adicionarTelefone(Telefone telefone) {
        // Verifica se ainda há espaço na lista
        if (this.tamanho < CAPACIDADE_PADRAO) {
            // Adiciona o telefone na posição correspondente ao tamanho atual
            this.telefones[this.tamanho] = telefone;
            // Incrementa o tamanho
            this.tamanho++;
        } else {
            // Exibe mensagem se não houver espaço
            System.out.println("Não há mais espaço para adicionar: " + telefone);

        }
    }
    // Método para expandir a capacidade do vetor quando ele estiver cheio
    private void garantirCapacidade() {
        // Dobra a capacidade atual
        int novaCapacidade = telefones.length * 2;
        // Cria um novo vetor com a nova capacidade
        Telefone[] listaTelefones = new Telefone[novaCapacidade];
        // Copia os elementos do vetor antigo para o novo
        for (int i = 0; i < tamanho; i++) {
            listaTelefones[i] = telefones[i];
        }
        // Substitui o vetor antigo pelo novo
        telefones = listaTelefones;
    }
    // Remove um telefone específico da lista
    public void removerTelefone(Telefone telefone) {
        // Encontra o índice do telefone a ser removido
        int index = buscarTelefoneIndex(telefone);
        if (index != -1) {
            // Desloca os elementos à direita para preencher o espaço vazio
            for (int i = index; i < tamanho - 1; i++) {
                telefones[i] = telefones[i + 1];
            }
            // Reduz o tamanho da lista
            this.tamanho--;
            // Remove a referência ao último elemento para evitar lixo na memória
            telefones[tamanho] = null;
        }
    }
    // Procura o índice de um telefone na lista
    private int buscarTelefoneIndex(Telefone telefone) {
        // Percorre o vetor até encontrar o telefone
        for (int i = 0; i < tamanho; i++) {
            if (telefones[i].equals(telefone)) {
                return i;
            }
        }
        // Se não encontrar, exibe mensagem e retorna um índice inválido
        System.out.println("Telefone não encontrado!");
        return -1;
    }
    // Exibe todos os telefones presentes na lista
    public void exibirTelefone() {
        // Percorre o vetor até o índice correspondente ao tamanho atual
        for (int i = 0; i < this.tamanho; i++) {
            // Imprime o telefone na posição atual
            System.out.println(this.telefones[i]);
        }
    }
}

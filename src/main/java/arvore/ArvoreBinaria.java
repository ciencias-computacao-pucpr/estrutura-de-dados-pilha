package arvore;

import static arvore.ArvoreUtils.altura;

public class ArvoreBinaria<T extends Comparable<T>> {

    private Node<T> raiz;

    public ArvoreBinaria(T raiz) {
        this.raiz = new Node<>(raiz);
    }

    public Node<T> getRaiz() {
        return raiz;
    }

    public void remover(T elemento) {
        Node<T> valor = buscarIneficiente(raiz, elemento);

        if (valor != null) {
            if (valor.isFolha())
                removerFolha(valor);
            else
                removerNoComFilho(valor);
        }
    }

    public boolean isBalanceado() {
        return isBalanceado(raiz);
    }

    private boolean isBalanceado(Node<T> atual) {
        if (atual == null)
            return true;

        return Math.abs(diferencaBalanceamento(atual)) <= 1
         && isBalanceado(atual.getEsquerdo()) && isBalanceado(atual.getDireito());
    }

    public void inserir(T elemento) {
        inserir(raiz, elemento);

    }

    private void balancear(Node<T> nodeAtual) {
        if (diferencaBalanceamento(nodeAtual) > 1) {
            rotDireita(nodeAtual);
        }
        else if (diferencaBalanceamento(nodeAtual) < -1) {
            rotEsquerda(nodeAtual);
        }
    }

    private int diferencaBalanceamento(Node<T> node) {
        if (node == null)
            return 0;

        return altura(node.getEsquerdo()) - altura(node.getDireito());
    }

    private void inserir(Node<T> nodeAtual, T elemento) {
        if (nodeAtual.getValor().equals(elemento))
            return;

        if (nodeAtual.menorQue(elemento)) {
            if (nodeAtual.direito == null) {
                nodeAtual.direito = new Node<>(elemento);
            }
            else
                inserir(nodeAtual.direito, elemento);
        } else if (nodeAtual.maiorQue(elemento)) {
            if (nodeAtual.esquerdo == null) {
                nodeAtual.esquerdo = new Node<>(elemento);
            }
            else
                inserir(nodeAtual.esquerdo, elemento);
        }

        if (!isBalanceado(nodeAtual)) {
            System.out.println("não esta balanceado");
            balancear(nodeAtual);
        }
    }

    private void rotDireita(Node<T> raiz) {
        Node<T> novaRaiz = raiz.getEsquerdo();
        Node<T> temp = novaRaiz.getDireito();
        novaRaiz.direito=raiz;
        raiz.esquerdo = temp;

        if (raiz == this.raiz)
            this.raiz = novaRaiz;
    }

    private void rotEsquerda(Node<T> raiz) {
        Node<T> novaRaiz = raiz.getDireito();
        Node<T> temp = novaRaiz.getEsquerdo();
        novaRaiz.esquerdo = raiz;
        raiz.direito = temp;

        if (raiz == this.raiz)
            this.raiz = novaRaiz;
    }

    public void remover(Node<T> elemento) {
        Node<T> avo = getPai(getPai(elemento));

        if (elemento != null) {
            if (elemento.isFolha())
                removerFolha(elemento);
            else
                removerNoComFilho(elemento);
        }

        if (!isBalanceado(avo)) {
            balancear(avo);
        }
    }

    private void removerFolha(Node<T> valor) {
        Node<T> pai = getPai(valor);

        if (pai != null) {
            if (pai.esquerdo == valor) pai.esquerdo = null;
            if (pai.direito == valor) pai.direito = null;
        }
    }

    private void removerNoComFilho(Node<T> valor) {
        if (valor == null) return;

        if (valor.esquerdo == null || valor.direito == null) {
            Node<T> valorSubstituto = valor.esquerdo == null ? valor.direito : valor.esquerdo;
            Node<T> pai = getPai(valor);
            if (pai != null) {
                if (pai.esquerdo == valor) pai.esquerdo = valorSubstituto;
                if (pai.direito == valor) pai.direito = valorSubstituto;
            }
        } else {
            Node<T> valorSubstituto = encontrarMin(valor.direito);
            valor.setValor(valorSubstituto.getValor());
            remover(valorSubstituto);
        }
    }

    private Node<T> getPai(Node<T> valor) {
        if (raiz == null) return raiz;
        Node<T> node = raiz;
        Node<T> pai = null;
        while (node != null && !node.igual(valor)) {
            if (node.maiorQue(valor)) {
                pai = node;
                node = node.esquerdo;
            } else if (node.menorQue(valor)) {
                pai = node;
                node = node.direito;
            } else {
                return pai;
            }
        }

        return null;
    }

    private Node<T> encontrarMin(Node<T> node) {
        if (node.direito == null && node.esquerdo == null)
            return node;

        if (node.direito != null && node.esquerdo != null) {
            return encontrarMin(node.esquerdo);
        }

        if (node.direito != null) return encontrarMin(node.direito);

        return encontrarMin(node.esquerdo);
    }


    private Node<T> buscarIneficiente(Node<T> atual, T elemento) {
        Node<T> retorno = null;
        if (atual.direito != null) {
            if (atual.direito.info.equals(elemento)) {
                return atual.direito;
            }

            retorno = buscarIneficiente(atual.direito,elemento);
        }
        if (atual.esquerdo != null && retorno == null) {
            if (atual.esquerdo.info.equals(elemento))
                return atual.esquerdo;

            retorno = buscarIneficiente(atual.esquerdo,elemento);
        }

        return retorno;
    }

    public Node<T> buscar(T elemento) {
        Node<T> atual = raiz;

        while ( atual != null && !atual.getValor().equals(elemento)) {
            if (atual.getValor().compareTo(elemento) < 0)
                atual = atual.getEsquerdo();
            else
                atual = atual.getDireito();
        }

        if (atual != null && atual.getValor().equals(elemento))
            return atual;

        return null;
    }
}

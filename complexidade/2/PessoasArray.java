public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome){
        boolean encontrado = false;
        int inicio = 0;
        int fim = nomes.length - 1;
        
        System.out.println("Procurando o nome: \"" + nome + "\"");
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            System.out.println("Passando pelo indice: " + meio);
            if (nomes[meio].equals(nome)) {
                encontrado = true;
                System.out.println("Nome " + nome + " encontrado na posição " + meio);
                break;
            } else if (nomes[meio].compareTo(nome) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        if (!encontrado) {
            throw new RuntimeException("O nome " + nome + " não se encontra no array de nomes");
        }
    }
}
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

    public void pesquisaTempoConstante(int id){
        try {
            System.err.println("Nome pesquisado é " + nomes[id] + " que está na posição " + id);
        } catch (Exception e) {
            throw new IllegalArgumentException("O array de nomes possui : " + nomes.length + " nomes.");
        }
    }
}
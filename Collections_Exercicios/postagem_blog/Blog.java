import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Blog {
    private List<Post> posts;

    public Blog() {
        this.posts = new ArrayList<>();
    }

    public void adicionarPostagem(Post post) {
        for (Post p : posts) {
            if (p.getAutor().equals(post.getAutor()) && p.getTitulo().equals(post.getTitulo())) {
                throw new IllegalArgumentException("Postagem jah existente");
            }
        }
        posts.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        return posts.stream()
                .map(post -> {
                    String[] nomeCompleto = post.getAutor().toString().split(" ");
                    String nome = nomeCompleto[0];
                    String sobrenome = nomeCompleto.length > 1 ? nomeCompleto[1] : "";
                    return new Autor(nome, sobrenome);
                })
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        return posts.stream()
                .collect(Collectors.groupingBy(
                        post -> Categorias.valueOf(post.getCategoria().toUpperCase()),
                        Collectors.reducing(0, e -> 1, Integer::sum)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Categorias, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        java.util.LinkedHashMap::new));
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        return posts.stream()
                .filter(post -> post.getAutor().toString().equals(autor.toString()))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    // TODO ordenar pelo titulo
    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        return posts.stream()
                .filter(post -> post.getCategoria().equalsIgnoreCase(categoria.toString()))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        return posts.stream()
                .collect(Collectors.groupingBy(
                        post -> Categorias.valueOf(post.getCategoria().toUpperCase()),
                        TreeMap::new,
                        Collectors.toCollection(TreeSet::new)));
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        return posts.stream()
                .collect(Collectors.groupingBy(
                        post -> {
                            String[] nomeCompleto = post.getAutor().toString().split(" ");
                            String nome = nomeCompleto[0];
                            String sobrenome = nomeCompleto.length > 1 ? nomeCompleto[1] : "";
                            return new Autor(nome, sobrenome);
                        },
                        TreeMap::new,
                        Collectors.toCollection(TreeSet::new)));
    }

}

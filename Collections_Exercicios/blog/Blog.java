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
        posts.add(post);
    }

    public Set<String> obterTodosAutores() {
        return posts.stream()
                .map(Post::getAutor)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        return posts.stream()
                .collect(Collectors.groupingBy(
                    Post::getCategoria,
                    TreeMap::new, // garante ordenação por nome da categoria 
                    Collectors.reducing(0, e -> 1, Integer::sum)
                ));
    }
}

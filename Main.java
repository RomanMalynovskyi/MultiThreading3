/**
 * Created by Малиновский Роман on 16.07.2017.
 */
public class Main {

    public static void main(String[] args) {
        SearchFiles searchFiles = new SearchFiles();
        Input input = new Input(searchFiles);
        Searching searching = new Searching(searchFiles);

        input.start();
        searching.start();
    }
}

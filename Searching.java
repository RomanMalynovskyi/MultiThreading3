
/**
 * Created by Малиновский Роман on 16.07.2017.
 */
public class Searching extends Thread {
    private SearchFiles searchFiles;


    public Searching(SearchFiles searchFiles) {
        this.searchFiles = searchFiles;
    }

    @Override
    public void run() {
        searchFiles.search();
    }
}


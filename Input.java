/**
 * Created by Малиновский Роман on 16.07.2017.
 */
public class Input extends Thread {
    private SearchFiles searchFiles;

    public Input(SearchFiles searchFiles) {
        this.searchFiles = searchFiles;
    }

    @Override
    public void run() {
        searchFiles.inputData();
    }
}

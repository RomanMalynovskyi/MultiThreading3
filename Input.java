
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

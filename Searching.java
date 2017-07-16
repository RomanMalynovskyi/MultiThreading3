

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


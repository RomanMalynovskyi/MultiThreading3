import java.io.File;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SearchFiles {
    private String fileName;
    private String fileSystem;
    private boolean dataIsEntered;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileSystem(String fileSystem) {
        this.fileSystem = fileSystem;
    }

    public void setDataIsEntered(boolean dataIsEntered) {
        this.dataIsEntered = dataIsEntered;
    }

    public void inputData() {
        try {
            lock.lock();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please, enter file name: ");
            setFileName(scanner.nextLine());
            System.out.println("Please, enter path: ");
            setFileSystem(scanner.nextLine());
            setDataIsEntered(true);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void searchFiles(File folder) {
        File[] list = folder.listFiles();
        if (folder.exists()) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    searchFiles(list[i]);
                    continue;
                }
                if (list[i].getName().startsWith(fileName)) {
                    System.out.println(list[i].getAbsolutePath());
                }
            }
        } else {
            System.out.println("Wrong data!!!");
        }
    }

    public void search() {
        try {
            lock.lock();
            for (; dataIsEntered == false; ) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            searchFiles(new File(fileSystem));
        } finally {
            lock.unlock();
        }
    }
}
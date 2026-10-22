import java.io.File;

public class DirectorySizeCalculator {
    public static long calculateSize(File item) {
        if (item.isFile()) {
            return item.length();
        }
        long totalSize = 0;
        File[] children = item.listFiles();
        if (children != null) {
            for (File child : children) {
                totalSize += calculateSize(child);
            }
        }
        return totalSize;
    }
}

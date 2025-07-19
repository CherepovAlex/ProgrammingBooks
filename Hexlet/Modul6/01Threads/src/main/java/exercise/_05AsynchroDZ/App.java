package exercise._05AsynchroDZ;

import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN (write your solution here)
    public static CompletableFuture<Long> getDirectorySize (String directory) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                Path path = Paths.get(directory);
                if (!Files.isDirectory(path)) {
                    throw new IllegalArgumentException("Not a directory");
                }
                return Files.list(path)
                        .filter(Files::isRegularFile)
                        .mapToLong(p -> {
                            try {
                                return Files.size(p);
                            } catch (Exception e) {
                                return 0L;
                            }
                        })
                        .sum();
            } catch (Exception e) {
                throw new RuntimeException("Error calculating directory size", e);
            }
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN (write your solution here)
        CompletableFuture<Long> size = App.getDirectorySize("dir/subdir");
        // END
    }
}

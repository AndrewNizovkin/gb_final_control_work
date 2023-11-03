package registry.presenter;

import java.util.List;

public interface IOController {

    /**
     * Reads from text file
     * @param path file path
     * @return List
     */
    List<String> readFile(String path);
}

package registry.vew;

import registry.presenter.IOController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class IOControllerDefault implements IOController {
    /**
     * Reads from text file
     *
     * @param path file path
     * @return List
     */
    @Override
    public List<String> readFile(String path) {
        List<String> list = new LinkedList<>();
        String line;
        try (BufferedReader input = new BufferedReader(new FileReader(path))) {
            while ((line = input.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error!" + e.getMessage());
        }
        return list;
    }
}

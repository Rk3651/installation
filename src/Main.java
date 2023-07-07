import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static StringBuilder logBuilder = new StringBuilder();
    private static ArrayList<String> fileSystemElements = new ArrayList<>();

    public static void main(String[] args) {
        String baseDir = "D:/Games";
        createDirectory(baseDir + "/src");
        createDirectory(baseDir + "/res");
        createDirectory(baseDir + "/savegames");
        createDirectory(baseDir + "/temp");

        createFile(baseDir + "/src/main/Main.java");
        createFile(baseDir + "/src/main/Utils.java");

        createDirectory(baseDir + "/res/drawables");
        createDirectory(baseDir + "/res/vectors");
        createDirectory(baseDir + "/res/icons");

        createFile(baseDir + "/temp/temp.txt");

        writeFile(logBuilder.toString(), baseDir + "/temp/temp.txt");
    }

    private static void createDirectory(String path) {
        File directory = new File(path);
        boolean created = directory.mkdir();
        fileSystemElements.add(path + ": " + (created ? "Создана успешно" : "Не удалось создать"));
        logBuilder.append("Создана директория: ").append(path).append("\n");
    }

    private static void createFile(String path) {
        File file = new File(path);
        boolean created = false;
        try {
            created = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileSystemElements.add(path + ": " + (created ? "Создан успешно" : "Не удалось создать"));
        logBuilder.append("Создан файл: ").append(path).append("\n");
    }

    private static void writeFile(String content, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
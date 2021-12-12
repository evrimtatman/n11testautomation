package common;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;


public class TestUtil {

    private static String LINK_FILE_PATH = "links/links.txt";

    public static void writeFile(List<String> linkList) {
        try {
            FileUtils.writeLines(new File(LINK_FILE_PATH), linkList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile() {
        try {
            return FileUtils.readLines(new File(LINK_FILE_PATH), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}

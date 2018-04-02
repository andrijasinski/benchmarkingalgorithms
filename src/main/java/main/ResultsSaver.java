package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class ResultsSaver {

    private final String savingFolder = "./results/";
    private Path file;
    private final static Logger log = (Logger) LogManager.getLogger(ResultsSaver.class);

    public ResultsSaver(String filename) {
        file = Paths.get(savingFolder + filename + getTimestamp() + ".csv");
    }

    public void writeResults(List<String> data) throws IOException {
        Files.createDirectories(Paths.get(savingFolder));
        Files.write(file, data, Charset.forName("UTF-8"));
        log.info("Results are saved");
    }

    private String getTimestamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
        return sdf.format(new Timestamp(System.currentTimeMillis()));
    }
}

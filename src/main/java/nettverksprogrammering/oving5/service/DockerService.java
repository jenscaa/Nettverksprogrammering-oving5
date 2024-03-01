package nettverksprogrammering.oving5.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import nettverksprogrammering.oving5.docker.DockerRunner;
import org.springframework.stereotype.Service;

@Service
public class DockerService {

  public DockerRunner dockerRunner = new DockerRunner();

  public void writeToTempFile(String code) {
    try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Jens\\Documents\\IDATT2104\\oving5\\src\\main\\java\\nettverksprogrammering\\oving5\\docker\\Main.java"))) {
      writer.write("package nettverksprogrammering.oving5.docker;\n\n");
      writer.write(code);
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getProgramOutput(String code) {
    writeToTempFile(code);
    return dockerRunner.getProgramOutput();

  }
}

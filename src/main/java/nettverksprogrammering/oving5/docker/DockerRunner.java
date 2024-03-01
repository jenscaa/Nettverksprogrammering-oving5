package nettverksprogrammering.oving5.docker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DockerRunner {



  public String getProgramOutput() {
    StringBuilder output = new StringBuilder();

    try {
      // Define the Docker build command
      String[] commandBuild = {
          "docker",
          "build",
          "-t",
          "run-java-code-image",
          "C:\\Users\\Jens\\Documents\\IDATT2104\\oving5\\src\\main\\java\\nettverksprogrammering\\oving5\\docker"
      };

      String[] runCommand = {
          "docker",
          "run",
          "--rm",
          "run-java-code-image"
      };

      // Create a process builder with the specified command
      ProcessBuilder builder = new ProcessBuilder(commandBuild);
      builder.start();

      ProcessBuilder processBuilder = new ProcessBuilder(runCommand);

      // Redirect error stream to output stream
      processBuilder.redirectErrorStream(true);

      // Start the process
      Process process = processBuilder.start();

      // Read the process output
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(output);
    return output.toString();
  }
}

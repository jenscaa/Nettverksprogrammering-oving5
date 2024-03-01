package nettverksprogrammering.oving5.controller;

import nettverksprogrammering.oving5.service.DockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oving5")
@CrossOrigin
public class DockerController {

  @Autowired
  public DockerService dockerService;

  @PostMapping("/run")
  public String runCode(@RequestBody String code) {
    return dockerService.getProgramOutput(code);
  }

}

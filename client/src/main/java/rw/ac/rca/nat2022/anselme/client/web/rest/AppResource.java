package rw.ac.rca.nat2022.anselme.client.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AppResource {

    @GetMapping
    public String index() {
        return "index";
    }
}

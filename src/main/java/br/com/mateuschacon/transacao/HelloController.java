package br.com.mateuschacon.transacao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "hello")
public class HelloController {
    
    @GetMapping
    public String getMethodName() {
        return "Hello";
    }
    
}

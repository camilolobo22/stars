package com.Stars.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoginController {
	
	@GetMapping("/")
	public String HomeTemplate(Model model) {
		return "home-general";
	}
	
	@GetMapping("/login")
	public String LoginTemplate(Model model) {
		return "login-general";
	}
	
    @GetMapping("/catalogo")
    public String catalogo(Model model) {
        return "catalogo";
    }
    
    @GetMapping("/pagos")
    public String pagos(Model model) {
        return "pagos";
    }
    
    @GetMapping("/preguntas")
    public String preguntas(Model model) {
        return "preguntas";
    }
    
    @GetMapping("/privacidad")
    public String privacidad(Model model) {
        return "privacidad";
    }
    
    @GetMapping("/contacto")
    public String contacto(Model model) {
        return "contacto";
    }

}

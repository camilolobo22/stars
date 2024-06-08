package com.Stars.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Stars.app.entidades.Perfil;
import com.Stars.app.repository.PerfilRepository;

@Controller
@RequestMapping("/perfil/web")
public class PerfilWebController {
	
	@Autowired
    private PerfilRepository perfilRepository;

    @GetMapping("/listar")
    public String listarPerfil(Model model) {
        List<Perfil> perfil = perfilRepository.findAll();
        model.addAttribute("perfil", perfil);
        return "listarPerfil";
    }

    @GetMapping("/crear")
    public String crearPerfilForm(Model model) {
        model.addAttribute("perfil", new Perfil());
        return "crearPerfil";
    }

    @PostMapping("/crear")
    public String guardarPerfil(@ModelAttribute Perfil perfil) {
        perfilRepository.save(perfil);
        return "redirect:/perfil/web/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarPerfilForm(@PathVariable("id") String id, Model model) {
        Perfil perfil = perfilRepository.findById(id).orElse(null);
        if (perfil != null) {
            model.addAttribute("perfil", perfil);
            return "editarPerfil";
        } else {
            return "redirect:/perfil/web/listar";
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizarPerfil(@PathVariable("id") String id, @ModelAttribute Perfil perfil) {
        perfil.setId(id);
        perfilRepository.save(perfil);
        return "redirect:/perfil/web/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPerfilForm(@PathVariable("id") String id, Model model) {
        Perfil perfil = perfilRepository.findById(id).orElse(null);
        if (perfil != null) {
            model.addAttribute("perfil", perfil);
            return "eliminarPerfil";
        } else {
            return "redirect:/perfil/web/listar";
        }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarPerfil(@PathVariable("id") String id) {
        perfilRepository.deleteById(id);
        return "redirect:/perfil/web/listar";
    }

}

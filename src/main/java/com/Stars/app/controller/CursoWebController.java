package com.Stars.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Stars.app.entidades.Curso;
import com.Stars.app.repository.CursoRepository;

import java.util.List;

@Controller
@RequestMapping("/cursos/web")
public class CursoWebController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/listar")
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoRepository.findAll();
        model.addAttribute("cursos", cursos);
        return "listarCursos";
    }

    @GetMapping("/crear")
    public String crearCursoForm(Model model) {
        model.addAttribute("curso", new Curso());
        return "crearCurso";
    }

    @PostMapping("/crear")
    public String guardarCurso(@ModelAttribute Curso curso) {
        cursoRepository.save(curso);
        return "redirect:/cursos/web/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarCursoForm(@PathVariable("id") String id, Model model) {
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso != null) {
            model.addAttribute("curso", curso);
            return "editarCurso";
        } else {
            return "redirect:/cursos/web/listar";
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizarCurso(@PathVariable("id") String id, @ModelAttribute Curso curso) {
        curso.setId(id);
        cursoRepository.save(curso);
        return "redirect:/cursos/web/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCursoForm(@PathVariable("id") String id, Model model) {
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso != null) {
            model.addAttribute("curso", curso);
            return "eliminarCurso";
        } else {
            return "redirect:/cursos/web/listar";
        }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable("id") String id) {
        cursoRepository.deleteById(id);
        return "redirect:/cursos/web/listar";
    }
}

package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // Necesario para el método de guardar
import org.springframework.web.bind.annotation.ModelAttribute; // Necesario para recibir el objeto del formulario
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import com.cibertec.model.Subject;
import com.cibertec.repository.ISubjectRepository;

@Controller
@RequestMapping("/") // Mapeo base opcional, si no se usa, funciona a nivel de método
public class ProyectoController {

    @Autowired
    private ISubjectRepository repos;

    // 1. RUTA RAÍZ (Corrección más importante): Redirige la URL base (/) a la lista
    @GetMapping("/")
    public String index() {
        // Redirección interna a la ruta /listado
        return "redirect:/listado";
    }

    // 2. Método para Listar todos los Subjects
    // Mapea a la URL: http://localhost:8025/listado
    @GetMapping("/listado")
    public String listSubject(Model model) {
        
        List<Subject> subjects = repos.findAll();
        
        // El modelo pasa la lista con el nombre 'lstSubject' a listado.html
        model.addAttribute("lstSubject", subjects);
        
        return "listado"; // Retorna la vista listado.html
    }
    
    // 3. Método GET para MOSTRAR el formulario de registro
    // Mapea a la URL: http://localhost:8025/registro
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        // Pasa un objeto Subject vacío al formulario (para que el formulario Thymeleaf lo llene)
        model.addAttribute("subject", new Subject());
        
        // Retorna la vista registro.html
        return "registro"; 
    }
    
    // 4. Método POST para PROCESAR y GUARDAR los datos del formulario
    // Mapea a la URL: /guardar (se invoca desde el formulario HTML)
    @PostMapping("/guardar")
    public String guardarSubject(@ModelAttribute Subject subject) {
        // Guarda el objeto Subject que fue llenado en el formulario
        repos.save(subject);
        
        // Redirige al usuario al listado para verificar que el registro fue exitoso
        return "redirect:/listado"; 
    }
}
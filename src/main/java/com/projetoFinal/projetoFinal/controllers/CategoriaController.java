package com.projetoFinal.projetoFinal.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.projetoFinal.projetoFinal.model.Categoria;
import com.projetoFinal.projetoFinal.model.CategoriaService;
import com.projetoFinal.projetoFinal.model.LivroService;

@Controller
@ComponentScan("com.projetoFinal.projetoFinal.model")
public class CategoriaController {
    
    @Autowired
    private ApplicationContext context;
    
    @GetMapping("/painel/categoria")
    public String formCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "pcriarcategoria";
    }
    
    @PostMapping("/painel/categoria")
    public String cadCategoria(
            @ModelAttribute Categoria cat,
            Model model
            ) {
        
        CategoriaService cats = context.getBean(CategoriaService.class);
        cats.cadCategoria(cat);
        return "redirect:/painel/categorias";
    }
    
    /*listar categorias no painel*/
    @GetMapping("/painel/categorias")
    public String listarCategoriasPainel(Model model){
        CategoriaService cat = context.getBean(CategoriaService.class);
        List<Map<String, Object>> categorias = cat.getCategoriasPainel();
        model.addAttribute("categorias",categorias);
        return "pcategorias";
            
    }
    
    @PostMapping("/painel/del/categoria/{id}")
    public String apagarCategoria(@PathVariable("id") int id) {
        CategoriaService cat = context.getBean(CategoriaService.class);
        cat.deleteCategoria(id);
        return "redirect:/painel/categorias";
    }
    
    @GetMapping("painel/upd/categoria/{id}")
    public String formAtualizarCategoria(@PathVariable("id") int id, Model model) {
        CategoriaService cat = context.getBean(CategoriaService.class);
        Map<String,Object> ct = cat.getCategoria(id);
        Categoria cats = new Categoria(id,ct.get("nm_Categoria").toString());
        model.addAttribute("categoria",cats);
        model.addAttribute("id",id);
        return "pupdatecategoria";
    }
    
    @PostMapping("/painel/upd/categoria/{id}")
    public String atualizarCategoria(@PathVariable("id") int id,
                                    Model model,
                                    @ModelAttribute Categoria cats) {
        CategoriaService cat = context.getBean(CategoriaService.class);
        cat.atualizarCategoria(id, cats);
        return "redirect:/painel/categorias";
    }
}
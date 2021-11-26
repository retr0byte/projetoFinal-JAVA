package com.projetoFinal.projetoFinal.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaDAO catdao;

    public void cadCategoria(Categoria cat) {
        catdao.cadCategoria(cat);
    }

    public Map<String,Object> getCategoria(int id) {
        return catdao.getCategoria(id);
    }

    public List<Map<String, Object>> getCategoriasPainel(){
        return catdao.getCategoriasPainel();
    }

    public void deleteCategoria(int id) {
        catdao.deleteCategoria(id);
    }

    public List<Map<String, Object>> listarCategoriasMenu(){
        return catdao.listarCategoriasMenu();
    }

    public void atualizarCategoria(int id, Categoria cat) {
        catdao.atualizarCategoria(id, cat);
    }
}
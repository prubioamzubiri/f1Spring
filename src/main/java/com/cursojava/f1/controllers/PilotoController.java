package com.cursojava.f1.controllers;

import com.cursojava.f1.dominio.Piloto;
import com.cursojava.f1.persistencia.IGestorDBClase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/piloto")
public class PilotoController {

    IGestorDBClase<Piloto> gp;

    public PilotoController(IGestorDBClase<Piloto> gp)
    {
        this.gp = gp;
    }

    @GetMapping("/{id}")
    public Piloto getPiloto(@PathVariable String id)
    {
        return gp.getElement(id);
    }

    @GetMapping("/init")
    public void initDB()
    {
        gp.insertData();
    }


    
}

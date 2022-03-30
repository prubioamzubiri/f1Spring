package com.cursojava.f1.controllers;

import com.cursojava.f1.dominio.Carrera;
import com.cursojava.f1.dominio.Circuito;
import com.cursojava.f1.dominio.Escuderia;
import com.cursojava.f1.dominio.Ingeniero;
import com.cursojava.f1.dominio.Piloto;
import com.cursojava.f1.dominio.Temporada;
import com.cursojava.f1.persistencia.IGestorDBClase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class DBinitController {

    private IGestorDBClase<Piloto> gp;
    private IGestorDBClase<Carrera> gcar;
    private IGestorDBClase<Ingeniero> gi;
    private IGestorDBClase<Temporada> gt;
    private IGestorDBClase<Escuderia> ge;
    private IGestorDBClase<Circuito> gcir;

    public DBinitController(IGestorDBClase<Piloto> gp,
                            IGestorDBClase<Carrera> gcar,
                            IGestorDBClase<Ingeniero> gi,
                            IGestorDBClase<Temporada> gt,
                            IGestorDBClase<Escuderia> ge,
                            IGestorDBClase<Circuito> gcir)
    {
        this.gp = gp;
        this.gcar = gcar;
        this.gi = gi;
        this.gt = gt;
        this.ge = ge;
        this.gcir = gcir;
    }

    @GetMapping("/init")
    public void initDB()
    {
        if (gp.getElements().size() == 0)
        {
            this.gp.insertData();        
            this.gi.insertData();
            this.ge.insertData();
            this.gcir.insertData();
            this.gcar.insertData();
            this.gt.insertData();
        }
 
    }
    
}

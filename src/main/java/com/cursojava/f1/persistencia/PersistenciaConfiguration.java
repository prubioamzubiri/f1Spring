package com.cursojava.f1.persistencia;

import com.cursojava.f1.dominio.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class PersistenciaConfiguration {

    @Bean
    Session getHibernatoSession()
    {
        Configuration cfg = this.connection();

        cfg.configure().addAnnotatedClass(Piloto.class)
                    .addAnnotatedClass(Ingeniero.class)
                    .addAnnotatedClass(Escuderia.class)
                    .addAnnotatedClass(Circuito.class)
                    .addAnnotatedClass(Carrera.class)
                    .addAnnotatedClass(Temporada.class);

        SessionFactory factory = cfg.buildSessionFactory();

        return factory.openSession();
    }

    private Configuration connection()
    {
        Configuration cfg = new Configuration();

        String connectionURL;
    

          connectionURL = "jdbc:mysql://127.0.0.1:3306/f1";
          cfg.setProperty("hibernate.connection.url", connectionURL);
    
         
          cfg.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
          cfg.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
    
          cfg.setProperty("hibernate.connection.username", "root");
    
          cfg.setProperty("hibernate.connection.password", "root");

          return cfg;

        
    }
    
    @Bean
    IGestorDBClase<Piloto> getGestorPiloto(Session session)
    {
        return new GestorPìlotos(session);
    }

    @Bean
    IGestorDBClase<Carrera> getGestorCarrera(Session session)
    {
        return new GestorCarrera(session);
    }

    @Bean
    IGestorDBClase<Circuito> getGestorCircuito(Session session)
    {
        return new GestorCircuito(session);
    }
    
    @Bean
    IGestorDBClase<Escuderia> getGestorEscuderia(Session session)
    {
        return new GestorEscuderias(session);
    }

    @Bean
    IGestorDBClase<Ingeniero> getGestoringenierio(Session session)
    {
        return new GestorIngenieros(session);
    }
    
    @Bean
    IGestorDBClase<Temporada> getGestorTemporada(Session session)
    {
        return new GestorTemporadas(session);
    }
}

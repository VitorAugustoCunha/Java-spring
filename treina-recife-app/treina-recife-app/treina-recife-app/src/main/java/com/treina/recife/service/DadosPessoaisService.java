package com.treina.recife.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.treina.recife.model.Contato;
import com.treina.recife.model.DadosPessoais;

public interface DadosPessoaisService extends JpaRepository<DadosPessoais, Long>  {
    
}

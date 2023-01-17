package com.treina.recife.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.treina.recife.model.DadosPessoais;
import com.treina.recife.service.DadosPessoaisService;

public class DadosPessoaisController {
    @PostMapping("/dadospessoais")
    public DadosPessoais criarNovoDadoPessoal(@RequestBody DadosPessoais dadosPessoais){
        return dadosPessoaisService.save(dadosPessoais);
    }
    @GetMapping("/dadospessoais")
    public Iterable<DadosPessoais>obterTodosDados(){
        return dadosPessoaisService.findAll();
    }
    @GetMapping("/dadospessoais/{id}")
    public DadosPessoais obterDadoPeloId(@PathVariable("id") long id){
        return dadosPessoaisService.findById(id).get();
    }
    @DeleteMapping("/dadospessoais/{id}")
    public String deletarDadosPeloId(@PathVariable("id") long id){
        dadosPessoaisService.deleteById(id);
        return "Contato dado deletado com sucesso!";
    }
    @PutMapping("/dadospessoais/{id}")
    public DadosPessoais atualizarDados(@RequestBody DadosPessoais dadosPessoais){
        dadosPessoais.setCpf(dadosPessoais.getCpf());
        dadosPessoais.setPis(dadosPessoais.getPis());
        dadosPessoais.setRg(dadosPessoais.getRg());
        dadosPessoaisService.save(dadosPessoais);
        return dadosPessoais;
    }
    @Autowired
    private DadosPessoaisService dadosPessoaisService;
}

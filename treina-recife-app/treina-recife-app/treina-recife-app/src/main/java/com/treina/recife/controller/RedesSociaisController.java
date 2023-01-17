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

import com.treina.recife.model.RedesSociais;
import com.treina.recife.service.RedesSociaisService;


@RestController
public class RedesSociaisController {

    @PostMapping("/redessociais")
    public RedesSociais criarNovaRede(@RequestBody RedesSociais redesSociais){
        return redesSociaisService.save(redesSociais);
    }
    @GetMapping("/redessociais")
    public Iterable<RedesSociais>obterTodasRedes(){
        return redesSociaisService.findAll();
    }
    @GetMapping("/redessociais/{id}")
    public RedesSociais obterContatoPeloId(@PathVariable("id") long id){
        return redesSociaisService.findById(id).get();
    }
    @DeleteMapping("/redessociais/{id}")
    public String deletarContatosPeloId(@PathVariable("id") long id){
        redesSociaisService.deleteById(id);
        return "Contato deletado com sucesso!";
    }
    @PutMapping("/dadospessoais/{id}")
    public RedesSociais atualizarRedes(@RequestBody RedesSociais redesSociais){
        redesSociais.setLink(redesSociais.getLink());
        redesSociais.setNome(redesSociais.getNome());
        return redesSociais;
    }
    @Autowired
    private RedesSociaisService redesSociaisService;
}

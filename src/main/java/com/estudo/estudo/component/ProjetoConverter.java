package com.estudo.estudo.component;

import com.estudo.estudo.projeto.entity.ProjetoEntity;
import com.estudo.estudo.projeto.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProjetoConverter implements Converter<String, ProjetoEntity> {

    @Autowired
    private ProjetoService projetoService;

    @Override
    public ProjetoEntity convert(String s) {
        return projetoService.obterPorId(Integer.parseInt(s));
    }
}

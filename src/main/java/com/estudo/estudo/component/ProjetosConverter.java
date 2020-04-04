package com.estudo.estudo.component;

import com.estudo.estudo.projeto.entity.ProjetoEntity;
import com.estudo.estudo.projeto.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjetosConverter implements Converter<String[], List<ProjetoEntity>> {

    private ProjetoService projetoService;

    @Autowired
    public ProjetosConverter(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @Override
    public List<ProjetoEntity> convert(String[] projetos) {
        return projetoService.getByIds(Arrays.stream(projetos).map(Integer::parseInt).collect(Collectors.toList()));
    }
}

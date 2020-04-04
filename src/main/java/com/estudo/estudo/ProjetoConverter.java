package com.estudo.estudo;

import com.estudo.estudo.projeto.entity.ProjetoEntity;
import com.estudo.estudo.projeto.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjetoConverter implements Converter<String[], List<ProjetoEntity>> {

    private ProjetoService projetoService;

    @Autowired
    public ProjetoConverter(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @Override
    public List<ProjetoEntity> convert(String[] projetos) {
        return projetoService.getByIds(Arrays.stream(projetos).map(Integer::parseInt).collect(Collectors.toList()));
    }
}

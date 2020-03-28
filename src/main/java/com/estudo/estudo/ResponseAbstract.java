package com.estudo.estudo;

import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

public abstract class ResponseAbstract {

    private Map<String, Object> attributesAndValues;

    public ResponseAbstract() {
        this.attributesAndValues = new HashMap<>();
    }

    public ResponseAbstract uploadAttributesModel(Model model) {
        attributesAndValues.forEach(model::addAttribute);
        return this;
    }

    public ResponseAbstract addResponseAttribute(String key, Object value) {
        attributesAndValues.put(key, value);
        return this;
    }

    public String redirect(Action actionRedirect) {
        return actionRedirect.getAction();
    }
}

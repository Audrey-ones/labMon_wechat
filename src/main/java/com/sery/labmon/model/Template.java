package com.sery.labmon.model;

import java.util.List;

/**
 * Created by LuDan on 2018/5/8 11:20
 */
public class Template {
    private List<String> template;

    public Template(List<String> template) {
        this.template = template;
    }

    public Template() {
    }

    public List<String> getTemplate() {
        return template;
    }

    public void setTemplate(List<String> template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return "Template{" +
                "template=" + template +
                '}';
    }
}

package com.sery.labmon.model;

/**
 * Created by LuDan on 2018/4/23 9:40
 */
public class DataTemplates {
    private Integer dataTemplateId;
    private String name;
    private String description;
    private String template;

    public DataTemplates(Integer dataTemplateId, String name, String description, String template) {
        this.dataTemplateId = dataTemplateId;
        this.name = name;
        this.description = description;
        this.template = template;
    }

    public DataTemplates() {
    }

    public Integer getDataTemplateId() {
        return dataTemplateId;
    }

    public void setDataTemplateId(Integer dataTemplateId) {
        this.dataTemplateId = dataTemplateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return "DataTemplates{" +
                "dataTemplateId=" + dataTemplateId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", template='" + template + '\'' +
                '}';
    }
}

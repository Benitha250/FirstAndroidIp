package com.example.firstandroidip;

public class Model {
    private String design;
    private String opinion_edit;

    public Model() {
    }

    public Model(String design, String opinion_edit) {
        this.design = design;
        this.opinion_edit = opinion_edit;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getOpinion_edit() {
        return opinion_edit;
    }

    public void setOpinion_edit(String opinion_edit) {
        this.opinion_edit = opinion_edit;
    }
}

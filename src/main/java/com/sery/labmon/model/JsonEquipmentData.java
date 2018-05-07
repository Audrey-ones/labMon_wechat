package com.sery.labmon.model;

import java.util.List;

/**
 * Created by LuDan on 2018/5/7 11:49
 */
public class JsonEquipmentData {
    private Integer I;
    private List<Double> S;
    private Boolean O;
    private Boolean D;
    private Boolean R;
    private Boolean V;

    public JsonEquipmentData(Integer i, List<Double> s, Boolean o, Boolean d, Boolean r, Boolean v) {
        I = i;
        S = s;
        O = o;
        D = d;
        R = r;
        V = v;
    }

    public JsonEquipmentData() {
    }

    public Integer getI() {
        return I;
    }

    public void setI(Integer i) {
        I = i;
    }

    public List<Double> getS() {
        return S;
    }

    public void setS(List<Double> s) {
        S = s;
    }

    public Boolean getO() {
        return O;
    }

    public void setO(Boolean o) {
        O = o;
    }

    public Boolean getD() {
        return D;
    }

    public void setD(Boolean d) {
        D = d;
    }

    public Boolean getR() {
        return R;
    }

    public void setR(Boolean r) {
        R = r;
    }

    public Boolean getV() {
        return V;
    }

    public void setV(Boolean v) {
        V = v;
    }

    @Override
    public String toString() {
        return "JsonEquipmentData{" +
                "I=" + I +
                ", S=" + S +
                ", O=" + O +
                ", D=" + D +
                ", R=" + R +
                ", V=" + V +
                '}';
    }
}

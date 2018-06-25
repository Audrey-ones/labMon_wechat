package com.sery.labmon.model;

import java.util.List;

/**
 * Created by LuDan on 2018/5/7 11:49
 */
public class JsonEquipmentData {
    private Integer I;
    private List<Double> S;
    private Integer O;
    private Integer D;
    private Integer R;
    private Integer V;

    public JsonEquipmentData(Integer i, List<Double> s, Integer o, Integer d, Integer r, Integer v) {
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

    public Integer getO() {
        return O;
    }

    public void setO(Integer o) {
        O = o;
    }

    public Integer getD() {
        return D;
    }

    public void setD(Integer d) {
        D = d;
    }

    public Integer getR() {
        return R;
    }

    public void setR(Integer r) {
        R = r;
    }

    public Integer getV() {
        return V;
    }

    public void setV(Integer v) {
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

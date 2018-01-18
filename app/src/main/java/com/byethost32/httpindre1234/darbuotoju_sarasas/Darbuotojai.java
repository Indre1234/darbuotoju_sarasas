package com.byethost32.httpindre1234.darbuotoju_sarasas;

/**
 * Created by moksleivis on 2018-01-18.
 */

public class Darbuotojai {
    private String id;
    private String vartotojas;
    private String iraso_sukurimo_data;
    private String vardas;
    private String pavarde;
    private String asmens_kodas;
    private String pareigos;
    private String atlyginimas;
    private String v_data;
    private String lytis;

    public Darbuotojai(String id, String vartotojas, String iraso_sukurimo_data, String vardas, String pavarde, String asmens_kodas, String pareigos, String atlyginimas, String v_data, String lytis) {
        this.id = id;
        this.vartotojas = vartotojas;
        this.iraso_sukurimo_data = iraso_sukurimo_data;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.asmens_kodas = asmens_kodas;
        this.pareigos = pareigos;
        this.atlyginimas = atlyginimas;
        this.v_data = v_data;
        this.lytis = lytis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVartotojas() {
        return vartotojas;
    }

    public void setVartotojas(String vartotojas) {
        this.vartotojas = vartotojas;
    }

    public String getIraso_sukurimo_data() {
        return iraso_sukurimo_data;
    }

    public void setIraso_sukurimo_data(String iraso_sukurimo_data) {
        this.iraso_sukurimo_data = iraso_sukurimo_data;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getAsmens_kodas() {
        return asmens_kodas;
    }

    public void setAsmens_kodas(String asmens_kodas) {
        this.asmens_kodas = asmens_kodas;
    }

    public String getPareigos() {
        return pareigos;
    }

    public void setPareigos(String pareigos) {
        this.pareigos = pareigos;
    }

    public String getAtlyginimas() {
        return atlyginimas;
    }

    public void setAtlyginimas(String atlyginimas) {
        this.atlyginimas = atlyginimas;
    }

    public String getV_data() {
        return v_data;
    }

    public void setV_data(String v_data) {
        this.v_data = v_data;
    }

    public String getLytis() {
        return lytis;
    }

    public void setLytis(String lytis) {
        this.lytis = lytis;
    }
}



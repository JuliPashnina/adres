package ru.esbt.adres.entity;

import java.util.UUID;

/**
 *
 * @author Y.Pashnina
 */
public class Data implements DomainObject {

    private UUID cmOkato;
    private String cmCtext;
    private String cmSocr;

    public Data(UUID cmOkato, String description) {
        this.cmOkato = cmOkato;
        this.cmCtext = cmCtext;
        this.cmSocr = cmSocr;
    }

    public UUID getCmOkato() {
        return cmOkato;
    }

    public void setCmOkato(UUID cmOkato) {
        this.cmOkato = cmOkato;
    }

    public String getCmCtext() {
        return cmCtext;
    }

    public void setCmCtext(String cmCtext) {
        this.cmCtext = cmCtext;
    }

    public String getCmSocr() {
        return cmCtext;
    }

    public void setCmSocr(String cmSocr) {
        this.cmSocr = cmSocr;
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
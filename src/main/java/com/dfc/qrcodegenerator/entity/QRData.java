package com.dfc.qrcodegenerator.entity;

import net.glxn.qrgen.core.scheme.EMail;
import net.glxn.qrgen.core.scheme.Telephone;
import net.glxn.qrgen.core.scheme.VCard;

public class QRData {

    private String inputText = "";
    private String imageText = "";
    private String type;

    private VCard vCard;
    private EMail eMail;
    private Telephone telephone;


    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getImageText() {
        return imageText;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VCard getvCard() {
        return vCard;
    }

    public void setvCard(VCard vCard) {
        this.vCard = vCard;
    }

    public EMail geteMail() {
        return eMail;
    }

    public void seteMail(EMail eMail) {
        this.eMail = eMail;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }
}

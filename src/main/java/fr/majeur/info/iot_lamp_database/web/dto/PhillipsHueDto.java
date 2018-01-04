package fr.majeur.info.iot_lamp_database.web.dto;

import fr.majeur.info.iot_lamp_database.model.PhillipsHue;

public class PhillipsHueDto {
    private Boolean on;
    private Long sat;
    private Long bri;

    public PhillipsHueDto(PhillipsHue phillipsHue) {
        sat = phillipsHue.getSat();
        bri = phillipsHue.getBri();
        on = phillipsHue.getState();
    }

    public Boolean getOn() {
        return on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }

    public Long getSat() {
        return sat;
    }

    public void setSat(Long sat) {
        this.sat = sat;
    }

    public Long getBri() {
        return bri;
    }

    public void setBri(Long bri) {
        this.bri = bri;
    }
}

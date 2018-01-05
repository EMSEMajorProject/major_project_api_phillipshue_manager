package fr.majeur.info.iot_lamp_database.model;

import javax.persistence.*;

@Entity
public class PhillipsHue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long sat;

    @Column
    private Long bri;

    @Column
    private Long hue;

    @Column
    private Boolean state;

    public PhillipsHue() {
    }

    public PhillipsHue(Long sat, Long bri, Long hue, Boolean state) {
        this.sat = sat;
        this.bri = bri;
        this.hue = hue;
        this.state = state;
    }

    public void switchLight(){
        state = state == false ? true : false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Long getHue() {
        return hue;
    }

    public void setHue(Long hue) {
        this.hue = hue;
    }
}

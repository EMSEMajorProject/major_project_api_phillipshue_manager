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
    private Boolean state;

    public PhillipsHue() {
    }

    public PhillipsHue(Long sat, Long bri, Boolean on) {
        this.sat = sat;
        this.bri = bri;
        this.state = on;
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
}

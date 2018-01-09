package fr.majeur.info.iot_lamp_database.web.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.majeur.info.iot_lamp_database.model.PhillipsHue;

public class ColorDto {
    private Long sat;
    private Long bri;
    private Long hue;

    @JsonCreator
    public ColorDto(@JsonProperty("sat") Long sat,
                    @JsonProperty("bri") Long bri,
                    @JsonProperty("hue") Long hue) {
        this.sat = sat;
        this.bri = bri;
        this.hue = hue;
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

    public Long getHue() {
        return hue;
    }

    public void setHue(Long hue) {
        this.hue = hue;
    }
}

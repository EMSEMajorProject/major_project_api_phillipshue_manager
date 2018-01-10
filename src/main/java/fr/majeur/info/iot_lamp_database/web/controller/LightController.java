package fr.majeur.info.iot_lamp_database.web.controller;

import fr.majeur.info.iot_lamp_database.MQTT.CloudMQTT;
import fr.majeur.info.iot_lamp_database.Util;
import fr.majeur.info.iot_lamp_database.dao.PhillipsHueDao;
import fr.majeur.info.iot_lamp_database.model.PhillipsHue;
import fr.majeur.info.iot_lamp_database.web.dto.ColorDto;
import fr.majeur.info.iot_lamp_database.web.dto.PhillipsHueDto;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/lights")
@Transactional
public class LightController {

    @Autowired
    private CloudMQTT cloudMQTT;

    @Autowired
    private PhillipsHueDao phillipsHueDao;

    @GetMapping(value = "/{id}")
    public PhillipsHueDto getlight(@PathVariable Long id) {
        return new PhillipsHueDto(phillipsHueDao.findOne(id));
    }

    @GetMapping
    public List<PhillipsHueDto> getall() {
        return phillipsHueDao.findAll().stream().map(PhillipsHueDto::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/{id}/switch")
    public PhillipsHueDto switchlight(@PathVariable Long id) throws MqttException {
        PhillipsHue phillipsHue = phillipsHueDao.findOne(id);
        phillipsHue.switchLight();
        cloudMQTT.publish("switchTopic","true");
        cloudMQTT.subscribe(Util.topics);
        return new PhillipsHueDto(phillipsHue);
    }

    @PutMapping(value = "/{id}/sat/{sat}")
    public PhillipsHueDto setsat(@PathVariable Long id, @PathVariable Long sat) throws MqttException {
        PhillipsHue phillipsHue = phillipsHueDao.findOne(id);
        phillipsHue.setSat(sat);
        cloudMQTT.publish("satTopic",sat.toString());
        cloudMQTT.subscribe(Util.topics);
        return new PhillipsHueDto(phillipsHue);
    }

    @PutMapping(value = "/{id}/bri/{bri}")
    public PhillipsHueDto setbri(@PathVariable Long id, @PathVariable Long bri) throws MqttException {
        PhillipsHue phillipsHue = phillipsHueDao.findOne(id);
        phillipsHue.setBri(bri);
        cloudMQTT.publish("briTopic", bri.toString());
        cloudMQTT.subscribe(Util.topics);
        return new PhillipsHueDto(phillipsHue);
    }

    @PutMapping(value = "/{id}/hue/{hue}")
    public PhillipsHueDto sethue(@PathVariable Long id, @PathVariable Long hue) throws MqttException {
        PhillipsHue phillipsHue = phillipsHueDao.findOne(id);
        phillipsHue.setHue(hue);
        cloudMQTT.publish("lumTopic",hue.toString());
        cloudMQTT.subscribe(Util.topics);
        return new PhillipsHueDto(phillipsHue);
    }

    @PostMapping(value = "/{id}/color")
    public PhillipsHueDto setColor(@PathVariable Long id, @RequestBody ColorDto colorDto) throws MqttException {
        PhillipsHue phillipsHue = phillipsHueDao.findOne(id);
        phillipsHue.setHue(colorDto.getHue());
        phillipsHue.setBri(colorDto.getBri());
        phillipsHue.setSat(colorDto.getSat());
        cloudMQTT.publish("lumTopic",colorDto.getHue().toString());
        cloudMQTT.publish("briTopic",colorDto.getBri().toString());
        cloudMQTT.publish("satTopic",colorDto.getSat().toString());
        cloudMQTT.subscribe(Util.topics);
        return new PhillipsHueDto(phillipsHue);
    }
}

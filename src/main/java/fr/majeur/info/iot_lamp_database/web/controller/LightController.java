package fr.majeur.info.iot_lamp_database.web.controller;

import fr.majeur.info.iot_lamp_database.dao.PhillipsHueDao;
import fr.majeur.info.iot_lamp_database.model.PhillipsHue;
import fr.majeur.info.iot_lamp_database.web.dto.PhillipsHueDto;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/lights")
@Transactional
public class LightController {
    private final PhillipsHueDao phillipsHueDao;

    public LightController(PhillipsHueDao phillipsHueDao) {
        this.phillipsHueDao = phillipsHueDao;
    }

    @GetMapping(value = "/getlight/{id}")
    public PhillipsHueDto getlight(@PathVariable Long id) {
        return new PhillipsHueDto(phillipsHueDao.findOne(id));
    }

    @GetMapping(value = "/all")
    public List<PhillipsHueDto> getall() {
        return phillipsHueDao.findAll().stream().map(PhillipsHueDto::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/switchlight/{id}")
    public PhillipsHueDto switchlight(@PathVariable Long id) {
        PhillipsHue phillipsHue = phillipsHueDao.findOne(id);
        if (phillipsHue.getState()) {
            phillipsHue.setState(false);
        } else {
            phillipsHue.setState(true);
        }
        return new PhillipsHueDto(phillipsHue);
    }

    @PostMapping(value = "/setsat/{id}/{sat}")
    public PhillipsHueDto setsat(@PathVariable Long id, @PathVariable Long sat) {
        PhillipsHue phillipsHue = phillipsHueDao.findOne(id);
        phillipsHue.setSat(sat);
        return new PhillipsHueDto(phillipsHue);
    }

    @PostMapping(value = "/setbri/{id}/{bri}")
    public PhillipsHueDto setbri(@PathVariable Long id, @PathVariable Long bri) {
        PhillipsHue phillipsHue = phillipsHueDao.findOne(id);
        phillipsHue.setBri(bri);
        return new PhillipsHueDto(phillipsHue);
    }
}

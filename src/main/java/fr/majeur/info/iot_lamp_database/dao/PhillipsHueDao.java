package fr.majeur.info.iot_lamp_database.dao;

import fr.majeur.info.iot_lamp_database.model.PhillipsHue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhillipsHueDao extends JpaRepository<PhillipsHue, Long> {
}

package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class DevicesImportDto {
    @XmlElement(name = "device")
    private List<DeviceInputDto> input;
}

package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "mountaineers")
@XmlAccessorType(XmlAccessType.FIELD)
public class MountaineerImportDto {
    @XmlElement(name = "mountaineer")
    List<MountaineerInputDto> mountaineers;
}

package avtoproject.service.factory;

import avtoproject.entity.FirmAvto;
import org.springframework.stereotype.Component;

@Component
public class FirmAvtoFactory {

    public FirmAvto build(String Firm) {
        return new FirmAvto(Firm);
    }
}

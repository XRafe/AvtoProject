package avtoProject.service.factory;

import avtoProject.entity.FirmAvto;
import org.springframework.stereotype.Component;

@Component
public class FirmAvtoFactory {

    public FirmAvto build(String Firm) {
        return new FirmAvto(Firm);
    }
}

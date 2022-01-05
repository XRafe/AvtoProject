package AvtoProject.service.factory;

import AvtoProject.entity.FirmAvto;
import org.springframework.stereotype.Component;

@Component
public class FirmAvtoFactory {

    public FirmAvto build(String Firm) {
        return new FirmAvto(Firm);
    }
}

package ru.ezhov.cdi;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by rrnezh on 26.10.2017.
 */
@EightDigits
public class IssnGenerator  implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Generated ISSN: " + issn);
        return issn;
    }
}
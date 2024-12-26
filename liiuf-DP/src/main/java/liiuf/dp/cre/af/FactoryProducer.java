package liiuf.dp.cre.af;

import liiuf.dp.cre.af.factory.AbstractFactory;
import liiuf.dp.cre.af.factory.HaierFactory;
import liiuf.dp.cre.af.factory.HisenseFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String type) {
        if("haier".equals(type)) {
            return new HaierFactory();
        }

        return new HisenseFactory();
    }
}
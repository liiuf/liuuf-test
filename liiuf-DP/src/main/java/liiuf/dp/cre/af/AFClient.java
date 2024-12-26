package liiuf.dp.cre.af;

import liiuf.dp.cre.af.factory.AbstractFactory;

public class AFClient {
    public static void main(String[] args) {
        AbstractFactory haier = FactoryProducer.getFactory("haier");
        haier.createTV().exec();
        haier.createFreezer().exec();

        AbstractFactory hisense = FactoryProducer.getFactory("hisense");
        hisense.createTV().exec();
        hisense.createFreezer().exec();
    }
}
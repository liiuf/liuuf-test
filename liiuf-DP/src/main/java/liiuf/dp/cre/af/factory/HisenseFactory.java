package liiuf.dp.cre.af.factory;

import liiuf.dp.cre.af.bean.*;

public class HisenseFactory extends AbstractFactory {

    @Override
    public AbstractProductTV createTV() {
        return new HisenseTV();
    }

    @Override
    public AbstractProductFreezer createFreezer() {
        return new HisenseFreezer();
    }
}
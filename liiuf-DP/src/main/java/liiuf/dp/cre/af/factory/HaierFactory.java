package liiuf.dp.cre.af.factory;

import liiuf.dp.cre.af.bean.AbstractProductFreezer;
import liiuf.dp.cre.af.bean.AbstractProductTV;
import liiuf.dp.cre.af.bean.HaierFreezer;
import liiuf.dp.cre.af.bean.HaierTV;

public class HaierFactory extends AbstractFactory {
    @Override
    public AbstractProductTV createTV() {
        return new HaierTV();
    }

    @Override
    public AbstractProductFreezer createFreezer() {
        return new HaierFreezer();
    }
}
package liiuf.dp.cre.af.factory;

import liiuf.dp.cre.af.bean.AbstractProductFreezer;
import liiuf.dp.cre.af.bean.AbstractProductTV;

public abstract class AbstractFactory {
    public abstract AbstractProductTV createTV();
    public abstract AbstractProductFreezer createFreezer();
}
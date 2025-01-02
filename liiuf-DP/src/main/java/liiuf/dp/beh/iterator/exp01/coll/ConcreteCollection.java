package liiuf.dp.beh.iterator.exp01.coll;

import liiuf.dp.beh.iterator.exp01.iter.DIterator;

public class ConcreteCollection implements DCollection {
    public String names[] = {"Ethan", "Jason", "Karen", "Ascii", "Java", "Python"};
    @Override
    public DIterator getDIterator() {
        return new ConcreteIterator();
    }

    /**
     * 使用私有内部类实现具体的迭代器，当然也可以提取成一个公有类，那就需要迭代器类和集合类相互引用，采用全局变量的方式。
     */
    private class ConcreteIterator implements DIterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if(hasNext()) {
                return names[index++];
            }

            return null;
        }
    }
}
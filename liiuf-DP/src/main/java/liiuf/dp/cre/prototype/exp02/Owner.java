package liiuf.dp.cre.prototype.exp02;

import java.io.Serializable;

public class Owner implements Serializable {
    private String name;

    public Owner(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                '}' + hashCode();
    }
}

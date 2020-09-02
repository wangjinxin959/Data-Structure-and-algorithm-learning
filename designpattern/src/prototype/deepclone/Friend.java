package prototype.deepclone;

import java.io.Serializable;

public class Friend implements Cloneable, Serializable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

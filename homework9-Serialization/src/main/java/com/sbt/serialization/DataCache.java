package com.sbt.serialization;

import java.io.Serializable;
import java.util.HashMap;

public class DataCache<T, P> extends HashMap<T, P> implements Serializable {
    public DataCache() {
        super();
    }

}

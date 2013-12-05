package com.skylark95.googl.api.factory;

public interface URLFactory<U> {
    
    abstract U create(String url);

}

package com.shuframework.designpattern.strategy;

import java.io.IOException;
import java.io.OutputStream;

// BEGIN CompressionStrategy
public interface CompressionStrategy {

    public OutputStream compress(OutputStream data) throws IOException;

}
// END CompressionStrategy

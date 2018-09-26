package com.shuframework.designpattern.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

// BEGIN Compressor
public class Compressor2 {

    private final CompressionStrategy strategy;

    public Compressor2(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compress(Path inFile, File outFile) throws IOException {
        try (OutputStream outStream = new FileOutputStream(outFile)) {
            Files.copy(inFile, strategy.compress(outStream));
        }
    }
// END Compressor

    public static void classBasedExample(Path inFile, File outFile) throws IOException {
// BEGIN classBasedExample
        Compressor2 gzipCompressor = new Compressor2(new GzipCompressionStrategy());
        gzipCompressor.compress(inFile, outFile);

        Compressor2 zipCompressor = new Compressor2(new ZipCompressionStrategy());
        zipCompressor.compress(inFile, outFile);
// END classBasedExample
    }

    public static void lambdaBasedExample(Path inFile, File outFile) throws IOException {
// BEGIN lambdaBasedExample
        Compressor2 gzipCompressor = new Compressor2(GZIPOutputStream::new);
        gzipCompressor.compress(inFile, outFile);

        Compressor2 zipCompressor = new Compressor2(ZipOutputStream::new);
        zipCompressor.compress(inFile, outFile);
// END lambdaBasedExample
    }

}

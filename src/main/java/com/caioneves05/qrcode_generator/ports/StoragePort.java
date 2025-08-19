package com.caioneves05.qrcode_generator.ports;

public interface StoragePort {
    String uploadFile(byte[] file, String fileName, String contentType);
}

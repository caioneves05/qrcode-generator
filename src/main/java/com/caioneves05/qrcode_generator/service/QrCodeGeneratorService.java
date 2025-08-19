package com.caioneves05.qrcode_generator.service;

import com.caioneves05.qrcode_generator.dto.QrCodeGenerateResponseDTO;
import com.caioneves05.qrcode_generator.ports.StoragePort;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeGeneratorService {

    private final StoragePort storage;

    public QrCodeGeneratorService(StoragePort storage) {
        this.storage = storage;
    }

    public QrCodeGenerateResponseDTO generateAndUploadQrCode(String content) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(content, com.google.zxing.BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix,"PNG", outputStream);
        byte[] qrCodeImage = outputStream.toByteArray();

        String url = storage.uploadFile(qrCodeImage, UUID.randomUUID().toString(), "image/png");

        return new QrCodeGenerateResponseDTO(url);

    }

}

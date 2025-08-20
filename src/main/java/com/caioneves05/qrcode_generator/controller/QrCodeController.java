package com.caioneves05.qrcode_generator.controller;

import com.caioneves05.qrcode_generator.dto.QrCodeGenerateRequestDTO;
import com.caioneves05.qrcode_generator.dto.QrCodeGenerateResponseDTO;
import com.caioneves05.qrcode_generator.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponseDTO> generate(@RequestBody QrCodeGenerateRequestDTO request){
        try {
            System.out.print(request);
            System.out.print("cc");
            return ResponseEntity.ok(this.qrCodeGeneratorService.generateAndUploadQrCode(request.text()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new QrCodeGenerateResponseDTO("Error generating QR code: " + e.getMessage()));
        }
    }
}

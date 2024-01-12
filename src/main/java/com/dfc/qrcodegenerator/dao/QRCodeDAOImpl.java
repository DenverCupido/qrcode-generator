package com.dfc.qrcodegenerator.dao;

import com.dfc.qrcodegenerator.entity.QRData;
import com.dfc.qrcodegenerator.util.QRCodeUtil;
import net.glxn.qrgen.core.exception.QRGenerationException;
import org.springframework.stereotype.Component;

@Component
public class QRCodeDAOImpl implements QRCodeDAO {

    private QRCodeUtil qrCodeUtil;

    public QRCodeDAOImpl(QRCodeUtil qrCodeUtil) {
        this.qrCodeUtil = qrCodeUtil;
    }

    @Override
    public String generateQRCode(QRData qrData) throws QRGenerationException {
        try {

            switch (qrData.getType()) {
                case "Text" -> {
                    return qrCodeUtil.generatePlainTextQRCode(qrData);
                }
                case "Mail" -> {
                    return qrCodeUtil.generateEMailQRCode(qrData);
                }
                case "vCard" -> {
                    return qrCodeUtil.generateVCardQRCode(qrData);
                }
                case "Cell" -> {
                    return qrCodeUtil.generateTelephoneQRCode(qrData);
                }
                default -> {
                    throw new Exception("Invalid Type");
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to generate QR Code : " + e);
            throw new QRGenerationException("Failed to generate QR Code", e);
        }
    }
}

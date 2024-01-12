package com.dfc.qrcodegenerator.dao;

import com.dfc.qrcodegenerator.entity.QRData;

public interface QRCodeDAO {

    String generateQRCode(QRData qrData) throws Exception;

}

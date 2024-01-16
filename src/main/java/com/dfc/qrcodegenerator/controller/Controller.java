package com.dfc.qrcodegenerator.controller;

import com.dfc.qrcodegenerator.dao.QRCodeDAOImpl;
import com.dfc.qrcodegenerator.entity.QRData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Value("${qrcode.types}")
    private List<String> qrCodeTypes;
    private QRCodeDAOImpl qrDAO;


    public Controller(QRCodeDAOImpl qrDAO, List<String> qrCodeTypes) {
        this.qrDAO = qrDAO;
        this.qrCodeTypes = qrCodeTypes;
    }

    @GetMapping("/")
    public String qrCode(Model model) {
        model.addAttribute("qrdata", new QRData());
        model.addAttribute("types", qrCodeTypes);
        return "qrcode";
    }

    @PostMapping("/")
    public String generate(@ModelAttribute("qrdata") QRData qrData, Model model) {

        String code = qrDAO.generateQRCode(qrData);
        qrData.setImageText(code);

        model.addAttribute("qrdata", qrData);
        model.addAttribute("types", qrCodeTypes);

        return "qrcode";
    }
}

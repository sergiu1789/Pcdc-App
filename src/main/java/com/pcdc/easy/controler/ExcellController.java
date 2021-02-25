package com.pcdc.easy.controler;

import com.pcdc.easy.service.ExcellService;
import com.pcdc.easy.utils.ExcelUtil;
import com.pcdc.easy.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class ExcellController {

   private final ExcellService excellService;

   @Autowired
    public ExcellController(ExcellService excellService) {
        this.excellService = excellService;
    }

    @PostMapping("/upload")

    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")MultipartFile file) {
       String message = "";

       if(ExcelUtil.hasExcellFormat(file)) {
           try {
               excellService.save(file);
               message = "Fisierul a fost urcat corect " + file.getOriginalFilename() + "!" ;
               return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
           }
           catch (Exception e) {
               message ="Fisieru nu a fost urcat " + file.getOriginalFilename();
               return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
           }

    }
        message="Alegeti Fisieru Excel" ;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}

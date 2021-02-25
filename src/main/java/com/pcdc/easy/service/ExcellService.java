package com.pcdc.easy.service;

import com.pcdc.easy.model.App.Pcdc;
import com.pcdc.easy.repository.PcdcRepository;
import com.pcdc.easy.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcellService {


    private final PcdcRepository pcdcRepository;

    @Autowired
    public ExcellService(PcdcRepository pcdcRepository) {
        this.pcdcRepository = pcdcRepository;
    }

    public void save(MultipartFile file) {
        try {
            List<Pcdc> pcdcList =  ExcelUtil.excelToPcdc(file.getInputStream());

            pcdcRepository.saveAll(pcdcList);
        }catch (IOException e) {
           throw  new RuntimeException( "nu sa salvat file" + e.getMessage());
        }

    }
  

    public List<Pcdc> findAll() {
        return pcdcRepository.findAll();
    }

}

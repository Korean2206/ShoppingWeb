package com.korea.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Service
public class ParamService {
    
    @Autowired
    HttpServletRequest request;

    public String getString(String name,String defaultValue) {
        String value = request.getParameter(name);
        return value != null ? value : defaultValue;
    }

    public int getInt(String name,int defaultValue) {
        String value = getString(name,String.valueOf(defaultValue));
        return Integer.valueOf(value);
    }

    public double getDouble(String name,double defaultValue) {
        String value = getString(name,String.valueOf(defaultValue));
        return Double.parseDouble(value);
    }

    public boolean getBoolean(String name,boolean defaultValue) {
        String value = getString(name,String.valueOf(defaultValue));
        return Boolean.valueOf(value);
    }

    public Date getDate(String name,String pattern) {
        String value = getString(name,String.valueOf(""));
        try {
            return new SimpleDateFormat(pattern).parse(value);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }

    public File save(MultipartFile file,String path){
        if(!file.isEmpty()){
            File dir = new File(request.getServletContext().getRealPath(path));
            if(!dir.exists()){
                dir.mkdirs();
            }
            try {
                File savedFile = new File(dir,file.getOriginalFilename());
                file.transferTo(savedFile);
                return savedFile;
            } catch (Exception e) {
                // TODO: handle exception
                throw new RuntimeException(e);

            }
        }
        return null;
    }
}

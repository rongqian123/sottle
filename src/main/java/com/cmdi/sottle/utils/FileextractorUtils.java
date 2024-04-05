package com.cmdi.sottle.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/*
 *信息描述，如：类实体名
 *@author Mr.Rong
 *@CreateDate
 */
public class FileextractorUtils {
    public  void gzipextractorMethor() throws IOException {
        String gzFileName = "D:\\TD-LTE_MRO_HUAWEI_OMC1_97918_20240128234500.xml.gz";
        String outputfilePath = "D:\\file.text";
        try {
            FileInputStream fis = new FileInputStream(gzFileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            GZIPInputStream gzipIn = new GZIPInputStream(bis);
            FileOutputStream gzipOut = new FileOutputStream(outputfilePath);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzipIn.read(buffer)) > 0) {
                gzipOut.write(buffer, 0, len);
            }
            gzipIn.close();
            gzipOut.close();
            System.out.println("Successfully extracted gz file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package com.hhx.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.system.ApplicationHome;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

/**
 * @Author su Lichen
 * @Date 2019/11/11 9:57
 */
@Slf4j
public class FileUtil {
    private static final String DEFAULT_PATH = new ApplicationHome(FileUtil.class).getSource().getParentFile().toString();;

    public static Map<String, String> parseYamlFile(File yamlFile) {
        InputStream input = null;
        try {
            input = new FileInputStream(yamlFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            deleteFile(yamlFile);
        }

        Yaml yaml = new Yaml();

        return (Map<String, String>) yaml.load(input);
    }

    public static byte[] getByteByFile(String filePath, String fileName) {
        File file = new File(filePath + File.separator + fileName);

        FileInputStream fis = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
        byte[] b = new byte[1000];
        int n;

        try {
            fis = new FileInputStream(file);

            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }

        } catch (FileNotFoundException e) {
            log.error("file convert inputstream error");
            return null;
        } catch (IOException e) {
            log.error("file output error");
            return null;
        }

        closeInPutSteam(fis);
        closeOutPutSteam(bos);

        return bos.toByteArray();
    }

    public static File getFileByBytes(byte[] bytes) {
        return getFileByBytes(bytes, DEFAULT_PATH, DB.generateUUID());
    }

    public static File getFileByBytes(byte[] bytes, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;


        if (verifyFilePath(filePath)) {
            File dir = new File(filePath);
            dir.mkdirs();
        }

        file = new File(filePath + File.separator + fileName);

        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert fos != null;
        writeFile(bytes, fos);

        return file;
    }

    public static void deleteFile(File file) {
        file.delete();
    }

    private static void writeFile(byte[] fileBytes, OutputStream fos) {
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        try {
            bos.write(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeOutPutSteam(bos);
            closeOutPutSteam(fos);
        }
    }

    private static boolean verifyFilePath(String filePath) {
        return new File(filePath).exists();
    }

    private static boolean verifyFile(String filePath, String fileName) {
        File dir = new File(filePath + File.separator + fileName);

        return dir.exists() && dir.isFile();
    }

    private static void closeOutPutSteam(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeInPutSteam(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

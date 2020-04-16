package com.lhq.boot.demo.resource;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 自定义的协议转换
 */
public class FromHttpProtocolResolver implements ProtocolResolver {
    @Override
    public Resource resolve(String location, ResourceLoader resourceLoader) {
        if (location == null || location.isEmpty() || location.startsWith("http://")) {
            return null;
        }
        byte[] byteArray;
        InputStream inputStream = null;
        try {
            URL url = new URL(location);
            inputStream = url.openStream();
            byteArray = StreamUtils.copyToByteArray(inputStream);
        } catch (MalformedURLException e) {
            throw new RuntimeException("location isn't legal url.", e);
        } catch (IOException e) {
            throw new RuntimeException("w/r err.", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new ByteArrayResource(byteArray);
    }
}

package com.lhq.boot.demo.java.nio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文本管道
 * FileChannel - The FileChannel reads data from and to files.
 * DatagramChannel - The DatagramChannel can read and write data over the network via UDP.
 * SocketChannel - The SocketChannel can read and write data over the network via TCP.
 * ServerSocketChannel - The ServerSocketChannel allows you to listen for incoming TCP connections, like a web server does.
 * For each incoming connection a SocketChannel is created.
 */
public class FileChannelTest {

    /**
     * 文本管道的测试
     * mark <= position <= limit <= capacity
     */
    @Test
    public void channel() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("script/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(12);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            buf.flip();

            while (buf.hasRemaining()) {
                System.out.println((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}

package com.lhq.boot.demo.java.nio;

import io.netty.buffer.ByteBuf;
import org.junit.Test;

import java.io.FileNotFoundException;
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

        ByteBuffer buf = ByteBuffer.allocate(32);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            buf.flip();

            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }

            buf.rewind();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    /**
     * 多个buffer进行操作
     */
    @Test
    public void scanner() throws IOException {
        /**
         * 头buffer 和 尾buffer
         */
        ByteBuffer headerBuffer = ByteBuffer.allocate(4);
        ByteBuffer bodyBuffer = ByteBuffer.allocate(10);

        RandomAccessFile aFile = new RandomAccessFile("script/nio-data.txt", "r");
        ByteBuffer[] buffers = {bodyBuffer, headerBuffer};
        while ((aFile.getChannel().read(buffers)) != -1) {
            System.out.println("先读取header里面的数据----");
            headerBuffer.flip();
            while (headerBuffer.hasRemaining()) {
                System.out.print((char) headerBuffer.get());
            }

            System.out.println("先读取body里面的数据----");
            bodyBuffer.flip();
            while (bodyBuffer.hasRemaining()) {
                System.out.println((char) bodyBuffer.get());
            }
            bodyBuffer.clear();
        }
    }
}

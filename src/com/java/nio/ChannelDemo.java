package com.java.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ChannelDemo {
	public static void main(String[] args) throws IOException {
		// FileChannel
		RandomAccessFile raf = new RandomAccessFile("src/com/java/nio/FileChannel.txt", "rw");
		FileChannel fc = raf.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(48);
		try {
			int bytesRead = fc.read(buf);
			while (bytesRead != -1) {
				buf.flip();
				while (buf.hasRemaining()) {
					System.out.print((char) buf.get());
				}
				buf.clear();
				bytesRead = fc.read(buf);
			}
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Scatter和Gather
		ByteBuffer header = ByteBuffer.allocate(128);
		ByteBuffer body = ByteBuffer.allocate(1024);

		ByteBuffer[] bufferArray = { header, body };

		try {
			// read data from buffers

			fc.read(bufferArray);
			// write data into buffers

			// fc.write(bufferArray);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 两个Channel传输数据（其中一个是FileChannel）
		RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
		FileChannel fromChannel = fromFile.getChannel();

		RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
		FileChannel toChannel = toFile.getChannel();

		long position = 0;
		long count = fromChannel.size();

		toChannel.transferFrom(fromChannel, position, count);
		// fromChannel.transferTo(position, count, toChannel);

		// Selector
		Selector selector = Selector.open();
		SocketChannel socketChannel = SocketChannel.open();// 创建SocketChannel
		socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
		socketChannel.configureBlocking(false);
		SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ);
		while (true) {
			int readyChannels = selector.select();
			if (readyChannels == 0)
				continue;
			Set selectedKeys = selector.selectedKeys();
			Iterator keyIterator = selectedKeys.iterator();
			while (keyIterator.hasNext()) {
				SelectionKey key1 = (SelectionKey) keyIterator.next();
				if (key1.isAcceptable()) {
					// a connection was accepted by a ServerSocketChannel.
				} else if (key1.isConnectable()) {
					// a connection was established with a remote server.
				} else if (key1.isReadable()) {
					// a channel is ready for reading
				} else if (key1.isWritable()) {
					// a channel is ready for writing
				}
				keyIterator.remove();
			}

			// serverSocketChannel
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

			serverSocketChannel.socket().bind(new InetSocketAddress(9999));

			while (true) {
				SocketChannel socketChannel1 = serverSocketChannel.accept();

				// do something with socketChannel...
			}
		}
	}
}
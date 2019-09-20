package com.tony.shop.client;

import java.io.*;
import java.nio.ByteBuffer;

public class SimpleParse {
	private static final String FS = "" +
			"------WebKitFormBoundary2omu88GPtU0xaEN6\n" +
			"Content-Disposition: form-data; name=\"file1\"; filename=\"1.tmp\"\n" +
			"Content-Type: application/octet-stream\n" +
			"\n" +
			"123\n" +
			"456\n" +
			"\n" +
			"------WebKitFormBoundary2omu88GPtU0xaEN6\n" +
			"Content-Disposition: form-data; name=\"file2\"; filename=\".X0-lock\"\n" +
			"Content-Type: application/octet-stream\n" +
			"\n" +
			"      1603\n" +
			"\n" +
			"------WebKitFormBoundary2omu88GPtU0xaEN6--\n" +
			"null";

	public static void main(String[] args) {

	}
}

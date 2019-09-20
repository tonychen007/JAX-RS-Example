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
		String sfile = SimpleParse.class.getClassLoader().getResource("gifp").getFile();
		String line = "";
		String sdoundary = "";
		int st = 0;
		int ed = 0;
		int cnt = 0;
		int bodycnt = 0;
		int line_boundary = 0;
		byte[] bys = new byte[4096];
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024*10);
		StringBuffer sbody = new StringBuffer(1024);

		try {
			BufferedReader br = new BufferedReader(new FileReader(sfile));
			ByteArrayInputStream bai = new ByteArrayInputStream(new FileInputStream(sfile).readAllBytes());
			for (; ; ) {
				if (byteBuffer.position() > 0) {
					break;
				}
				if (bodycnt > 0) {
					br.skip(bodycnt);
				}
				while ((line = br.readLine()) != null) {

					if (line_boundary == 0) {
						sdoundary = line;
						line_boundary = 1;
					}
					ed += line.getBytes().length + 2;   // 2 is \r and \n
					if (line.equals("")) {
						cnt = ed - st;
						ed = st;
						break;
					}
				}

				bai.skip(cnt);
				for (;;) {
					// read bytes
					bai.read(bys);
					byteBuffer.put(bys);
					sbody.append(new String(bys));
					bys = new byte[4096];
					// check if is boundary
					if ((bodycnt = sbody.indexOf(sdoundary)) > -1) {
						byteBuffer.limit(bodycnt);
						break;
					}
				}
			}

		} catch (Exception e) {

		}

		// write to file
		try {
			FileOutputStream fout = new FileOutputStream("/tmp/1.gif");
			byteBuffer.position(0);
			byte[] wb =  new byte[byteBuffer.remaining()];
			byteBuffer.get(wb,0,wb.length);
			fout.write(wb);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int aa = 0;
	}
}

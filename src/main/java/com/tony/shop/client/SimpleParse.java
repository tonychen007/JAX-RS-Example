package com.tony.shop.client;

import java.util.ArrayList;
import java.util.List;

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
		List<String> fileString = new ArrayList<>();

		String[] fs = FS.split("\n");
		String boundary = fs[0];
		int iscont = 0;
		StringBuffer sbuf = new StringBuffer(256);

		for (int i = 0; i < fs.length; i++) {
			String line = fs[i];
			if (line.indexOf(boundary) == -1) {
				// check the first three content-type
				if (iscont == 0) {
					i += 2;   // "Content-Disposition" && "Content-Type"
					if (fs[i].indexOf("Content-Transfer-Encoding") > -1) {
						i++;  // skip line
					}
					iscont = 1;
				} else {
					if (i + 1 < fs.length && fs[i + 1].indexOf(boundary) == -1) {
						sbuf.append(fs[i]);
						sbuf.append("\n");
					}
				}
			} else {
				// another boundary
				if (sbuf.length() == 0)
					continue;

				fileString.add(sbuf.toString());
				sbuf = new StringBuffer(256);
				iscont = 0;

				if (fs[i+1].equals("null"))
					break;
			}
		}

		if (sbuf.length() > 0)
			fileString.add(sbuf.toString());

		int asm3 = 0;
	}
}

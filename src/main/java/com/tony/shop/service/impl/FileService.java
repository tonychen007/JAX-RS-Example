package com.tony.shop.service.impl;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.*;
import java.io.*;

@Path("/file")
public class FileService {
	private static final String BASEDIR = "/";

	/**
	 * @param path
	 * @return FileInputStream
	 * curl http://localhost:8080/services/file/tmp/1.tmp
	 */
	@GET
	@Path("stream/{filepath: .*}")
	@Produces("text/plain")
	public InputStream getFileStream(@PathParam("filepath") String path) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(BASEDIR + path);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return file;
	}

	/**
	 * @param path
	 * @return File
	 * curl http://localhost:8080/services/file/tmp/1.tmp
	 */
	@GET
	@Path("{filepath: .*}")
	@Produces("text/plain")
	public File getFile(@PathParam("filepath") String path) {
		File file = null;
		try {
			file = new File(BASEDIR + path);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return file;
	}


	/**
	 *
	 * @param file, the whole filepart, including "--------XXXXXX content-type"
	 * @return
	 *
	 */
	@Path("post")
	@POST
	@Produces("text/plain")
	public String postFile(File file) {
		StringBuffer sb = new StringBuffer(1024);
		try {
			FileReader fr = new FileReader(file);
			LineNumberReader lnr = new LineNumberReader(fr);
			String line = null;
			do {
				line = lnr.readLine();
				sb.append(line);
				sb.append("\n");
			} while (line != null);
		} catch (Exception e) {

		}

		return sb.toString();
	}
}

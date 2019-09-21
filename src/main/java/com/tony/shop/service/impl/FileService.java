package com.tony.shop.service.impl;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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


    @Path("post")
    @POST
    @Produces("text/plain")
    public String postFile(MultipartFormDataInput file) {
        file.getFormData();
        return "ok";
    }

    @Path("rawdata")
    @POST
    @Produces("text/plain")
    // curl -d "abc" http://....
	public String postRawdata(byte[] bys) {
    	return "bys";
    }

    @Path("formdata")
	@POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/x-www-form-urlencoded")
    // curl -d "first=tony&last=chen" http://....
    public MultivaluedMap<String,String> post(MultivaluedMap<String,String> data) {
    	return data;
    }

}

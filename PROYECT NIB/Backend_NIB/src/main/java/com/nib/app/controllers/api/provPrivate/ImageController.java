package com.nib.app.controllers.api.provPrivate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nib.app.model.service.PostService;
import com.nib.app.objects.BinaryFile;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = {"*"},methods= {RequestMethod.GET,RequestMethod.POST})	
public class ImageController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/get/{id_image}")
	 public ResponseEntity<?> getImage(
			 @PathVariable("id_image") Long id_image
			 ) {
        try {
        	BinaryFile f = postService.getImageById_Post(id_image);
        	 // Carga la imagen desde un archivo o una base de datos
            byte[] imagenBytes = f.getData();
     
            if(imagenBytes == null) {
            	return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
            }
            
            // Crea una respuesta HTTP con la imagen y los encabezados adecuados
            HttpHeaders headers = new HttpHeaders();
            if(f.getFormat().contains("png")) {
            	headers.setContentType(MediaType.IMAGE_PNG);
            }else if(f.getFormat().contains("jpg")) {
            	headers.setContentType(MediaType.IMAGE_JPEG);
            }else if(f.getFormat().contains("gif")) {
            	headers.setContentType(MediaType.IMAGE_GIF);
            }else {
            	headers.setContentType(MediaType.IMAGE_PNG);
            }
            
            headers.setContentLength(imagenBytes.length);
            
            return new ResponseEntity<byte[]>(imagenBytes, headers, HttpStatus.OK);
            
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
	/*
    @PostMapping("/save")
    public ResponseEntity<?> saveImage(@RequestBody PO data) {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(data.getData());
            // Aquí se puede guardar la imagen en el servidor o en una base de datos
            
            
            return new ResponseEntity<>("Imagen guardada correctamente", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("La imagen no está en formato Base64", HttpStatus.BAD_REQUEST);
        }
    }
    */
}

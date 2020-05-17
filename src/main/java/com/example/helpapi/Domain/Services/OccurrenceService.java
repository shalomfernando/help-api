package com.example.helpapi.Domain.Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helpapi.Domain.Commands.CustomerCommands.Outputs.OccurrenceMapsTO;
import com.example.helpapi.Domain.Models.Occurrence;
import com.example.helpapi.Infra.Repository.OccurrenceRepository;
@Service
public class OccurrenceService implements IOccurrenceService {
	
	@Autowired
	OccurrenceRepository repository;
	
	
	public Occurrence register(Occurrence occurrence) {
		occurrence.setPathFoto(decode(occurrence.getPathFoto()));
		return repository.save(occurrence);
	}
	public List<Occurrence> findAll(){
		List<Occurrence> occurreceList = repository.findAll();
		for(Occurrence o: occurreceList) {
			o.setImage(encoder(o.getPathFoto()));
		}
		return occurreceList ;
	}
	
	public List<OccurrenceMapsTO> findAllMaps(){
		List<Occurrence> occurreceList = repository.findAll();
		List<OccurrenceMapsTO> list = new ArrayList<OccurrenceMapsTO>()  ;
		for(Occurrence o: occurreceList) {
			o.setImage(encoder(o.getPathFoto()));
			list.add(new OccurrenceMapsTO(o));
		}
		 
		return   list ;
	}
	
	public Occurrence findByIdandName(int id, String name){
//		Occurrence occurrence = repository.findByIdandName(id, name) ;
//		occurrence.setImage(encoder(occurrence.getPathFoto()));
//		return occurrence;
		return null;
	}

	@Override
	public String decode(String imageString) {
		String path;
		Path currentPath = Paths.get("");
		Path absolutePath = currentPath.toAbsolutePath();
		String pathBase = absolutePath + "/src/main/resources/static/fotos/Imagem";
 		path = geraPath(pathBase);
 		
		path = path.replace("\\", "/");

		try (FileOutputStream imageOutFile = new FileOutputStream(path)) {	
 			byte[] imageByteArray = Base64.getDecoder().decode(imageString);
		    imageOutFile.write(imageByteArray);
		} 
		catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} 
		catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return path;
	}

	@Override
	public String geraPath(String path) {
		String idString =  String.valueOf(01);
 		Integer id = repository.findAll().size() < 1  ? 0 : repository.findAll().size();
 		if(id != null)
 			idString = String.valueOf(id+1);
 		
		path = path + "-" + idString + ".png";	
		return path;
	}
	
	@Override
	public String encoder(String imagePath) {
		String base64Image = "";
	    File file = new File(imagePath);
	    try (FileInputStream imageInFile = new FileInputStream(file)) {
 	      byte imageData[] = new byte[(int) file.length()];
	      imageInFile.read(imageData);
	      base64Image = Base64.getEncoder().encodeToString(imageData);
	    } catch (FileNotFoundException e) {
	      System.out.println("Image not found" + e);
	    } catch (IOException ioe) {
	      System.out.println("Exception while reading the Image " + ioe);
	    }
	    return base64Image;
	 }

}

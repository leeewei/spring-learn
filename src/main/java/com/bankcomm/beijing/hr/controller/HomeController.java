package com.bankcomm.beijing.hr.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bankcomm.beijing.hr.entity.User;
import com.bankcomm.beijing.hr.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private UserService userService;
	
	
	@RequestMapping(value = "/users/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/users/import",method=RequestMethod.POST)
	public void importFromFile(@RequestParam(value="file",required=false) MultipartFile file,Model model){
		logger.debug("file name:"+file.getOriginalFilename());
		logger.debug("file size:"+file.getSize());
	}
	/**
	 * 
	 * @param files 上传的多个文件，html的input元素里name必须跟参数名相同
	 * @param model
	 */
	@RequestMapping(value="/users/imports",method=RequestMethod.POST)
	public void importFromFile(@RequestParam(value="file1") MultipartFile[] files,Model model){
		logger.debug("files count:"+files.length);
		for(MultipartFile file:files){
			logger.debug("file name:"+file.getOriginalFilename());
			logger.debug("file size:"+file.getSize());
			logger.debug("file type:"+file.getContentType());
			logger.debug("\n");
		}
	}
	@RequestMapping(value="/users",method=RequestMethod.GET,produces={"application/json"})
	public @ResponseBody List<User> list(){
		return userService.getUserList();
	}
	@RequestMapping(value="/users/{username}",method=RequestMethod.GET,produces={"application/xml"})
	public @ResponseBody User get(@PathVariable(value="username")String username){
		return userService.getUser(username);
	}

    @RequestMapping("/users/download")  
    public ResponseEntity<byte[]> download() throws IOException {  
        HttpHeaders headers = new HttpHeaders();  
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);  
        headers.setContentDispositionFormData("attachment", "ehcache.xml");  
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File("D:\\531\\dev_soft\\eclipse\\workspace\\hr_re\\src\\main\\resources\\ehcache.xml")),  
                                          headers, HttpStatus.CREATED);  
    }  

}

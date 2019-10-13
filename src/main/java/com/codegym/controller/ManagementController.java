package com.codegym.controller;

import com.codegym.model.MyFile;
import com.codegym.model.Person;
import com.codegym.model.Position;
import com.codegym.service.PersonService;
import com.codegym.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class ManagementController {
    @Autowired
    private PersonService personService;

    @Autowired
    private PositionService positionService;

    @ModelAttribute("position")
    public Iterable<Position> allPosition(){
        return positionService.findAll();
    }


    @GetMapping("home")
    public ModelAndView home(@RequestParam("s") Optional<String> s,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "5") int size, Pageable pageable){
        pageable= new PageRequest(page,size);
        ModelAndView modelAndView = new ModelAndView("home");
        Page<Person> personPage;
        if (s.isPresent()){
            personPage=personService.search(s.get(),pageable);
            modelAndView.addObject("search", s.get());
        }else {
            personPage=personService.findAll(pageable);
            modelAndView.addObject("search", "");
        }

        modelAndView.addObject("persons",personPage);


        return modelAndView;
    }
    //Add member
    @GetMapping("create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("create","persons",new Person());

        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView addMember(Person person){
        ModelAndView modelAndView=new ModelAndView("upload");
        Person newPerson =personService.save(person);
        modelAndView.addObject("person",newPerson);
        modelAndView.addObject("myFile", new MyFile());

        return modelAndView;

    }

    //edit

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("person",personService.findOne(id));


        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(Person person){
        ModelAndView modelAndView = new ModelAndView("edit");
        personService.save(person);
        modelAndView.addObject("person", person);
        modelAndView.addObject("message","update success");
        return modelAndView;
    }

    //delete
    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("person",personService.findOne(id));

        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("delete");
        Person person = personService.findOne(id);
        personService.delete(id);
        modelAndView.addObject("person", person);
        modelAndView.addObject("message","Delete success");
        return modelAndView;
    }

    //Info
    @GetMapping("/info/{id}")
    public ModelAndView info(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("person",personService.findOne(id));
        modelAndView.addObject("myFile", new MyFile());
        return modelAndView;
    }



























    //Up load images
    @RequestMapping(value = "/uploadFile/{id}", method = RequestMethod.POST)
    public String uploadFile(@PathVariable long id,MyFile myFile, Model model) throws IOException {



            MultipartFile multipartFile = myFile.getMultipartFile();
            String fileName = multipartFile.getOriginalFilename();
            Person person=personService.findOne(id);
            person.setImg(fileName.intern());
            personService.save(person);

            System.out.println(fileName.intern());
            File file = new File("/home/min2208/Documents/tomcat/apache-tomcat-8.5.46/webapps/ROOT/images/", fileName);
            multipartFile.transferTo(file);


        return "redirect:/home";
    }




}

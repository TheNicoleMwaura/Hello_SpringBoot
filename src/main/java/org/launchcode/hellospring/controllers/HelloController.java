package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *@GetMapping("pathname").
 * If the pathname value is null, then the path used is the index path, or / root path.
 */
@Controller //tells spring boot that methods in this class handle http requests
//@RequestMapping(value="hello") //starts every method with /hello
public class HelloController {
    //Handles request at path/hello
//    @GetMapping("") //method should handle only get requests
//    @ResponseBody //tells spring boot method returns a plain text http response
//    public String Hello(){ //method leaves at root path if you don't specify the path
//        return "Hello, Spring!";
//    }
     //handles request at /hello/goodbye
    @PostMapping("goodbye") // handles post requests
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handles both get and post requests with the same path  /hello/hellogoodbye
    @RequestMapping(value="hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hellogoodbye() {
       return "hello and goodbye";
    }

    //handles requests of the form /hello?name=LaunchCode
    @RequestMapping(value ="hello",method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model){//expects a name parameter
        String thegreeting ="Hello, " + name +"!";
        model.addAttribute("greeting", thegreeting);
        return "hello";

    }

    // Responds to get requests at /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        //String thegreeting =;
        model.addAttribute("greeting", "Hello, " + name +"!");
        return "hello";
    }

    //path /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form" ;
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String>names = new ArrayList<>();
        names.add("Code");
        names.add("Java");
        names.add("Python");
        names.add("JavaScript");

        model.addAttribute("names", names);
        return "hello-list";
    }
}


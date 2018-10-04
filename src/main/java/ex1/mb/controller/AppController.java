package ex1.mb.controller;

import ex1.mb.service.CreateTable;
import ex1.mb.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    //1.  @Value("first spring bean!")
    private Message message;

    @Qualifier("myServiceImpl")
    @Autowired
    //3. @Qualifier("main")
    private MyService myService;

    @Autowired
    private CreateTable createTable;

   /*1. @Value("second spring bean!")
    private final Word word;

    @Autowired
    public AppController(Word word) {
        this.word = word;
    }*/

    /*2.  @RequestMapping("/")
      public String getHomePage(Model model) {
          model.addAttribute("name", message.getName());
        //1.  model.addAttribute("name", word.getName());
          return "home";
      }*/
// localhost:8080/
    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("name", myService.getName());
        return "home";
    }

    // localhost:8080/name/asdasd
    @RequestMapping("/name/{name}")
    public String getName(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/create")
    public String createTable(Model model) {
        model.addAttribute("status", createTable.getTableCreationStatus());
        return "create";
    }
}

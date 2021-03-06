package ex1.mb.controller;

import ex1.mb.service.CreateTable;
import ex1.mb.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
public class AppController {
    private static final Logger log = LoggerFactory.getLogger(AppController.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    //1.  @Value("first spring bean!")
    private Message message;
    @Qualifier("myServiceImpl")
    @Autowired
    //3. @Qualifier("main")
    private MyService myService;
    @Autowired
    private CreateTable createTable;

    public void setMyService(MyService myService) {
        this.myService = myService;
    }

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
        log.info("Current time {}", dateFormat.format(new Date()));
        model.addAttribute("name", myService.getName());
        return "home";
    }

    // localhost:8080/  наш Cat
    @RequestMapping("/catinfo")
    public String getCatPage() {
        return "cat";
    }

    // localhost:8080/name/{}
    @RequestMapping("/name/{name}")
    public String getName(@PathVariable("name") String name, Model model) {
        model.addAttribute("name",name);
        return "hello";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/create")
    public String createTable(Model model) {
        model.addAttribute("status", createTable.getTableCreationStatus());
        return "create";
    }

    @RequestMapping(value = "/password/{password}", method = RequestMethod.GET)
    public String getCryptPassword(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("encodePassword", new BCryptPasswordEncoder().encode(password));
        return "password";
    }

    // localhost:8080/sec  моя вторая страничка
    @RequestMapping("/sec")
    public String getSecondPage() {
        return "second";
    }

    // localhost:8080/my_flowers ссылка
    @RequestMapping("/my_flowers")
    public String getFlowers() {
        return "my_flowers";
    }

    // localhost:8080/frame ссылка
    @RequestMapping("/frame")
    public String getFrame() {
        return "frame";
    }

    // localhost:8080/enter ссылка
    @RequestMapping("/enter")
    public String getEnter() {
        return "enter";
    }


    // localhost:8080/ userinfo
    @RequestMapping("/userinfo")
    public String getUserPage() {
        return "userinfo";
    }

    // localhost:8080/private
    @RequestMapping("/private")
    public String getPrivate() {
        return "private";
    }


}

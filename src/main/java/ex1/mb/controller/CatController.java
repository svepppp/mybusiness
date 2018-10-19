package ex1.mb.controller;

import ex1.mb.entity.Cat;
import ex1.mb.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/cat")
public class CatController {


    @Autowired
    private CatService catService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
       public Cat addCat(@RequestBody Cat cat){    //кастим к Cat
         catService.addCat(cat);
        return cat;
    }

    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Cat getCatById(@PathVariable(value = "id") long id){
        return catService.getCatById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public List<Cat> getAllCats(){
        return catService.getAllCats();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public Cat updateCat(@RequestBody Cat cat){
        return catService.updateCat(cat);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    public Cat deleteCat(@PathVariable(value = "id") long id){
        return catService.deleteCat(id);
    }
}

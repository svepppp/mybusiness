package ex1.mb.controller;


import ex1.mb.service.MyService;
import ex1.mb.service.impl.MyServiceImpl;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AppControllerIntegrationTest {
   private MyService myService;

    @Test
    public void testGetFlowers() {
        AppController appController = new AppController();
        String viewName = appController.getFlowers();
        assertEquals("my_flowers", viewName);
    }

    @Test
    public void testGetSecondPage() {
        AppController appController = new AppController();
        String viewName = appController.getSecondPage();
        assertEquals("second", viewName);
    }

    @Test
    public void testGetCatPage() {
        AppController appController = new AppController();
        HashMap<String, Object> model = new HashMap<String, Object>();

        String viewName = appController.getCatPage(model);
        assertEquals("cat", viewName);
    }

    @Test
    public void testGetHomePage() {
        myService = new MyServiceImpl();
        class ModelHome implements Model {

            @Override
            public Model addAttribute(String s, Object o) {
                return new ModelHome();
            }

            @Override
            public Model addAttribute(Object o) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> collection) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> map) {
                return new ModelHome();
            }

            @Override
            public Model mergeAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public boolean containsAttribute(String s) {
                return false;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        }

        Model model = new ModelHome();
        String viewName = getHomePage(model);
        assertEquals("home", viewName);
        assertEquals("ОСЕНЬ!", myService.getName());
    }

    private String getHomePage(Model model) {
        model.addAttribute("name", myService.getName());
        return "home";
    }
}
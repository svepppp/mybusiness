package ex1.mb.controller;


import ex1.mb.service.MyService;
import ex1.mb.service.impl.MyServiceImpl;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class AppControllerIntegrationTest {

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
        String viewName = appController.getCatPage();
        assertEquals("cat", viewName);
    }

    @Test
    public void testGetHomePage() {
        MyService myService;
        AppController appController = new AppController();
        myService = new MyServiceImpl();
        appController.setMyService(myService);
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
        String viewName = appController.getHomePage(model);
        assertEquals("home", viewName);
        assertEquals("ОСЕНЬ!", myService.getName());
    }

    @Test
    public void testGetName() {
        AppController appController = new AppController();
        class ModelHello implements Model {

            @Override
            public Model addAttribute(String s, Object o) {
                return new ModelHello();
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
                return new ModelHello();
            }

            @Override
            public Model mergeAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public boolean containsAttribute(String s) {
                boolean b = false;
                if (s.equals("Sveta")) {
                    b = true;
                }
                return b;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        }

        Model model = new ModelHello();
        String sname = "Sveta";
        String viewName = appController.getName(sname, model);
        assertEquals("hello", viewName);
        assertTrue(model.containsAttribute(sname));
    }

    @Test
    public void testGetUserPage() {
        AppController appController = new AppController();
        String viewName = appController.getUserPage();
        assertEquals("userinfo", viewName);
    }

    @Test
    public void testGetEnter() {
        AppController appController = new AppController();
        String viewName = appController.getEnter();
        assertEquals("enter", viewName);
    }

    @Test
    public void testGetFrame() {
        AppController appController = new AppController();
        String viewName = appController.getFrame();
        assertEquals("frame", viewName);
    }

    @Test
    public void testGetPrivate() {
        AppController appController = new AppController();
        String viewName = appController.getPrivate();
        assertEquals("private", viewName);
    }
}



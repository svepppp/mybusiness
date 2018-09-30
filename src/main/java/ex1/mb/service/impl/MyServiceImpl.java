package ex1.mb.service.impl;

import ex1.mb.service.MyService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("sigleton")
//@Scope("prototype")
//@Scope("request")
//@Scope("session")
//@Scope("global session")
@Scope("application")
public class MyServiceImpl implements MyService {
    @Override
    public String getName() {
        return "bean from interface";
    }

    @PostConstruct
    private void init() {
        System.err.println("Before init");
    }

    @PreDestroy
    public void cleanUp() {
        System.err.println("Before destroy");
    }
}

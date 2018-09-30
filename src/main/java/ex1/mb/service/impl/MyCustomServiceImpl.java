package ex1.mb.service.impl;

import ex1.mb.service.MyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("main")

public class MyCustomServiceImpl implements MyService {
    @Override
    public String getName() {
        return "custom bean from imterface";
    }
}

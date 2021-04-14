package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoSerivce logDemoSerivce;
    private final MyLogger myLogger;
}

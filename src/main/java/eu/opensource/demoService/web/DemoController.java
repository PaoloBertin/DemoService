package eu.opensource.demoService.web;

import eu.opensource.demoService.web.util.DemoInput;
import eu.opensource.demoService.web.util.DemoOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/service1")
@RestController
public class DemoController {

    @PostMapping("/calculate")
    public ResponseEntity<DemoOutput> operations(@RequestBody DemoInput demoInput) {

        double value1 = demoInput.getValue1();
        double value2 = demoInput.getValue2();
        String op = demoInput.getOp();

        DemoOutput demoOutput = new DemoOutput();
        switch (op) {
            case "div" -> {
                if (value2 != 0.0) {
                    demoOutput.setResult(value1 / value2);
                    demoOutput.setMessage("ok");
                }
            }
            case "mul" -> {
                demoOutput.setResult(value1 * value2);
                demoOutput.setMessage("ok");
            }
            case "sum" -> {
                demoOutput.setResult(value1 + value2);
                demoOutput.setMessage("ok");
            }
            case "sub" -> {
                demoOutput.setResult(value1 - value2);
                demoOutput.setMessage("ok");
            }
            default -> demoOutput.setMessage("invalid operation");
        }

        return ResponseEntity.ok(demoOutput);
    }
}

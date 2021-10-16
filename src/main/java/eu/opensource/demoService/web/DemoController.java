package eu.opensource.demoService.web;

import eu.opensource.demoService.web.util.DemoInput;
import eu.opensource.demoService.web.util.DemoOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/service1")
@RestController
public class DemoController {

    @PostMapping("/calculate")
    public ResponseEntity<DemoOutput> operations(@RequestBody DemoInput demoInput) {

        double value1 = demoInput.getValue1();
        double value2 = demoInput.getValue2();
        String op = demoInput.getOp();

        DemoOutput demoOutput = new DemoOutput();
        if (op.equals("div")) {
            double quotient = value1 / value2;
            demoOutput.setResult(quotient);
        }

        return ResponseEntity.ok(demoOutput);
    }
}

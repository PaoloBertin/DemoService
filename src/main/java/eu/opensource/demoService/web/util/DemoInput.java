package eu.opensource.demoService.web.util;

public class DemoInput {

    private double value1;

    private double value2;

    private String op;

    public DemoInput(double value1, double value2, String op) {

        this.value1 = value1;
        this.value2 = value2;
        this.op = op;
    }

    public double getValue1() {

        return value1;
    }

    public void setValue1(double value1) {

        this.value1 = value1;
    }

    public double getValue2() {

        return value2;
    }

    public void setValue2(double value2) {

        this.value2 = value2;
    }

    public String getOp() {

        return op;
    }

    public void setOp(String op) {

        this.op = op;
    }
}

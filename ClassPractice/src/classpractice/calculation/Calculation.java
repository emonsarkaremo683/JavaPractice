package classpractice.calculation;

public class Calculation {

    public double priceCalculation(double up, double qt) {
        
        double[] disc = {0.02, 0.03, 0.04};
        double[] range = {100, 200, 400};

        double ap = up * qt;
        double result = 0;

        if (ap > range[range.length - 1]) {
            return ap - (ap * 0.05);
        }

        for (int i = 0; i < range.length; i++) {
            if (ap <= range[i]) {
                result = ap - (ap * disc[i]);
                break;
            }
        }

        return result;
    }

}

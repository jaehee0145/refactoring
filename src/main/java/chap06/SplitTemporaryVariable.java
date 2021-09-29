package chap06;

public class SplitTemporaryVariable {
    private double primaryForce;
    private double mass;
    private int delay;

    double getDistanceTravelled (int time) {
        double result;
        double acc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            double primaryVel = acc * delay;
            // acc 에 값이 두번 대입되는 것이 좋지 않다!
            // 용도가 다른데 acc 하나로 사용됨
            acc = (primaryForce + secondaryTime) / mass;
            result += primaryVel * secondaryTime + 0.5 *
                    acc * secondaryTime * secondaryTime;
        }
        return result;
    }

    double getDistanceTravelled2 (int time) {
        double result;
        final double primaryAcc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * primaryAcc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            double primaryVel = primaryAcc * delay;
            final double secondaryAcc = (primaryForce + secondaryTime) / mass;
            result += primaryVel * secondaryTime + 0.5 *
                    secondaryAcc * secondaryTime * secondaryTime;
        }
        return result;
    }
}

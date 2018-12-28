package gameMechanics;

public class GravityMechanics {

    private static final double GRAVITY = 9.8;

    private double deg2Rad(double degrees)
    {
        return (Math.PI / 180) * degrees;
    }
    public double distance(double velocity, double angle)
    {
        return Math.pow(velocity,2)/GRAVITY * Math.sin(2 * deg2Rad(angle));
    }
}

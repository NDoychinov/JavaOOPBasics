package Ex3_StaticMembers.Problem6_PlanckConstant;

/**
 * Created by Niki on 24.6.2016 г..
 */
public class Calculation {
    public static final double planckConst = 6.62606896e-34d;
    public static final double pi = 3.14159d;

    public static double reducedPlanck(){
        return planckConst / (2 * pi);
    }
}

package Ex3_StaticMembers.Problem8_ShapesVolume;

/**
 * Created by Niki on 24.6.2016 г..
 */
public class VolumeCalculator {

    public static double VolumeCube(Cube cube){
        return Math.pow(cube.sideLenght, 3);
    }

    public static double CylinderVolume(Cylinder cylinder){
        return Math.PI * Math.pow(cylinder.radius, 2) * cylinder.height;
    }

    public static double TrianglePrismVolume(TriangularPrism triangularPrism){
        return (triangularPrism.lenght / 2) * triangularPrism.baseSide * triangularPrism.baseSideHeight;
    }
}

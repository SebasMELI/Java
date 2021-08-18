package utilitario;

import geometria.FiguraGeometrica;

public class Utilitario {

    public static double areaPromedio (FiguraGeometrica arr[]){

        double areaPromedio = 0;

        for (FiguraGeometrica figuraGeometrica:arr) {
            areaPromedio += figuraGeometrica.area();
        }

        return areaPromedio;
    }

}

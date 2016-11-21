package ua.training;

/**
 * Created by andrii on 21.11.16.
 */
public class AdapterApp {
    public static void main(String[] args) {
        // 1st way through inheritance
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();;
        g1.drawSquare();
        // 2nd way through composition
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2(
                new RasterGraphics());
        g2.drawLine();;
        g2.drawSquare();

    }
}

interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Draw a line");
    }
    void drawRasterSquare() {
        System.out.println("Draw a square");
    }
}

class VectorAdapterFromRaster extends RasterGraphics
implements VectorGraphicsInterface{
    @Override
    public void drawLine() {
        drawRasterLine();
    }
    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
    RasterGraphics raster = null; //new RasterGraphics();

    public VectorAdapterFromRaster2(RasterGraphics raster) {
        this.raster = raster;
    }

    @Override
    public void drawLine() {
        raster.drawRasterLine();
    }
    @Override
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}
